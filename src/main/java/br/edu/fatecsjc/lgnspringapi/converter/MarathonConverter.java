package br.edu.fatecsjc.lgnspringapi.converter;

import br.edu.fatecsjc.lgnspringapi.dto.MarathonDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import org.springframework.stereotype.Component;

@Component
public class MarathonConverter {

    public MarathonDTO convertToDto(Marathon entity) {
        MarathonDTO dto = new MarathonDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setWeight(entity.getWeight());
        dto.setScore(entity.getScore());
        return dto;
    }

    public Marathon convertToEntity(MarathonDTO dto, Marathon entity) {
        entity.setName(dto.getName());
        entity.setWeight(dto.getWeight());
        entity.setScore(dto.getScore());
        return entity;
    }

    public Marathon convertToEntity(MarathonDTO dto) {
        Marathon entity = new Marathon();
        return convertToEntity(dto, entity);
    }
}