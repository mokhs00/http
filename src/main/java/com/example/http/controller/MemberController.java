package com.example.http.controller;


import com.example.http.model.Member;
import com.example.http.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@CrossOrigin
@Slf4j
@AllArgsConstructor
@RestController
public class MemberController {


    private final MemberService memberService;

    // ok 200
    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public ResponseEntity<List<Member>> findAll() {

        return new ResponseEntity<>(this.memberService.findAll(), HttpStatus.OK);
    }

    // ok 200 / notFound 404
    @RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
    public ResponseEntity<Member> findOne(@PathVariable("id") Integer id) {
        Member findedMember = memberService.findById(id);

        if (ObjectUtils.isEmpty(findedMember)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(findedMember);

    }

    // created 201 / badRequest 404
    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public ResponseEntity create(Member member) {
        if (ObjectUtils.isEmpty(member)) {
            return ResponseEntity.badRequest().build();
        }

        int id = memberService.create(member);

        return ResponseEntity.created(URI.create("/member/" + id))
                .build();
    }

    // accepted 202 : 1시간 뒤 전송된 요청의 데이터를 저장하는 시나리오
    @RequestMapping(value = "/members", method = RequestMethod.POST)
    public ResponseEntity createBatch(MemberBatchRequest request) {
        if (ObjectUtils.isEmpty(request)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().build();

    }
}
