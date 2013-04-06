package com.example.phonebook.login.dao;

import com.example.phonebook.login.dao.mysql.LoginDaoMysqlImpl;

/**
 * Author: Pramod Bhandari
 * Date: 4/2/13
 * Time: 9:28 AM
 */
public class LoginDaoFactory {
    public static LoginDao getLoginDao() throws Exception{
        return new LoginDaoMysqlImpl();
//        if("MYSQL".equalsIgnoreCase("")){
//            return new LoginDaoMysqlImpl();
//        }else if("ORACLE".equalsIgnoreCase("")){
//            return null;
//
//        }else{
//            throw new Exception("DAMN!!!Invalid Database Server :(");
//        }
    }
}
