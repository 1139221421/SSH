package com.lxl.repository;

import com.lxl.vo.User;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/27
 */
public interface UserRepository extends BaseRepository<User,Integer> {
    public User selectUserById(int id);

    public User selectUserById1(int id);
}
