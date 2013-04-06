package com.example.phonebook.app.dao.mysql;

import com.example.phonebook.app.dto.Contact;
import com.example.phonebook.common.BaseDao;
import com.example.phonebook.login.dto.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:16 AM
 */
public class HomeDaoMysql extends BaseDao {

    public List getContacts(User user) throws Exception {
        List contacts = new ArrayList();
        query = "Select * from contact where user_id=?";


        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setMiddleName(resultSet.getString("middle_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setPhone(resultSet.getString("phone"));
                contact.setAddress(resultSet.getString("address"));
                contact.setUserId(resultSet.getInt("user_id"));
                contact.toString();
                contacts.add(contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return contacts;
    }

    public List searchContacts(User user, String search) throws Exception {
        List contacts = new ArrayList();
        query = "Select * from contact where user_id=? and (first_name like ? or middle_name like ? or last_name like ? or address like ? or phone like ?)";


        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setString(2, "%" + search + "%");
            preparedStatement.setString(3, "%" + search + "%");
            preparedStatement.setString(4, "%" + search + "%");
            preparedStatement.setString(5, "%" + search + "%");
            preparedStatement.setString(6, "%" + search + "%");

            System.out.println(preparedStatement);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getInt("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setMiddleName(resultSet.getString("middle_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setPhone(resultSet.getString("phone"));
                contact.setAddress(resultSet.getString("address"));
                contact.setUserId(resultSet.getInt("user_id"));
                contact.toString();
                contacts.add(contact);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return contacts;
    }
}
