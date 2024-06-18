package br.edu.fatecsjc.lgnspringapi.converter;

import br.edu.fatecsjc.lgnspringapi.dto.OrganizationDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrganizationConverter {

    public OrganizationDTO convertToDto(Organization entity) {
        OrganizationDTO dto = new OrganizationDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setInstitutionName(entity.getInstitutionName());
        return dto;
    }

    public Organization convertToEntity(OrganizationDTO dto, Organization entity) {
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        entity.setInstitutionName(dto.getInstitutionName());
        return entity;
    }

    public Organization convertToEntity(OrganizationDTO dto) {
        Organization entity = new Organization();
        return convertToEntity(dto, entity);
    }


}
