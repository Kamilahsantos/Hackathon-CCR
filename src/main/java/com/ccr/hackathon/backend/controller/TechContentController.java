package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.exception.ResourceNotFoundException;
import com.ccr.hackathon.backend.model.TechContent;
import com.ccr.hackathon.backend.repository.TechContentRepository;
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
public class TechContentController {

    @Autowired
    private TechContentRepository techContentRepository;


    @ApiOperation(value = "Create a new tech content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "tech content successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred, it was not possible to complete your request")
    }
    )
    @PostMapping("/tech")
    public TechContent createTechContent(@Valid @RequestBody TechContent techContent) {
        return techContentRepository.save(techContent);
    }


    @ApiOperation(value = "List all tech content")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "tech contents  was listed with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("/tech")
    public List<TechContent> getAllTechContents() {
        return techContentRepository.findAll();
    }


    @ApiOperation(value = "Find a content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "content find with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("tech/{id}")
    public ResponseEntity<TechContent> getTechContentById(@PathVariable(value = "id") Long contentId)
            throws ResourceNotFoundException {
        TechContent techContent = techContentRepository.findById(contentId)
                .orElseThrow(() -> new ResourceNotFoundException("Content not found :: " + contentId));
        return ResponseEntity.ok().body(techContent);
    }


    @ApiOperation(value = "Update a tech content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "content updated with success"),
            @ApiResponse(code = 500, message = "An internal error occurred w it was not possible to complete your request")
    }
    )
    @PutMapping("/tech/{id}")
    public ResponseEntity<TechContent> updateTechContent(@PathVariable(value = "id") Long contentId,
                                                         @Valid @RequestBody TechContent contentDetails) throws ResourceNotFoundException {
        TechContent techContent = techContentRepository.findById(contentId)
                .orElseThrow(() -> new ResourceNotFoundException("Tech Content not found for this id :: " + contentId));


        techContent.setTitle(contentDetails.getTitle());
        techContent.setDescription(contentDetails.getDescription());
        techContent.setUrl(contentDetails.getUrl());
        techContent.setLevel(contentDetails.getLevel());



        final TechContent updateTechContent = techContentRepository.save(
                techContent
        );
        return ResponseEntity.ok(updateTechContent);
    }


    @ApiOperation(value = "Delete a tech content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "tech content deleted with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @DeleteMapping("/tech/{id}")
    public Map<String, Boolean> deleteTechContent(@PathVariable(value = "id") Long contentId)
            throws ResourceNotFoundException {
        TechContent techContent = techContentRepository.findById(contentId)
                .orElseThrow(() -> new ResourceNotFoundException("Tech content not found for this id :: " + contentId));

        techContentRepository.delete(techContent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
