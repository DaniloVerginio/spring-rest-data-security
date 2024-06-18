package br.edu.fatecsjc.lgnspringapi.converter;

import br.edu.fatecsjc.lgnspringapi.dto.MemberDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Member;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MemberConverter {

    public MemberDTO convertToDto(Member entity) {
        MemberDTO dto = new MemberDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        return dto;
    }

    public Member convertToEntity(MemberDTO dto, Member entity) {
        entity.setName(dto.getName());
        return entity;
    }

    public Member convertToEntity(MemberDTO dto) {
        Member entity = new Member();
        return convertToEntity(dto, entity);
    }


}