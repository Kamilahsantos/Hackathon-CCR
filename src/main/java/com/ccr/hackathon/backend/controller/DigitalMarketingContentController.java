package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.exception.ResourceNotFoundException;
import com.ccr.hackathon.backend.model.DigitalMarketingContent;
import com.ccr.hackathon.backend.repository.DigitalMarketingContentRepository;
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
public class DigitalMarketingContentController {

    @Autowired
    private DigitalMarketingContentRepository digitalMarketingContentRepository;


    @ApiOperation(value = "Create a new Digital Marketing content")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Digital Marketing content successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred, it was not possible to complete your request")
    }
    )
    @PostMapping("/digital_marketing")
    public DigitalMarketingContent createDigitalMarketingContent(@Valid @RequestBody DigitalMarketingContent digitalMarketingContent) {
        log.info("Creating a new Digital Marketing content {}, {} , {}  e {}  ", digitalMarketingContent.getTitle(), digitalMarketingContent.getDescription(), digitalMarketingContent.getUrl(), digitalMarketingContent.getLevel());

        return digitalMarketingContentRepository.save(digitalMarketingContent);
    }


    @ApiOperation(value = "List all Digital Marketing content")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Digital Marketing  content was listed with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("/digital_marketing")
    public List<DigitalMarketingContent> getAllDigitalMarketingContent() {
        log.info("Listing all Digital Marketing content");
        return digitalMarketingContentRepository.findAll();
    }


    @ApiOperation(value = "Find a Digital Marketing content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Digital Marketing content  find with success"),
            @ApiResponse(code = 500, message = "An internal error occurred , it was not possible to complete your request")
    }
    )
    @GetMapping("digital_marketing/{id}")
    public ResponseEntity<DigitalMarketingContent> getDigitalMarketingContentById(@PathVariable(value = "id") Long digitalMarketingId)
            throws ResourceNotFoundException {
        DigitalMarketingContent digitalMarketingContent = digitalMarketingContentRepository.findById(digitalMarketingId)
                .orElseThrow(() -> new ResourceNotFoundException("Digital Marketing Content not found :: " + digitalMarketingId));
        log.info("Find a Digital Marketing content with id {} ", digitalMarketingId);
        return ResponseEntity.ok().body(digitalMarketingContent);
    }


    @ApiOperation(value = "Update a Digital Marketing content by Id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Digital Marketing content updated with success"),
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
        digitalMarketingContent.setLevel(digitalMarketingContentDetails.getLevel());


        final DigitalMarketingContent updateContent = digitalMarketingContentRepository.save(
                digitalMarketingContent
        );
        log.info("Digital marketing content with id  {} updated with success ", digitalMarketingContent);
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
        log.info("Digital Marketing Content with id {}  deleted with success ", digitalMarketingContentId);
        return response;
    }
}
