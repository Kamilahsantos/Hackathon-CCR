package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.exception.ResourceNotFoundException;
import com.ccr.hackathon.backend.model.ManagementContent;
import com.ccr.hackathon.backend.model.TechContent;
import com.ccr.hackathon.backend.repository.ManagementContentRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/api/v1/content")
@RestController
public class ManagementContentController {

    @Autowired
    private ManagementContentRepository managementContentRepository;


    @ApiOperation(value = "Create a new Management content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Management content successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred, it was not possible to complete your request")
    }
    )
    @PostMapping("/management")
    public ManagementContent createManagementContent(@Valid @RequestBody ManagementContent managementContent) {
        log.info(" Managemente content  {} , {} , {}  and  {}  was successfully  created", managementContent.getTitle(), managementContent.getDescription(), managementContent.getUrl(), managementContent.getLevel());
        return managementContentRepository.save(managementContent);
    }


    @ApiOperation(value = "List all Management Content")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Management  content  was listed with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("/management")
    public List<ManagementContent> getAllManagementContent() {
        log.info("Listing all management content");
        return managementContentRepository.findAll();
    }


    @ApiOperation(value = "Find a Management content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Management content find with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("management/{id}")
    public ResponseEntity<ManagementContent> getManagementContentContentById(@PathVariable(value = "id") Long managementContentId)
            throws ResourceNotFoundException {
        ManagementContent managementContent = managementContentRepository.findById(managementContentId)
                .orElseThrow(() -> new ResourceNotFoundException("Digital Marketing Content not found :: " + managementContentId));
        log.info("Management content with  id  {}  was find with success", managementContentId);
        return ResponseEntity.ok().body(managementContent);
    }


    @ApiOperation(value = "Update a Management content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Management content updated with success"),
            @ApiResponse(code = 500, message = "An internal error occurred w it was not possible to complete your request")
    }
    )
    @PatchMapping("/management/{id}")
    public ResponseEntity<ManagementContent> updateManagementContent(@PathVariable(value = "id") Long managementContentId,
                                                                     @Valid @RequestBody TechContent contentDetails) throws ResourceNotFoundException {
        ManagementContent managementContent = managementContentRepository.findById(managementContentId)
                .orElseThrow(() -> new ResourceNotFoundException("Management Content not found for this id :: " + managementContentId));


        managementContent.setTitle(contentDetails.getTitle());
        managementContent.setDescription(contentDetails.getDescription());
        managementContent.setUrl(contentDetails.getUrl());
        managementContent.setLevel(contentDetails.getLevel());


        final ManagementContent updateManagementContent = managementContentRepository.save(
                managementContent
        );
        log.info("Management content with id  {} was successfully updated", managementContentId);
        return ResponseEntity.ok(updateManagementContent);
    }


    @ApiOperation(value = "Delete a Management Content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Management Content  deleted with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @DeleteMapping("/management/{id}")
    public Map<String, Boolean> deleteManagementContent(@PathVariable(value = "id") Long managementContentId)
            throws ResourceNotFoundException {
        ManagementContent managementContent = managementContentRepository.findById(managementContentId)
                .orElseThrow(() -> new ResourceNotFoundException(" Management Content not found for this id :: " + managementContentId));

        managementContentRepository.delete(managementContent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        log.info("Management Content with id {}  deleted with success ", managementContentId);
        return response;
    }
}
