package br.edu.fatecsjc.lgnspringapi.service;

import br.edu.fatecsjc.lgnspringapi.converter.MarathonConverter;
import br.edu.fatecsjc.lgnspringapi.dto.MarathonDTO;
import br.edu.fatecsjc.lgnspringapi.entity.Marathon;
import br.edu.fatecsjc.lgnspringapi.repository.MarathonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MarathonService {

    final private MarathonRepository marathonRepository;
    final private MarathonConverter marathonConverter;

    @Autowired
    public MarathonService(MarathonRepository marathonRepository, MarathonConverter marathonConverter) {
        this.marathonRepository = marathonRepository;
        this.marathonConverter = marathonConverter;
    }

    public List<MarathonDTO> getAll() {
        return Collections.singletonList(marathonConverter.convertToDto((Marathon) marathonRepository.findAll()));
    }

    public MarathonDTO findById(Long id) {
        return marathonConverter.convertToDto(marathonRepository.findById(id).orElseThrow());
    }

    @Transactional
    public MarathonDTO save(Long id, MarathonDTO dto) {
        Marathon entity = marathonRepository.findById(id).orElseThrow();
        Marathon marathonToSave = marathonConverter.convertToEntity(dto, entity);
        Marathon marathonReturned = marathonRepository.save(marathonToSave);
        return marathonConverter.convertToDto(marathonReturned);
    }

    public MarathonDTO save(MarathonDTO dto) {
        Marathon marathonToSave = marathonConverter.convertToEntity(dto);
        Marathon marathonReturned = marathonRepository.save(marathonToSave);
        return marathonConverter.convertToDto(marathonReturned);
    }

    public void delete(Long id) {
        marathonRepository.deleteById(id);
    }
}