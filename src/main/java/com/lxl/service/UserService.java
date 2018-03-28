package com.lxl.service;

import com.lxl.repository.UserRepository;
import com.lxl.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author lixiaolong
 * @Description:
 * @Date 2018/3/27
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User selectUserById(int id) {
//        return userRepository.selectUserById(id);
        return userRepository.selecUserByJdbc(id);
    }
}
