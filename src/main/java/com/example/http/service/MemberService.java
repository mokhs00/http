package com.example.http.service;

import com.example.http.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    // index를 key로 하는 db 대용 list
    private final List<Member> memberRepository = new ArrayList<>();

    // Aspect로 처리하기
    public void logInfo() {

    }

    public MemberService() {
        Init();
    }

    public void Init() {
        this.memberRepository.add(new Member("admin", 30));
        this.memberRepository.add(new Member("user", 20));
    }

    public Member findById(int id) {
        return this.memberRepository.get(id);
    }

    public List<Member> findAll() {
        return this.memberRepository;
    }

    public int create(Member member) {
        memberRepository.add(member);
        return memberRepository.size() - 1;
    }

}
