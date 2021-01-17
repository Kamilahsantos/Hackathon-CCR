package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.exception.ResourceNotFoundException;
import com.ccr.hackathon.backend.model.ManagementContent;
import com.ccr.hackathon.backend.model.SoftSkillsContent;
import com.ccr.hackathon.backend.model.TechContent;
import com.ccr.hackathon.backend.repository.SoftSkillsContentRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/api/v1/content")
@RestController
public class SoftSkillsContentController {


    @Autowired
    private SoftSkillsContentRepository softSkillsContentRepository;


    @ApiOperation(value = "Create a new Soft Skills content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Soft skill content successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred, it was not possible to complete your request")
    }
    )
    @PostMapping("/soft_skills")
    public SoftSkillsContent createSoftSkillsContent(@Valid @RequestBody SoftSkillsContent softSkillsContent) {
        return softSkillsContentRepository.save(softSkillsContent);
    }


    @ApiOperation(value = "List all Soft Skills  Content")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Soft Skills  content  was listed with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("/soft_skills")
    public List<SoftSkillsContent> getAllSoftSkillsContent() {
        return softSkillsContentRepository.findAll();
    }


    @ApiOperation(value = "Find a Soft Skills content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Soft Skills content find with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("soft_skills/{id}")
    public ResponseEntity<SoftSkillsContent> getSoftSkillsContentById(@PathVariable(value = "id") Long softSkillsContentId)
            throws ResourceNotFoundException {
        SoftSkillsContent softSkillsContent = softSkillsContentRepository.findById(softSkillsContentId)
                .orElseThrow(() -> new ResourceNotFoundException("Soft Skills Content not found :: " + softSkillsContentId));
        return ResponseEntity.ok().body(softSkillsContent);
    }



    @PatchMapping("/soft_skills/{id}")
    public ResponseEntity<SoftSkillsContent> updateSoftSkillsContent(@PathVariable(value = "id") Long softSkillsContentId,
                                                                     @Valid @RequestBody SoftSkillsContent contentDetails) throws ResourceNotFoundException {
        SoftSkillsContent softSkillsContent = softSkillsContentRepository.findById(softSkillsContentId)
                .orElseThrow(() -> new ResourceNotFoundException("Tech Content not found for this id :: " + softSkillsContentId));


        softSkillsContent.setTitle(contentDetails.getTitle());
        softSkillsContent.setDescription(contentDetails.getDescription());
        softSkillsContent.setUrl(contentDetails.getUrl());
        softSkillsContent.setLevel(contentDetails.getLevel());



        final SoftSkillsContent updateSoftSkillsContent = softSkillsContentRepository.save(
                softSkillsContent
        );
        return ResponseEntity.ok(updateSoftSkillsContent);
    }

    @ApiOperation(value = "Delete a Soft Skills Content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Soft Skills Content Content deleted with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @DeleteMapping("/soft_skills/{id}")
    public Map<String, Boolean> deleteSoftSkillsContent(@PathVariable(value = "id") Long softSkillsContentId)
            throws ResourceNotFoundException {
        SoftSkillsContent softSkillsContent = softSkillsContentRepository.findById(softSkillsContentId)
                .orElseThrow(() -> new ResourceNotFoundException(" Soft Skills Content not found for this id :: " + softSkillsContentId));

        softSkillsContentRepository.delete(softSkillsContent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
