package com.naba.tech.repository;

import com.naba.tech.constants.NabaSchoolConstants;
import com.naba.tech.model.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {


    List<Contact> findByStatus(String status);

    Page<Contact> findByStatus(String status, Pageable pageable);
}