package com.geekster.Food_delivery.services;

import com.geekster.Food_delivery.dto.SignInInput;
import com.geekster.Food_delivery.dto.SignInOutput;
import com.geekster.Food_delivery.dto.SignUpOutput;
import com.geekster.Food_delivery.models.AuthenticationToken;
import com.geekster.Food_delivery.models.User;
import com.geekster.Food_delivery.repos.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepo iUserRepository;

    @Autowired
    private TokenService tokenService;

    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    public SignUpOutput signUp(User signUpInput) {
        User user = iUserRepository.findFirstByUserEmail(signUpInput.getUserEmail());
        if(user != null){
            throw new IllegalStateException("User already exist");
        }

        String encryptedPassword = null;

        try{
            encryptedPassword = encryptPassword(signUpInput.getUserPassword());
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        signUpInput.setUserPassword(encryptedPassword);
        iUserRepository.save(signUpInput);
        return new SignUpOutput(HttpStatus.ACCEPTED,"User created successfully");
    }

    public String encryptPassword(String userPassword) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");

        md5.update(userPassword.getBytes());
        byte[] digested = md5.digest();

        String hash = DatatypeConverter.printHexBinary(digested);

        return hash;
    }

    public SignInOutput signIn(SignInInput signInInput){
        User user = iUserRepository.findFirstByUserEmail(signInInput.getUserEmail());

        if(user == null)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        String encryptedPassword = null;

        try {
            encryptedPassword = encryptPassword(signInInput.getUserPassword());
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        //match it with database encrypted password

        boolean isPasswordValid = encryptedPassword.equals(user.getUserPassword());

        if(!isPasswordValid)
        {
            throw new IllegalStateException("User invalid!!!!...sign up instead");
        }

        AuthenticationToken token = new AuthenticationToken(user);

        tokenService.saveToken(token);

        //set up output response

        return new SignInOutput("Authentication Successfull !!!", token.getToken());


    }
}
