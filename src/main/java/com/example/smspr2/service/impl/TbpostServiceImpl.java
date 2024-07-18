package com.example.smspr2.service.impl;

import com.example.smspr2.domain.Tbpost;
import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.mapper.TbpostMapper;
import com.example.smspr2.repository.TbpostRepository;
import com.example.smspr2.service.TbpostService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TbpostServiceImpl implements TbpostService {

    private TbpostRepository tbpostRepository;
    private TbpostMapper tbpostMapper;
    public TbpostServiceImpl(TbpostRepository tbpostRepository,TbpostMapper tbpostMapper) {
        this.tbpostRepository = tbpostRepository;
        this.tbpostMapper = tbpostMapper;
    }
    @Override
    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param){
        Tbpost tbpost=tbpostRepository.save(param.toEntity());
        return tbpost.toCreateResDto();
    }
    @Override
    public TbpostDto.SelectResDto detail(TbpostDto.SelectReqDto param){
        TbpostDto.SelectResDto selectResDto = tbpostMapper.detail(param);
        if(selectResDto == null){ throw new RuntimeException("no data"); }
        return selectResDto;
    }
    public List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param){
        List<TbpostDto.SelectResDto> list = tbpostMapper.list(param);
        if(list == null){ throw new RuntimeException("no data"); }
        return list;

    };

}

