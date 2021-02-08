package com.shanmingc.workflow;

import com.shanmingc.workflow.entity.Organization;
import com.shanmingc.workflow.entity.OrganizationTree;
import com.shanmingc.workflow.mapper.OrgMapper;
import com.shanmingc.workflow.service.OrgService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WorkFlowApplicationTests {

    @Autowired
    OrgService orgService;

    @Test
    void contextLoads() {
    }

    @Autowired
    private OrgMapper orgMapper;

    @Test
    public void testSelect() {
        List<OrganizationTree> orgList = orgService.queryAllFormatTree();;
        System.out.println(orgList);
        orgList.forEach(System.out::println);
    }

}
