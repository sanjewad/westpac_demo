package com.westpacgroup.westpac.controller.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder
public class AdminSearchResponse {
    private List<UserPostDto> userPostDtos;

    public AdminSearchResponse(){}


}
