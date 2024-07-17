package com.example.smspr2.service.impl;

import com.example.smspr2.domain.Tbpost;
import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.repository.TbpostRepository;
import org.springframework.stereotype.Service;


@Service
public class TbpostServiceImpl {

    private TbpostRepository tbpostRepository;
    public TbpostServiceImpl(TbpostRepository tbpostRepository) {
        this.tbpostRepository = tbpostRepository;
    }
    TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param){
        Tbpost tbpost=tbpostRepository.save(param.toEntity());
        return tbpost.toCreateResDto();


    }
}

