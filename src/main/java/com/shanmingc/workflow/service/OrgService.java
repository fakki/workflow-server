package com.shanmingc.workflow.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shanmingc.workflow.entity.Organization;
import com.shanmingc.workflow.entity.OrganizationTree;
import com.shanmingc.workflow.mapper.OrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrgService {

    private OrgMapper mapper;

    @Autowired
    public OrgService(OrgMapper m) {
        mapper = m;
    }

    public List<Organization> queryAll() {
        return mapper.selectList(null);
    }

    public List<OrganizationTree> queryAllFormatTree() {
        return OrganizationTree.toFormatTree(queryAll());
    }



    public List<Organization> queryPaged(int page, int pageSize) {
        IPage<Organization> orgPage = new Page<>(page, pageSize);
        orgPage = mapper.selectPage(orgPage, null);
        return orgPage.getRecords();
    }

    public Integer querySize() {
        return mapper.selectCount(null);
    }
}
