package com.fgs.fgscashbook.service;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.support.ReturnResult;
import com.fgs.fgscashbook.vo.UserVo;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;

public interface UserService {

    UserVo find(Integer id);

    UserVo del(UserBo userBo);

    UserVo update(UserBo userBo);

    UserVo ins(UserBo userBo);

}
