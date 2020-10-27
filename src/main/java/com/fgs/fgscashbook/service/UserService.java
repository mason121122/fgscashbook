package com.fgs.fgscashbook.service;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.po.UserPo;
import com.fgs.fgscashbook.support.ReturnResult;
import com.fgs.fgscashbook.vo.UserVo;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface UserService {

    UserVo find(Integer id);

    int del(UserBo userBo);

    int update(UserBo userBo);

    int ins(List<UserPo> userBo);

}
