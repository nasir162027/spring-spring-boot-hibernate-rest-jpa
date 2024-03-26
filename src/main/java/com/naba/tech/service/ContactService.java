package com.naba.tech.service;


import com.naba.tech.constants.NabaSchoolConstants;
import com.naba.tech.model.Contact;
import com.naba.tech.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact){
        boolean isSaved = false;
        contact.setStatus( NabaSchoolConstants.OPEN);
        contact.setCreatedBy(NabaSchoolConstants.ANONYMOUS);
        contact.setCreatedAt( LocalDateTime.now());
        int result = contactRepository.saveContactMsg(contact);
        if(result>0) {
            isSaved = true;
        }
        return isSaved;
    }
}
