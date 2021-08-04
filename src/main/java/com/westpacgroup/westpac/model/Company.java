package com.westpacgroup.westpac.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
@EqualsAndHashCode
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company(){}
}
