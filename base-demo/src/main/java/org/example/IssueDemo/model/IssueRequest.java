package org.example.IssueDemo.model;

import lombok.Data;

import java.util.List;

@Data
public class IssueRequest {

    private String name;
    private String telephne;
    private String addresss;
    private List<IssueLineRequest> list;

}
