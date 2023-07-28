package com.geekster.Food_delivery.repos;

import com.geekster.Food_delivery.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User,Long> {
    User findByUserId(Long userId);

    User findFirstByUserEmail(String userEmail);
}
