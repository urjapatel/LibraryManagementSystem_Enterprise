package com.library.demo.controller;

import com.library.demo.model.Member;
import com.library.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepo;

    @PostMapping
    public Member create(@RequestBody Member member) {
        return memberRepo.save(member);
    }

    @GetMapping
    public List<Member> getAll() {
        return memberRepo.findAll();
    }

    @GetMapping("/{id}")
    public Member getById(@PathVariable Long id) {
        return memberRepo.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Member update(@PathVariable Long id, @RequestBody Member updated) {
        Member member = memberRepo.findById(id).orElseThrow();
        member.setName(updated.getName());
        member.setAddress(updated.getAddress());
        member.setMembDate(updated.getMembDate());
        member.setMembType(updated.getMembType());
        member.setExpiryDate(updated.getExpiryDate());
        return memberRepo.save(member);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        memberRepo.deleteById(id);
    }
}
