package com.example.phonebook.app.dao;

import com.example.phonebook.app.dto.Contact;
import com.example.phonebook.login.dto.User;

import java.util.List;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:15 AM
 */
public interface AppDao {
    public List getContacts(User user, String search) throws Exception;

    void addContact(Contact contact) throws Exception;

    Contact getContact(Integer contactId, User user) throws Exception;

    void updateContact(Contact contact, User user)throws Exception;

    void deleteContact(Contact contact, User user) throws Exception;
}
