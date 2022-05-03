package cn.edu.guet.shopdemo.dao.impl;

import cn.edu.guet.shopdemo.been.User;
import cn.edu.guet.shopdemo.dao.*;
import cn.edu.guet.shopdemo.util.CatchNullException;
import cn.edu.guet.shopdemo.util.ConnectionHandler;

import java.sql.*;

public class UserDaoImpl implements UserDao {

    @Override
    public ResultSet onceUser(User user) {
        ResultSet rs=null;
        try {
            Connection conn = ConnectionHandler.getConnection();
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, user.getUsername());
            pstm.setString(2, user.getPassword());

            rs = pstm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    @Override
    public boolean addUser(User user) throws SQLIntegrityConstraintViolationException {
        String[] except = {"username","password","Duplicate"};
        int resu =0;
        Connection conn = null;
        try {
            conn = ConnectionHandler.getConnection();
            String sql = "INSERT INTO users VALUES(?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1, user.getUser_id());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getPassword());
            pstm.setInt(4, user.getRank());

            resu = pstm.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            CatchNullException catchExcept =new CatchNullException();
            int chose = catchExcept.catchEx(e.toString());
            //System.out.println(e.toString());
            throw new SQLIntegrityConstraintViolationException(except[chose]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resu>0;
    }


    @Override
    public boolean delectUser(User user) {
        int resu =0;
        Connection conn = null;
        try {
            conn= ConnectionHandler.getConnection();
            String sql = "DELETE FROM users WHERE user_id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1,user.getUser_id());
            resu =pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resu>0;
    }

    @Override
    public boolean updateUser(User user,int lastid) throws SQLIntegrityConstraintViolationException{
        String[] except = {"username","password","Duplicate"};
        int resu =0;
        Connection conn = null;
        try {
            conn= ConnectionHandler.getConnection();
            String sql = "UPDATE users SET user_id=?,username=?,password=?,user_rank=? WHERE user_id=?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setInt(1,user.getUser_id());
            pstm.setString(2,user.getUsername());
            pstm.setString(3,user.getPassword());
            pstm.setInt(4,user.getRank());
            pstm.setInt(5,lastid);

            resu =pstm.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e){
            CatchNullException catchExcept =new CatchNullException();
            int chose = catchExcept.catchEx(e.toString());
            //System.out.println(e.toString());
            throw new SQLIntegrityConstraintViolationException(except[chose]);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resu>0;
    }
}
