package com.example.smspr2.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
@Service
public interface DefaultService {
    public Map<String,Object>create(@RequestParam Map<String,Object> map);
    public Map<String,Object> list();
}
