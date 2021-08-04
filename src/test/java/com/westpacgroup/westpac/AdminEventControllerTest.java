package com.westpacgroup.westpac;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdminEventControllerTest {
    private HttpHeaders authHeaders;
    @Autowired
    private TestRestTemplate template;

    @Before
    public void init() {
        authHeaders = new HttpHeaders();
    }

    @Test
    public void searchAllUserPosts() {
        authHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JsonNode> result = template.exchange("/search/posts", HttpMethod.GET, new HttpEntity<>(authHeaders), JsonNode.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        JsonNode jsonNodeRes = result.getBody().get("userPostDtos");
        assertEquals(10, jsonNodeRes.get(0).get("posts").size());
        assertEquals(10, jsonNodeRes.get(1).get("posts").size());
        assertEquals(10, jsonNodeRes.get(2).get("posts").size());
        assertEquals(10, jsonNodeRes.get(3).get("posts").size());
        assertEquals(10, jsonNodeRes.get(4).get("posts").size());
        assertEquals(10, jsonNodeRes.get(5).get("posts").size());
        assertEquals(10, jsonNodeRes.get(6).get("posts").size());
        assertEquals(10, jsonNodeRes.get(7).get("posts").size());
    }

    @Test
    public void inValidUrl() {
        authHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseEntity<JsonNode> result = template.exchange("/search/post", HttpMethod.GET, new HttpEntity<>(authHeaders), JsonNode.class);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

}