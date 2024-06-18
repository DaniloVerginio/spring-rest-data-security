package br.edu.fatecsjc.lgnspringapi.controller;

import br.edu.fatecsjc.lgnspringapi.dto.GroupDTO;
import br.edu.fatecsjc.lgnspringapi.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
public class GroupController {

   // @Autowired
    private GroupService groupService;

    @GetMapping
    public List<GroupDTO> getAllGroups() {
        return groupService.getAll();
    }

    @GetMapping("/{id}")
    public GroupDTO getGroupById(@PathVariable Long id) {
        return groupService.findById(id);
    }

    @PostMapping
    public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
        return groupService.save(groupDTO);
    }

    @PutMapping("/{id}")
    public GroupDTO updateGroup(@PathVariable Long id, @RequestBody GroupDTO groupDTO) {
        return groupService.save(id, groupDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroup(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.ok().build();
    }
}