package com.dallase.api_rest.dto;

import java.io.Serializable;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CustomerDto implements Serializable {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private Date createdAt;
}
