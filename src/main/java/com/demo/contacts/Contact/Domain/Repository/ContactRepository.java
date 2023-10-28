package com.demo.contacts.Contact.Domain.Repository;

import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import com.demo.contacts.User.Persistence.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactEntity, Long> {}
