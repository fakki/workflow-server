package com.shanmingc.workflow.entity;

import lombok.Data;

@Data
public class Response {
    private final int status_code;
    private final String msg;
    private final Object data;
}
