package com.example.smspr2.service.impl;

import com.example.smspr2.domain.Tbpost;
import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.mapper.TbpostMapper;
import com.example.smspr2.repository.TbpostRepository;
import com.example.smspr2.service.TbpostService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TbpostServiceImpl implements TbpostService {

    private TbpostRepository tbpostRepository;
    private TbpostMapper tbpostMapper;

    public TbpostServiceImpl(TbpostRepository tbpostRepository, TbpostMapper tbpostMapper) {
        this.tbpostRepository = tbpostRepository;
        this.tbpostMapper = tbpostMapper;
    }

    @Override
    public TbpostDto.CreateResDto create(TbpostDto.CreateReqDto param) {
        Tbpost tbpost = tbpostRepository.save(param.toEntity());
        return tbpost.toCreateResDto();
    }

    @Override
    public TbpostDto.SelectResDto detail(TbpostDto.SelectReqDto param) {
        TbpostDto.SelectResDto selectResDto = tbpostMapper.detail(param);
        if (selectResDto == null) {
            throw new RuntimeException("no data");
        }
        return selectResDto;
    }

    @Override
    public List<TbpostDto.SelectResDto> list(TbpostDto.ListReqDto param) {
        List<TbpostDto.SelectResDto> list = tbpostMapper.list(param);
        if (list == null) {
            throw new RuntimeException("no data");
        }
        return list;
    }

    @Override
    public TbpostDto.PagedListResDto pagedList(TbpostDto.PagedListReqDto param) {

        String orderby = param.getOrderby();
        if (orderby == null || orderby.isEmpty()) {
            orderby = "created_at";
        }
        String orderway = param.getOrderway();
        if (orderway == null || orderway.isEmpty()) {
            orderway = "desc";
        }
        Integer perpage = param.getPerpage();
        if (perpage == null) {
            //한번에 조회할 글 갯수
            perpage = 10;
        }
        Integer callpage = param.getCallpage();

        if (callpage == null) {
            //호출하는 페이지
            callpage = 1;
        }

        if (callpage < 1) {
            callpage = 1;
        }


        int listsize=tbpostMapper.pagedListCount(param);


        int pagesize=listsize/perpage;


        if(listsize%perpage!=0){
            pagesize++;
        }

        if(callpage>pagesize){
            callpage=pagesize;
        }

        int offset=(callpage-1)*perpage;

        param.setOrderby(orderby);
        param.setOrderway(orderway);
        param.setOffset(offset);
        param.setPerpage(perpage);

        List<TbpostDto.SelectResDto> list = tbpostMapper.pagedList(param);
        List<TbpostDto.SelectResDto> newList = new ArrayList<>();
        for(TbpostDto.SelectResDto i : list){
            newList.add(detail(TbpostDto.SelectReqDto.builder().id(i.getId()).build()));
        }

        TbpostDto.PagedListResDto returnVal =
                TbpostDto.PagedListResDto.builder()
                        .callpage(callpage)
                        .perpage(perpage)
                        .orderby(orderby)
                        .orderway(orderway)
                        .listsize(listsize)
                        .pagesize(pagesize)
                        .list(newList)
                        .build();

        return returnVal;
    }
}

