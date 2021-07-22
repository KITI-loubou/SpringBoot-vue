package com.huahang.estat.controller;

import com.huahang.estat.common.MessageConstant;
import com.huahang.estat.common.StatusCode;
import com.huahang.estat.common.PageResult;
import com.huahang.estat.common.Result;
import com.huahang.estat.domain.Community;
import com.huahang.estat.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
/**
 * @Auth: zhuan
 * @Desc: 小区模块控制层代码
 */
@RestController
@RequestMapping("/community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @RequestMapping("/search")
    public PageResult search(@RequestBody Map map){
        PageResult result = communityService.search(map);
        return result;
    }

    @RequestMapping("/add")
    public Result search(@RequestBody Community community){
        communityService.add(community);
        return new Result(true, StatusCode.OK, MessageConstant.COMMUNITY_ADD_SUCCESS);
    }

}
