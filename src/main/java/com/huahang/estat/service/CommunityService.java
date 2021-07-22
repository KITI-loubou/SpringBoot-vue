package com.huahang.estat.service;


import com.huahang.estat.common.PageResult;
import com.huahang.estat.domain.Community;

import java.util.Map;

public interface CommunityService {

    public PageResult search(Map searchMap);

    public void add(Community community);
}
