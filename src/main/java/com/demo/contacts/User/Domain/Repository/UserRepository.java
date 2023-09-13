package com.demo.contacts.User.Domain.Repository;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/*
Repository works with helps of JPA and contain methods to interact with a DB
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
