package br.edu.fatecsjc.lgnspringapi.controller;

import br.edu.fatecsjc.lgnspringapi.dto.OrganizationDTO;
import br.edu.fatecsjc.lgnspringapi.service.OrganizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {

    //@Autowired
    private OrganizationService organizationService;

    @GetMapping
    public List<OrganizationDTO> getAllOrganizations() {
        return organizationService.getAll();
    }

    @GetMapping("/{id}")
    public OrganizationDTO getOrganizationById(@PathVariable Long id) {
        return organizationService.findById(id);
    }

    @PostMapping
    public OrganizationDTO createOrganization(@RequestBody OrganizationDTO organizationDTO) {
        return organizationService.save(organizationDTO);
    }

    @PutMapping("/{id}")
    public OrganizationDTO updateOrganization(@PathVariable Long id, @RequestBody OrganizationDTO organizationDTO) {
        return organizationService.save(id, organizationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrganization(@PathVariable Long id) {
        organizationService.delete(id);
        return ResponseEntity.ok().build();
    }
}
