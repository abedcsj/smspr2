package com.example.smspr2.service;

import com.example.smspr2.dto.TbpostDto;
import org.springframework.stereotype.Service;

@Service
public interface TbpostService {
   public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param);
}
