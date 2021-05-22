package com.example.http.controller;

import com.example.http.model.Member;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MemberBatchRequest {
    List<Member> members = new ArrayList<>();
}
