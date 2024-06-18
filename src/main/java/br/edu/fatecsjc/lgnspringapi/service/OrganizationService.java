package br.edu.fatecsjc.lgnspringapi.service;



import br.edu.fatecsjc.lgnspringapi.converter.OrganizationConverter;
import br.edu.fatecsjc.lgnspringapi.dto.OrganizationDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import br.edu.fatecsjc.lgnspringapi.repository.OrganizationRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrganizationService {

    final private OrganizationRepository organizationRepository;
    final private OrganizationConverter organizationConverter;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, OrganizationConverter organizationConverter) {
        this.organizationRepository = organizationRepository;
        this.organizationConverter = organizationConverter;
    }

    public List<OrganizationDTO> getAll() {
        return Collections.singletonList(organizationConverter.convertToDto((Organization) organizationRepository.findAll()));
    }

    public OrganizationDTO findById(Long id) {
        return organizationConverter.convertToDto(organizationRepository.findById(id).orElseThrow());
    }

    @Transactional
    public OrganizationDTO save(Long id, OrganizationDTO dto) {
        Organization entity = organizationRepository.findById(id).orElseThrow();
        Organization organizationToSave = organizationConverter.convertToEntity(dto, entity);
        Organization organizationReturned = organizationRepository.save(organizationToSave);
        return organizationConverter.convertToDto(organizationReturned);
    }

    public OrganizationDTO save(OrganizationDTO dto) {
        Organization organizationToSave = organizationConverter.convertToEntity(dto);
        Organization organizationReturned = organizationRepository.save(organizationToSave);
        return organizationConverter.convertToDto(organizationReturned);
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}