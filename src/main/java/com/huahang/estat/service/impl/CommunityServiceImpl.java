package com.huahang.estat.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huahang.estat.common.MessageConstant;
import com.huahang.estat.common.PageResult;
import com.huahang.estat.common.StatusCode;
import com.huahang.estat.dao.CommunityMapper;
import com.huahang.estat.domain.Community;
import com.huahang.estat.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;


import java.util.Map;
/**
 * @Auth: zhuan
 * @Desc: 小区模块业务层实现
 */
@Service
public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityMapper communityMapper;

    @Override
    public PageResult search(Map searchMap) {
        //指定查询的表
        Example example = new Example(Community.class);
        if(searchMap != null) {
            //查询条件
            Example.Criteria criteria = example.createCriteria();
            //添加条件
            String name = (String)searchMap.get("name");
            if(StringUtil.isNotEmpty(name)){
                criteria.andLike("name","%"+name+"%");
            }
            String startTime = (String) searchMap.get("startTime");
            if(StringUtil.isNotEmpty(startTime)){
                criteria.andGreaterThanOrEqualTo("createTime",startTime);
            }
            String endTime = (String) searchMap.get("endTime");
            if(StringUtil.isNotEmpty(endTime)){
                criteria.andLessThanOrEqualTo("createTime",endTime);
            }
            int pageNum = 1;//默认值
            int pageSize = 2;//默认值
            if((Integer) searchMap.get("pageNum") !=null){
                pageNum = (Integer) searchMap.get("pageNum");
            }
            if((Integer) searchMap.get("pageSize") !=null){
                pageSize = (Integer) searchMap.get("pageSize");
            }
            //特别注意：该行代码后面要紧跟要执行的查询语句
            PageHelper.startPage(pageNum,pageSize);
        }
        Page<Community> page = (Page<Community>) communityMapper.selectByExample(example);
        return new PageResult(true, StatusCode.OK, MessageConstant.COMMUNITY_SEARCH_SUCCESS,page.getResult(),page.getTotal());
    }

    @Override
    public void add(Community community) {
        communityMapper.insertSelective(community);
    }
}
