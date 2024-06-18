package br.edu.fatecsjc.lgnspringapi.service;

import br.edu.fatecsjc.lgnspringapi.converter.MemberConverter;
import br.edu.fatecsjc.lgnspringapi.dto.MemberDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Member;
import br.edu.fatecsjc.lgnspringapi.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MemberService {

    final private MemberRepository memberRepository;
    final private MemberConverter memberConverter;

    @Autowired
    public MemberService(MemberRepository memberRepository, MemberConverter memberConverter) {
        this.memberRepository = memberRepository;
        this.memberConverter = memberConverter;
    }

    public List<MemberDTO> getAll() {
        return Collections.singletonList(memberConverter.convertToDto((Member) memberRepository.findAll()));
    }

    public MemberDTO findById(Long id) {
        return memberConverter.convertToDto(memberRepository.findById(id).orElseThrow());
    }

    @Transactional
    public MemberDTO save(Long id, MemberDTO dto) {
        Member entity = memberRepository.findById(id).orElseThrow();
        Member memberToSave = memberConverter.convertToEntity(dto, entity);
        Member memberReturned = memberRepository.save(memberToSave);
        return memberConverter.convertToDto(memberReturned);
    }

    public MemberDTO save(MemberDTO dto) {
        Member memberToSave = memberConverter.convertToEntity(dto);
        Member memberReturned = memberRepository.save(memberToSave);
        return memberConverter.convertToDto(memberReturned);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}