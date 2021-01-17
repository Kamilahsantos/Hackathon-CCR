package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.exception.ResourceNotFoundException;
import com.ccr.hackathon.backend.model.DigitalMarketingContent;
import com.ccr.hackathon.backend.repository.DigitalMarketingContentRepository;
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
public class DigitalMarketingContentController {

    @Autowired
    private DigitalMarketingContentRepository digitalMarketingContentRepository;


    @ApiOperation(value = "Create a new Digital Marketing content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Digital Marketing successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred, it was not possible to complete your request")
    }
    )
    @PostMapping("/digitalmarketing")
    public DigitalMarketingContent createDigitalMarketing(@Valid @RequestBody DigitalMarketingContent digitalMarketingContent) {
        return digitalMarketingContentRepository.save(digitalMarketingContent);
    }


    @ApiOperation(value = "List all Digital Marketing content")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Digital Marketing  was listed with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("/digital_marketing")
    public List<DigitalMarketingContent> getAllDigitalMarketingContent() {
        return digitalMarketingContentRepository.findAll();
    }


    @ApiOperation(value = "Find a Digital Marketing content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Digital Marketing find with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("digital_marketing/{id}")
    public ResponseEntity<DigitalMarketingContent> getDigitalMarketingContentById(@PathVariable(value = "id") Long digitalmarketingId)
            throws ResourceNotFoundException {
        DigitalMarketingContent digitalMarketingContent = digitalMarketingContentRepository.findById(digitalmarketingId)
                .orElseThrow(() -> new ResourceNotFoundException("Digital Marketing Content not found :: " + digitalmarketingId));
        return ResponseEntity.ok().body(digitalMarketingContent);
    }


    @ApiOperation(value = "Update a user by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "user updated with success"),
            @ApiResponse(code = 500, message = "An internal error occurred w it was not possible to complete your request")
    }
    )
    @PatchMapping("/digital_marketing/{id}")
    public ResponseEntity<DigitalMarketingContent> updateDigitalMarketing(@PathVariable(value = "id") Long digitalMarketingContentId,
                                                                          @Valid @RequestBody DigitalMarketingContent digitalMarketingContentDetails) throws ResourceNotFoundException {
        DigitalMarketingContent digitalMarketingContent = digitalMarketingContentRepository.findById(digitalMarketingContentId)
                .orElseThrow(() -> new ResourceNotFoundException("DigitalMarketingContent not found for this id :: " + digitalMarketingContentId));


        digitalMarketingContent.setDescription(digitalMarketingContentDetails.getDescription());
        digitalMarketingContent.setTitle(digitalMarketingContentDetails.getTitle());
        digitalMarketingContent.setUrl(digitalMarketingContentDetails.getUrl());


        final DigitalMarketingContent updateContent = digitalMarketingContentRepository.save(
                digitalMarketingContent
        );
        return ResponseEntity.ok(updateContent);
    }


    @ApiOperation(value = "Delete a Digital Marketing Content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Digital Marketing Content deleted with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @DeleteMapping("/digital_marketing/{id}")
    public Map<String, Boolean> deleteDigitalMarketingContent(@PathVariable(value = "id") Long digitalMarketingContentId)
            throws ResourceNotFoundException {
        DigitalMarketingContent digitalMarketingContent = digitalMarketingContentRepository.findById(digitalMarketingContentId)
                .orElseThrow(() -> new ResourceNotFoundException(" Digital Marketing Content not found for this id :: " + digitalMarketingContentId));

        digitalMarketingContentRepository.delete(digitalMarketingContent);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
