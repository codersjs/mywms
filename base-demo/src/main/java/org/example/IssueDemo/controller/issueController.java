package org.example.IssueDemo.controller;


import org.example.IssueDemo.model.IssueRequest;
import org.example.IssueDemo.service.IssueService;
import org.example.utilAndCommonDemo.Response.ResultData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class issueController {

    @Resource
    private IssueService issueService;

    @PostMapping("/issue/create")
    public ResultData createIssue(IssueRequest request) {
        issueService.createIssue(request);
        return ResultData.sucess("200",null);
    }

}
