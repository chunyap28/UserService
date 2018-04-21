/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aws.codestar.projecttemplates.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author chunyap
 */
public class ResponseMessage {
    
    private Map<String, String> result;
    private String status;
    private String message;
    
    public ResponseMessage(Map<String, String> result, String status, String message){
        this.result = result;
        this.status = status;
        this.message = message;
    }
    
    public ResponseMessage(String status, String message){
        this.result = new HashMap<>();
        this.status = status;
        this.message = message;
    }
    
    public void setResult(Map<String, String> result){
        this.result = result;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public Map<String, String> getResult(){
        return this.result;
    }
    
    public String getStatus(){
        return this.status;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    public Map<String, String> toMap(){
        Map <String, String> map = new HashMap<>();
        map.put("status", this.getStatus());
        map.put("message", this.getMessage());
        map.put("result", this.getResult().toString());
        return map;
    }
}
