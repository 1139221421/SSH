package com.lxl.repository.impl;

import com.lxl.repository.UserRepository;
import com.lxl.vo.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
