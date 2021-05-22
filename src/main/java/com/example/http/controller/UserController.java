package com.example.http.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping()
public class UserController {


    /*
        시나리오 :
        기존에 회원 API의 URL로 /user* 를 사용하다가
        /member*로 이전한 상황
        api 문서를 업데이트하고 사용자들이 그에 맞춰 개발하는 것이 맞다고 생각하지만,
        이번만 예외로 기존 URL로 접속해도 redirect를 통해 서버 단에서 이를 해결해주기로 함.

        CORS 정책을 열어줘야한다.
    */

    // findAll() GET /users -> /members
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity findAll() {

        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create("/members"))
                .build();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity find(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create("/member/" + id))
                .build();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity createBatch(MemberBatchRequest request) {
        return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
                .location(URI.create("/members"))
                .build();
    }
}
