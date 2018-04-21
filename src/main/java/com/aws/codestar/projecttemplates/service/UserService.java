/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.entity.User;
import com.aws.codestar.projecttemplates.repository.UserRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chunyap
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;
 
    //@Autowired
    //UserRepository repository;
    
    public User addUser(String name, String mobile) throws Exception{
        this.checkExist(mobile);
        User newUser = new User(UUID.randomUUID().toString(), name, mobile);
        repo.save(newUser);
        return newUser;
    }

    public User getUser(String mobile) throws Exception{
        //return new User("test");
        List<User> users = repo.findByMobile(mobile);
        if( users.size() <= 0 ){
            throw new Exception("User not found");
        }
        
        return users.get(0);
    }
    
    protected void checkExist(String mobile) throws Exception{
        List<User> users = repo.findByMobile(mobile);
        if( users.size() > 0 ){
            throw new Exception("Already Registered");
        }
    }
}
