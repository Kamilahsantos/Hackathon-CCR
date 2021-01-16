package com.ccr.hackathon.backend.controller;

import com.ccr.hackathon.backend.model.TechContent;
import com.ccr.hackathon.backend.repository.TechContentRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/api/v1")
@RestController
public class TechContentController {

    @Autowired
    private TechContentRepository techContentRepository;


    @ApiOperation(value = "Create a new activity")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "activity successfully created"),
            @ApiResponse(code = 500, message = "An internal error occurred while creating the claim, it was not possible to complete your request")
    }
    )
    @PostMapping("/techcontent")
    public TechContent createTechContent(@Valid @RequestBody TechContent techContent) {
        return techContentRepository.save(techContent);
    }
}
