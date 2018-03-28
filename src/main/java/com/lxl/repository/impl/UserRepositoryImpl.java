package com.lxl.repository.impl;

import com.lxl.repository.UserRepository;
import com.lxl.util.JDBCUtil;
import com.lxl.vo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/27
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.openSession();
    }

    //hibernate提供
    public User get(Integer id) {
        return (User) getCurrentSession().get(User.class, id);
    }

    //hql
    public User selectUserById(int id) {
        Query query = getCurrentSession().createQuery("from User where id = ?"); //select u from User u where id = ?
        query.setParameter(0, id);
        return (User) query.uniqueResult();
    }

    //sql
    public User selectUserById1(int id) {
        String sql = "select * from user where id = " + String.valueOf(id);
        Query query = getCurrentSession().createSQLQuery(sql).addEntity(User.class);
        return (User) query.uniqueResult(); //List<User> list = query.list()
    }

    //jdbc
    public User selecUserByJdbc(int id) {
        Connection connection = JDBCUtil.getConnection();
        String sql = "select id,user_name,password from user where id = " + String.valueOf(id);
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (null != connection) {
                ps = connection.prepareStatement(sql);
                rs = ps.executeQuery();
                if (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt(1));
                    user.setUserName(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    return user;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (null != rs) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != ps) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (null != connection) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
