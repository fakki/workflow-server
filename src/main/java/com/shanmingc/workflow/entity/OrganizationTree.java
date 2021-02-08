package com.shanmingc.workflow.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class OrganizationTree {

    private final int id;
    private final String label;

    private List<OrganizationTree> children;

    public OrganizationTree(Organization o) {
        label = o.getLabel();
        id = o.getId();
        children = new ArrayList<>();
    }

    public void addInferior(OrganizationTree i) {
        this.children.add(i);
    }

    public static List<OrganizationTree> toFormatTree(List<Organization> orgs) {
        int size = orgs.size();
        List<OrganizationTree> trees = new ArrayList<>();

        // 记录组织id到数组索引的表
        Map<Integer, Integer> map = new HashMap<>();

        // 填表并将Org转换为OrgTree
        for(int i = 0; i < size; i++) {
            map.put(orgs.get(i).getId(), i);
            trees.add(new OrganizationTree(orgs.get(i)));
        }

        // 填OrgTree的children属性
        for(int i = 0; i < size; i++) {
            Organization org = orgs.get(i);
            int sup_id;
            if((sup_id = org.getSuperior_id()) == 0)
                continue;
            int supPos = map.get(sup_id);
            trees.get(supPos).addInferior(trees.get(i));
        }

        // 选取根组织
        List<OrganizationTree> res = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            if(orgs.get(i).getSuperior_id() == 0)
                res.add(trees.get(i));
        }

        return res;
    }
}
