package com.westpacgroup.westpac.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@EqualsAndHashCode
public class Post {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;

    public Post(){}
}
