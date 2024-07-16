package com.example.smspr2.service.impl;

import com.example.smspr2.service.DefaultService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DefaultServiceImpl implements DefaultService {
    Map<String,Object>result=new LinkedHashMap<>();

    public Map<String,Object>create(@RequestParam Map<String,Object> params){
        Map<String,Object>input=new LinkedHashMap<>();
        String name=(String)params.get("name");
        String phone=(String)params.get("phone");
        input.put("name",name);
        input.put("phone",phone);
        result.put("회원 리스트",input);
        return input;
    }

    public Map<String,Object> list(){
        return result;
    }
}
