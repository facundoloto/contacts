package com.demo.contacts.User.Domain.Repository;
import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Repository works with helps of JPA and contain methods to interact with a DB
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
//@Query("SELECT u FROM User u WHERE u.email =:email")
//      UserEntity findByEmail(@Param("email")String email);
UserEntity findByEmail(String email);
};
