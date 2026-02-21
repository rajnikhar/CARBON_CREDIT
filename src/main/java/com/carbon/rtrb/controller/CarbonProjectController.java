package com.carbon.rtrb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.carbon.rtrb.dto.CarbonProjectDTO;
import com.carbon.rtrb.model.CarbonProject;
import com.carbon.rtrb.service.CarbonProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/projects")
public class CarbonProjectController {

    private final CarbonProjectService carbonProjectService;

    public CarbonProjectController(CarbonProjectService carbonProjectService) {
        this.carbonProjectService = carbonProjectService;
    }

    @PostMapping
    public ResponseEntity<CarbonProject> createProject(@RequestBody CarbonProjectDTO dto) {
        CarbonProject project = new CarbonProject();
        project.setProjectName(dto.getProjectName());
        project.setProjectType(dto.getProjectType());
        project.setAvailableTons(dto.getAvailableTons());
        project.setLocation(dto.getLocation());
        project.setVerificationBody(dto.getVerificationBody());
        project.setVerificationScore(dto.getVerificationScore());

        CarbonProject saved = carbonProjectService.createProject(project);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<CarbonProject>> getAll() {
        return ResponseEntity.ok(carbonProjectService.getAllProjects());
    }
}
