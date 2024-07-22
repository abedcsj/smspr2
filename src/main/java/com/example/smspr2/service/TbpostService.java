package com.example.smspr2.service;

import com.example.smspr2.dto.TbpostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TbpostService {
   TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param);
   TbpostDto.SelectResDto detail(TbpostDto.SelectReqDto param);
   List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param);
   TbpostDto.PagedListResDto pagedList(TbpostDto.PagedListReqDto param);
}
