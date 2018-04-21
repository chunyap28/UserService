/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.controller;

import com.aws.codestar.projecttemplates.common.ResponseMessage;
import com.aws.codestar.projecttemplates.entity.User;
import com.aws.codestar.projecttemplates.service.UserService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author chunyap
 */
@RestController
@EnableWebMvc
public class UserController {
    @Autowired private UserService serv;
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public Map<String,String> addUser(
            @RequestParam(value="name") String name,
            @RequestParam(value="mobile") String mobile){
        try{
            User user = serv.addUser(name, mobile);
            return new ResponseMessage(user.toMap(), "OK", "Registered Successfully").toMap();    
        }catch(Exception e){
            return this.handleError(e);
        }
    }
    
    @CrossOrigin(origins = "*")
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public Map<String,String> getUser(
            @RequestParam(value="mobile") String mobile){
        try{
            return new ResponseMessage(serv.getUser(mobile).toMap(), "OK", "User Found").toMap();
        }catch(Exception e){
            return this.handleError(e);
        }
    }
    
    protected Map<String,String> handleError(Exception e){
        return new ResponseMessage("FAIL", e.getMessage().toString()).toMap();
    }
}
