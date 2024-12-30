package com.dallase.api_rest.response;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class MessageResponse {
    private String message;
    private Object object;
}
