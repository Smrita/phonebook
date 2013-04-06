package com.example.phonebook.login.dao;

import com.example.phonebook.login.dto.User;

/**
 * Author: Pramod Bhandari
 * Date: 4/2/13
 * Time: 9:28 AM
 */
public interface LoginDao {

    public User login(String username, String password) throws Exception;

    void setRememberToken(User user, String cookieToken) throws Exception;

    User getUserFromAuthToken(String authToken) throws Exception;
}
