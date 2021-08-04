package com.westpacgroup.westpac.controller.dto;

import com.westpacgroup.westpac.model.Post;
import com.westpacgroup.westpac.model.User;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@Builder
@Data
public class UserPostDto {
    private User user;
    private List<Post> posts;

    public UserPostDto(){}
}
