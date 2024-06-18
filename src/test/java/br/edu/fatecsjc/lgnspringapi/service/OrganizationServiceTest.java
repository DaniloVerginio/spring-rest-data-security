package br.edu.fatecsjc.lgnspringapi.service;

import br.edu.fatecsjc.lgnspringapi.converter.OrganizationConverter;
import br.edu.fatecsjc.lgnspringapi.dto.OrganizationDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Organization;
import br.edu.fatecsjc.lgnspringapi.repository.OrganizationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrganizationServiceTest {

    @Mock
    private OrganizationRepository organizationRepository;

    @Mock
    private OrganizationConverter organizationConverter;

    @InjectMocks
    private OrganizationService organizationService;

    @Test
    public void testGetAllOrganizations() {
        when(organizationRepository.findAll()).thenReturn(List.of(new Organization()));
        when(organizationConverter.convertToDto(any(Organization.class))).thenReturn(new OrganizationDTO());

        List<OrganizationDTO> organizations = organizationService.getAll();

        assertNotNull(organizations);
        assertEquals(1, organizations.size());
        verify(organizationRepository, times(1)).findAll();
        verify(organizationConverter, times(1)).convertToDto(any(Organization.class));
    }

    @Test
    public void testFindById() {
        Long id = 1L;
        Organization organization = new Organization();
        organization.setId(id);
        OrganizationDTO organizationDTO = new OrganizationDTO();


        when(organizationRepository.findById(id)).thenReturn(Optional.of(organization));
        when(organizationConverter.convertToDto(organization)).thenReturn(organizationDTO);

        OrganizationDTO found = organizationService.findById(id);

        assertNotNull(found);
        verify(organizationRepository, times(1)).findById(id);
        verify(organizationConverter, times(1)).convertToDto(organization);
    }

    @Test
    public void testSaveOrganization() {
        OrganizationDTO organizationDTO = new OrganizationDTO();
        Organization organization = new Organization();
        Organization savedOrganization = new Organization();

        when(organizationConverter.convertToEntity(organizationDTO)).thenReturn(organization);
        when(organizationRepository.save(organization)).thenReturn(savedOrganization);
        when(organizationConverter.convertToDto(savedOrganization)).thenReturn(organizationDTO);

        OrganizationDTO saved = organizationService.save(organizationDTO);

        assertNotNull(saved);
        verify(organizationConverter, times(1)).convertToEntity(organizationDTO);
        verify(organizationRepository, times(1)).save(organization);
        verify(organizationConverter, times(1)).convertToDto(savedOrganization);
    }

    @Test
    public void testDeleteOrganization() {
        Long id = 1L;
        doNothing().when(organizationRepository).deleteById(id);

        organizationService.delete(id);

        verify(organizationRepository, times(1)).deleteById(id);
    }
}