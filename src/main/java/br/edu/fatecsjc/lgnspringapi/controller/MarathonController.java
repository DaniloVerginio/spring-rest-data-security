package br.edu.fatecsjc.lgnspringapi.controller;

import br.edu.fatecsjc.lgnspringapi.dto.MarathonDTO;
import br.edu.fatecsjc.lgnspringapi.service.MarathonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marathons")
public class MarathonController {

   // @Autowired
    private MarathonService marathonService;

    @GetMapping
    public List<MarathonDTO> getAllMarathons() {
        return marathonService.getAll();
    }

    @GetMapping("/{id}")
    public MarathonDTO getMarathonById(@PathVariable Long id) {
        return marathonService.findById(id);
    }

    @PostMapping
    public MarathonDTO createMarathon(@RequestBody MarathonDTO marathonDTO) {
        return marathonService.save(marathonDTO);
    }

    @PutMapping("/{id}")
    public MarathonDTO updateMarathon(@PathVariable Long id, @RequestBody MarathonDTO marathonDTO) {
        return marathonService.save(id, marathonDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMarathon(@PathVariable Long id) {
        marathonService.delete(id);
        return ResponseEntity.ok().build();
    }
}