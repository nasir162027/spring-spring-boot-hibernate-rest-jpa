package com.naba.tech.repository;

import com.naba.tech.model.NabaClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NabaClassRepository extends JpaRepository<NabaClass, Integer> {
}