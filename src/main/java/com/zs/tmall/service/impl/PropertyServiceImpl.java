package com.zs.tmall.service.impl;

import com.zs.tmall.mapper.PropertyMapper;
import com.zs.tmall.pojo.Property;
import com.zs.tmall.pojo.PropertyExample;
import com.zs.tmall.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 98050
 * Time: 2018-09-18 17:52
 * Feature:CRUD
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    @Override
    public void add(Property property) {
        propertyMapper.insert(property);
    }

    @Override
    public void delete(Integer id) {
        propertyMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(Property property) {
        propertyMapper.updateByPrimaryKeySelective(property);
    }

    @Override
    public Property get(Integer id) {
        return propertyMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Property> list(Integer cid) {
        PropertyExample example = new PropertyExample();
        example.createCriteria().andCidEqualTo(cid);
        example.setOrderByClause("id desc");
        return propertyMapper.selectByExample(example);
    }
}
