package com.westpacgroup.westpac.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@EqualsAndHashCode
public class Geo {
    private String lat;
    private String lng;

    public Geo(){ }
}
