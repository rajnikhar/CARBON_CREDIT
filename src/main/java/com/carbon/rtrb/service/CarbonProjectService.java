package com.carbon.rtrb.service;

import com.carbon.rtrb.model.CarbonProject;
import com.carbon.rtrb.repository.CarbonProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CarbonProjectService {

    private final CarbonProjectRepository carbonProjectRepository;

    public CarbonProjectService(CarbonProjectRepository carbonProjectRepository) {
        this.carbonProjectRepository = carbonProjectRepository;
    }

    public CarbonProject createProject(CarbonProject project) {
        project.setCreatedAt(LocalDateTime.now());
        return carbonProjectRepository.save(project);
    }

    public List<CarbonProject> getAllProjects() {
        return carbonProjectRepository.findAll();
    }
}
