package com.naba.tech.service;


import com.naba.tech.constants.NabaSchoolConstants;
import com.naba.tech.model.Contact;
import com.naba.tech.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    public List<Contact> findMsgsWithOpenStatus(){
        List<Contact> contactMsgs = contactRepository.findMsgsWithStatus(NabaSchoolConstants.OPEN);
        return contactMsgs;
    }

    public boolean updateMsgStatus(int contactId, String updatedBy){
        boolean isUpdated = false;
        int result = contactRepository.updateMsgStatus(contactId,NabaSchoolConstants.CLOSE, updatedBy);
        if(result>0) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
