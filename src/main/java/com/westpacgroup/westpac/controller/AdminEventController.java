package com.westpacgroup.westpac.controller;

import com.westpacgroup.westpac.controller.dto.AdminSearchResponse;
import com.westpacgroup.westpac.controller.dto.UserPostDto;
import com.westpacgroup.westpac.service.AdminPostManagementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "Westpac Admin API", description = "API expose to retrieve all user posts")
public class AdminEventController {
    private static final Logger logger = LoggerFactory.getLogger(AdminEventController.class);


    @Autowired
    private AdminPostManagementService adminPostManagementService;


    @ApiOperation(value = "Result of getting all user posts", response = AdminSearchResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @GetMapping(value = "/search/posts", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdminSearchResponse getUserPostList() {

        logger.debug("Search data with product Id ");

        List<UserPostDto> userPosts = adminPostManagementService.
                callUserPost();
        return AdminSearchResponse.builder()
                .userPostDtos(userPosts)
                .build();
    }
}
