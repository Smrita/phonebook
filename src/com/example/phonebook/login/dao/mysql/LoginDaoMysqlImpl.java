package com.example.phonebook.login.dao.mysql;

import com.example.phonebook.common.BaseDao;
import com.example.phonebook.login.dao.LoginDao;
import com.example.phonebook.login.dto.User;

/**
 * Author: Pramod Bhandari
 * Date: 4/2/13
 * Time: 9:36 AM
 */
public class LoginDaoMysqlImpl implements LoginDao {

    public User login(String username, String password) throws Exception{
        return new LoginDaoMysql().login(username,password);
    }

    @Override
    public void setRememberToken(User user, String cookieToken) throws Exception {
        new LoginDaoMysql().setRememberToken(user,cookieToken);
    }

    @Override
    public User getUserFromAuthToken(String authToken) throws Exception {
        return new LoginDaoMysql().getUserFromAuthToken(authToken);
    }

}
