package com.naba.tech.repository;


import com.naba.tech.model.Contact;
import com.naba.tech.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HolidaysRepository extends CrudRepository<Holiday,String> {
}
