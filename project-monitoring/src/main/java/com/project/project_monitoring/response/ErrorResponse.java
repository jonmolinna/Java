package com.project.project_monitoring.response;


import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private String error;
    private int statusCode;
    private List<String> message;
}
