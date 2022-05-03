package cn.edu.guet.shopdemo.dao;

import cn.edu.guet.shopdemo.been.User;

import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;

public interface UserDao {
    ResultSet onceUser(User user);
    boolean addUser(User user) throws SQLIntegrityConstraintViolationException;
    boolean delectUser(User user);
    boolean updateUser(User user,int lastid) throws SQLIntegrityConstraintViolationException;
}
