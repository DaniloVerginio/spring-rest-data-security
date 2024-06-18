package br.edu.fatecsjc.lgnspringapi.dto;

import br.edu.fatecsjc.lgnspringapi.entity.Address;

import java.util.List;

public class OrganizationDTO {
    private Long id;
    private String name;
    private String address;
    private String institution;
    private String country;
    private List<GroupDTO> groups;
}