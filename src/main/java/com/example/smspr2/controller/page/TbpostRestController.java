package com.example.smspr2.controller.page;

import com.example.smspr2.dto.TbpostDto;
import com.example.smspr2.service.TbpostService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tbpost")
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
    @GetMapping("/plist")
    public ResponseEntity<TbpostDto.PagedListResDto> plist(@Valid TbpostDto.PagedListReqDto param){
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.pagedList(param));
    }
    @Operation(summary = "게시글 목록 스크롤 조회",
            description = "게시글 목록 스크롤 조회 컨트롤러 <br />"
                    + "@param TbpostDto.MoreListReqDto <br />"
                    + "@return HttpStatus.OK(200) ResponseEntity\\<TbpostDto.SelectResDto\\> <br />"
                    + "@exception 필수 파라미터 누락하였을 때 등 <br />"
    )
    @GetMapping("/mlist")
    public ResponseEntity<List<TbpostDto.SelectResDto>> mlist(@Valid TbpostDto.ScrollListReqDto param){
        return ResponseEntity.status(HttpStatus.OK).body(tbpostService.scrollList(param));
    }
}
