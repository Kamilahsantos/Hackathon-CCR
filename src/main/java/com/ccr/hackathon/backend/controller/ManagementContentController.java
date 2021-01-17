package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.exception.ResourceNotFoundException;
import com.ccr.hackathon.backend.model.ManagementContent;
import com.ccr.hackathon.backend.repository.ManagementContentRepository;
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
public class ManagementContentController {

    @Autowired
    private ManagementContentRepository managementContentRepository;


    @ApiOperation(value = "Create a new Management content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Management successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred, it was not possible to complete your request")
    }
    )
    @PostMapping("/management")
    public ManagementContent createManagementContent(@Valid @RequestBody ManagementContent managementContent) {
        return managementContentRepository.save(managementContent);
    }


    @ApiOperation(value = "List all Management Content")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Managenet content  was listed with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("/management")
    public List<ManagementContent> getAllManagementContent() {
        return managementContentRepository.findAll();
    }


    @ApiOperation(value = "Find a Management content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Managenet content find with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("management/{id}")
    public ResponseEntity<ManagementContent> getManagementContentContentById(@PathVariable(value = "id") Long managementContentId)
            throws ResourceNotFoundException {
        ManagementContent managementContent = managementContentRepository.findById(managementContentId)
                .orElseThrow(() -> new ResourceNotFoundException("Digital Marketing Content not found :: " + managementContentId));
        return ResponseEntity.ok().body(managementContent);
    }


    @ApiOperation(value = "Delete a Management Content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = " Management Content Content deleted with success"),
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
        return response;
    }
}
