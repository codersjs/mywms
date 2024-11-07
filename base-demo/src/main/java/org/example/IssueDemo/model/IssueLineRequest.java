package org.example.IssueDemo.model;

import lombok.Data;

@Data
public class IssueLineRequest {
    private Long spuid;
    private Long specid;
    private Double num;
}
