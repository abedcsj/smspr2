package com.example.smspr2.controller.page;

import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.service.TbpostService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class TbpostRestController {

    private TbpostService tbpostService;
    public TbpostRestController(TbpostService tbpostService) {
        this.tbpostService = tbpostService;
    }

    @PostMapping("")
    public ResponseEntity<TbpostDto.CreateResDto> create(@Valid @RequestBody TbpostDto.CreateReqDto param){
        return ResponseEntity.status(HttpStatus.CREATED).body(tbpostService.create(param));
    }
    @GetMapping("")
    public ResponseEntity<TbpostDto.SelectResDto> detail(@Valid TbpostDto.SelectReqDto param){
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<TbpostDto.SelectResDto>> list(@Valid TbpostDto.ListReqDto param){
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.list(param));
    }

}
