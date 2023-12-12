package com.demo.contacts.Contact.Domain.Repository;

import com.demo.contacts.Contact.Persistence.Entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    @Query("SELECT c FROM Contact c INNER JOIN c.user u WHERE u.id = :userId")
    List<ContactEntity> findContactByUserId(@Param("userId") Long userId);
}
