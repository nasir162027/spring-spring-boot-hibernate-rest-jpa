package com.naba.tech.service;


import com.naba.tech.constants.NabaSchoolConstants;
import com.naba.tech.model.Contact;
import com.naba.tech.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        Contact saveContact= contactRepository.save(contact);
        if(null!=saveContact && saveContact.getContactId()>0) {
            isSaved = true;
        }
        return isSaved;
    }

    public Page<Contact> findMsgsWithOpenStatus(int pageNum,String sortField, String sortDir){
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNum - 1, pageSize,
                sortDir.equals("asc") ? Sort.by(sortField).ascending()
                        : Sort.by(sortField).descending());
        Page<Contact> msgPage = contactRepository.findByStatus(
                NabaSchoolConstants.OPEN,pageable);
        return msgPage;
    }

    public boolean updateMsgStatus(int contactId){

        Optional<Contact> contact = contactRepository.findById( contactId );
        contact.ifPresent(contact1 ->{
            contact1.setStatus(NabaSchoolConstants.CLOSE);
        } );
        boolean isUpdated = false;
        Contact updateContact= contactRepository.save(contact.get());
        if(null!=updateContact &&  updateContact.getUpdatedBy()!=null) {
            isUpdated = true;
        }
        return isUpdated;
    }
}
