package com.naba.tech.repository;

import com.naba.tech.constants.NabaSchoolConstants;
import com.naba.tech.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {


    List<Contact> findByStatus(String status);

    //@Query("SELECT c FROM Contact c WHERE c.status = :status")
    @Query(value = "SELECT * FROM contact_msg c WHERE c.status = :status",nativeQuery = true)
    Page<Contact> findByStatus(String status, Pageable pageable);
}