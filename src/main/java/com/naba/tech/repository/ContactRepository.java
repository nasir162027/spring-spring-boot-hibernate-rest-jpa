package com.naba.tech.repository;

import com.naba.tech.constants.NabaSchoolConstants;
import com.naba.tech.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {


    List<Contact> findByStatus(String status);
}