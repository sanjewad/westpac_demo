package com.westpacgroup.westpac.service;

import com.westpacgroup.westpac.controller.dto.UserPostDto;
import com.westpacgroup.westpac.model.Post;
import com.westpacgroup.westpac.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AdminPostManagementService {

    private static final Logger logger = LoggerFactory.getLogger(AdminPostManagementService.class);

    private static final String USER_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    public List<UserPostDto> callUserPost() {
        List<UserPostDto> postDtos = new ArrayList<>();
        try {
            ResponseEntity<List<User>> userResponse = restTemplate
                    .exchange(USER_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                    });

            ResponseEntity<List<Post>> postResponse = restTemplate
                    .exchange(POST_URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<Post>>() {
                    });

            Map<Integer, List<Post>> posts = postResponse.getBody()
                    .stream()
                    .collect(Collectors.groupingBy(Post::getUserId));
            new LinkedHashSet<>(Objects.requireNonNull(userResponse.getBody())).forEach(
                    user -> {
                        if (posts.containsKey(user.getId())) {
                            UserPostDto userPostDto = UserPostDto.builder()
                                    .user(user)
                                    .posts(posts.get(user.getId()))
                                    .build();
                            postDtos.add(userPostDto);
                        } else {
                            logger.info(String.format("Post not found for user Id %s", user.getId()));
                        }
                    }
            );
        } catch (HttpStatusCodeException exception) {
            throw new IllegalArgumentException("Exception occurred accessing external api", exception);
        }
        return postDtos;
    }

}
