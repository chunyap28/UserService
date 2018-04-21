/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.util.Map;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author chunyap
 */
@DynamoDBTable(tableName = "User")
public class User {
    protected String id;
    protected String name;
    protected String mobile;
    
    public User(){}
    
    public User(String id, String name, String mobile) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
    }
    
    @DynamoDBHashKey(attributeName = "Id")
    public String getId() {
        return id;
    }
 
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }
    
    @DynamoDBAttribute(attributeName = "Mobile")
    public String getMobile() {
        return mobile;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    public Map<String, String> toMap(){
        ObjectMapper oMapper = new ObjectMapper();
        // object -> Map
        return oMapper.convertValue(this, Map.class);
    }
}
