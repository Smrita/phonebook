package com.example.phonebook.app.dao;

import com.example.phonebook.app.dao.mysql.AppDaoMysqlImpl;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:16 AM
 */
public class AppDaoFactory {
    public static AppDao getAppDao() throws Exception{
        return new AppDaoMysqlImpl();
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
