package br.edu.fatecsjc.lgnspringapi.controller;

import br.edu.fatecsjc.lgnspringapi.dto.MemberDTO;
import br.edu.fatecsjc.lgnspringapi.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

   // @Autowired
    private MemberService memberService;

    @GetMapping
    public List<MemberDTO> getAllMembers() {
        return memberService.getAll();
    }

    @GetMapping("/{id}")
    public MemberDTO getMemberById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PostMapping
    public MemberDTO createMember(@RequestBody MemberDTO memberDTO) {
        return memberService.save(memberDTO);
    }

    @PutMapping("/{id}")
    public MemberDTO updateMember(@PathVariable Long id, @RequestBody MemberDTO memberDTO) {
        return memberService.save(id, memberDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long id) {
        memberService.delete(id);
        return ResponseEntity.ok().build();
    }
}