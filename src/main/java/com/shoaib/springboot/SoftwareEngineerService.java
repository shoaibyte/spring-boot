package com.shoaib.springboot;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoftwareEngineerService {

    private final SoftwareEngineerRepository softwareEngineerRepository;

    public SoftwareEngineerService(SoftwareEngineerRepository softwareEngineerRepository) {
        this.softwareEngineerRepository = softwareEngineerRepository;
    }

    public List<SoftwareEngineer> getAllSoftwareEngineers() {
        return softwareEngineerRepository.findAll();
    }

    public void insertSoftwareEngineer(SoftwareEngineer softwareEngineer) {
        softwareEngineerRepository.save(softwareEngineer);
    }

    public SoftwareEngineer getSoftwareEngineerById(Integer id) {
        return softwareEngineerRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("The software engine with id " + id + " does not exist."));
    }

    public void deleteSoftwareEngineerById(Integer id) {
        boolean exists = softwareEngineerRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("The software engine with id " + id + " does not exist.");
        }

        softwareEngineerRepository.deleteById(id);
    }

    public SoftwareEngineer updateSoftwareEngineerById(Integer id, SoftwareEngineer updatedSoftwareEngineer) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("The software engine with id " + id + " does not exist."));

        softwareEngineer.setName(updatedSoftwareEngineer.getName());
        softwareEngineer.setTechStack(updatedSoftwareEngineer.getTechStack());
        softwareEngineerRepository.save(softwareEngineer);
        return softwareEngineer;
    }
}
