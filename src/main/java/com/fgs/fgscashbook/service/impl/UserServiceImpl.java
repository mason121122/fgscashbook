package com.fgs.fgscashbook.service.impl;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.mapper.UserMapper;
import com.fgs.fgscashbook.po.UserPo;
import com.fgs.fgscashbook.service.UserService;
import com.fgs.fgscashbook.utils.AbstractBaseDomain;
import com.fgs.fgscashbook.utils.BeanCopierUtils;
import com.fgs.fgscashbook.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangfeng
 * @NAME: UserServiceImpl
 * @DATE: 2020/9/6
 **/
@Service
public class UserServiceImpl extends AbstractBaseDomain implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserVo find(Integer id) {
        userMapper.find(id);
        UserVo userVo = new UserVo();
        BeanCopierUtils.copyProperties(userMapper.find(id), userVo);
        return userVo;
    }

    @Override
    public int del(UserBo userBo) {
        return 0;
    }

    @Override
    public int update(UserBo userBo) {
        return 0;
    }

    @Override
    public int ins(List<UserPo> userPo) {
        int i = userMapper.ins(userPo);

        System.out.println(i);
        throw new RuntimeException("手动异常");
    }
}
