package com.suleymankayabasi.springboot.dao;

import com.suleymankayabasi.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Long> {

    User findUserByUserName(String userName);

    User findUserByPhoneNumber(String phoneNumber);

    User findUserById(Long id);

}
