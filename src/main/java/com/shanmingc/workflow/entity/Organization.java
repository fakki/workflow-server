package com.shanmingc.workflow.entity;

import lombok.Data;

@Data
public class Organization {
    private final Integer id;
    private final String label;
    private final Integer superior_id;
}
