package com.fgs.fgscashbook.mapper;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.po.UserPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    UserBo find(Integer id);

    int del(UserPo userPo);

    int update(UserPo userPo);

    int ins(List<UserPo> userPo);
}
