package com.shanmingc.workflow.controller;

import com.shanmingc.workflow.entity.Organization;
import com.shanmingc.workflow.entity.OrganizationTree;
import com.shanmingc.workflow.service.OrgService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/api/org")
public class OrgController {

    private OrgService orgService;

    @Autowired
    public OrgController(OrgService os) {
        orgService = os;
    }

    @GetMapping("/query/all")
    @ResponseBody
    public List<Organization> queryAll() {
        log.info("query all");
        return orgService.queryAll();
    }

    @GetMapping("/query/all/tree")
    @ResponseBody
    public List<OrganizationTree> queryAllFormatTree() {
        log.info("query all tree");
        return orgService.queryAllFormatTree();
    }

    @GetMapping("/query/paged")
    @ResponseBody
    public List<Organization> queryPaged(@RequestParam int page, @RequestParam int pageSize) {
        log.info("query page " + page + "(pageSize = " + pageSize + ")");
        return orgService.queryPaged(page, pageSize);
    }

    @GetMapping("/query/size")
    @ResponseBody
    public Integer querySize() {
        log.info("query size");
        return orgService.querySize();
    }

    @PostMapping("/add")
    @ResponseBody
    public void addOrg(@RequestParam int superior_id, @RequestParam String org_label) {
        log.info("add an organization named " + "\"" + org_label + "\"");
    }
}
