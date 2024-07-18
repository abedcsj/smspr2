package com.example.smspr2.mapper;


import com.example.smspr2.dto.TbpostDto;

import java.util.List;

public interface TbpostMapper {
    TbpostDto.SelectResDto detail(TbpostDto.SelectReqDto param);
    List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param);

}
