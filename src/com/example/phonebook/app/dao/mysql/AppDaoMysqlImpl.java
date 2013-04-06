package com.example.phonebook.app.dao.mysql;

import com.example.phonebook.app.dao.AppDao;
import com.example.phonebook.app.dto.Contact;
import com.example.phonebook.login.dto.User;

import java.util.List;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:15 AM
 */
public class AppDaoMysqlImpl implements AppDao {

    @Override
    public List getContacts(User user, String search) throws Exception {
        if(search!= null && search.length()>0){
            return new HomeDaoMysql().searchContacts(user,search);

        }else {
            return new HomeDaoMysql().getContacts(user);
        }
    }

    @Override
    public void addContact(Contact contact) throws Exception {
        new ContactDaoMysql().addContact(contact);
    }

    @Override
    public Contact getContact(Integer contactId, User user) throws Exception {

        return new ContactDaoMysql().getContact(contactId,user);
    }

    @Override
    public void updateContact(Contact contact, User user) throws Exception {
        new ContactDaoMysql().updateContact(contact,user);
    }

    @Override
    public void deleteContact(Contact contact, User user) throws Exception {
        new ContactDaoMysql().deleteContact(contact,user);

    }


}
