package com.suleymankayabasi.springboot.service.entityService;

import com.suleymankayabasi.springboot.dao.UserDao;
import com.suleymankayabasi.springboot.entity.Product;
import com.suleymankayabasi.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEntityService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll(){
        return userDao.findAll();
    }

    public User findById(Long id){
        return userDao.findUserById(id);
    }

    public User findUserByUserName(String userName){
        return userDao.findUserByUserName(userName);
    }

    public User findUserByPhoneNumber(String phoneNumber){
        return userDao.findUserByPhoneNumber(phoneNumber);
    }

    public User save(User user){
        user = userDao.save(user);
        return user;
    }

    public void deleteById(Long id){
        userDao.deleteById(id);
    }
}
