package com.example.http.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ApiUtilsTest {


    private final List<String> responseList = new ArrayList<>();


    @BeforeEach
    void init() {
        responseList.add("response1");
        responseList.add("response2");
        responseList.add("response3");
    }

    @Test
    void success() {
        //given
        List<String> responseList = this.responseList;

        //when
        ApiUtils.ApiResult<List<String>> success = ApiUtils.success(responseList);

        //then
        
        System.out.println("success.getResponse().equals(responseList) = " + success.getResponse().equals(responseList));
        System.out.println("(success.isSuccess() == true) = " + (success.isSuccess() == true));
    }

    @Test
    void error() {
        //given

        //when

        //then


    }


    @Test
    void testError() {
    }
}