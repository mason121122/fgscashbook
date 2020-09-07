package com.fgs.fgscashbook.service.impl;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.enums.ResultEnum;
import com.fgs.fgscashbook.mapper.UserMapper;
import com.fgs.fgscashbook.service.UserService;
import com.fgs.fgscashbook.support.BsRuntimeException;
import com.fgs.fgscashbook.utils.AbstractBaseDomain;
import com.fgs.fgscashbook.utils.BeanCopierUtils;
import com.fgs.fgscashbook.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

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
    public UserVo find(Integer id){
        userMapper.find(id);
        UserVo userVo = new UserVo();
        BeanCopierUtils.copyProperties(userMapper.find(id),userVo);
        return userVo;
    }

    @Override
    public UserVo del(UserBo userBo) {
        return null;
    }

    @Override
    public UserVo update(UserBo userBo) {
        return null;
    }

    @Override
    public UserVo ins(UserBo userBo) {
        return null;
    }
}
