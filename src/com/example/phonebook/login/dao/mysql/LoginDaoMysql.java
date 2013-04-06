package com.example.phonebook.login.dao.mysql;

import com.example.phonebook.common.BaseDao;
import com.example.phonebook.login.dto.User;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 9:20 AM
 */
public class LoginDaoMysql extends BaseDao {
    public User login(String username, String password) throws Exception {
        User user = null;
        query = "Select * from user where username=? and password=?";
        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            System.out.println("SQL===========================================================");
            System.out.println(preparedStatement);
            System.out.println("SQL===========================================================");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return user;
    }

    public void setRememberToken(User user, String cookieToken) throws Exception {
        query = "update user set authToken=? where id=?";

        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, cookieToken);
            preparedStatement.setInt(2, user.getId());

            System.out.println(preparedStatement);

            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }
    }


    public User getUserFromAuthToken(String authToken) throws Exception {
        User user = null;
        query = "Select * from user where authToken=?";
        try {
            connect();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, authToken);
            System.out.println("SQL===========================================================");
            System.out.println(preparedStatement);
            System.out.println("SQL===========================================================");

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setFirstName(resultSet.getString("firstName"));
                user.setLastName(resultSet.getString("lastName"));

            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            close();
        }

        return user;
    }
}
