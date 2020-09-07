package com.fgs.fgscashbook.mapper;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    UserBo find(Integer id);

    UserBo del(UserPo userPo);

    UserBo update(UserPo userPo);

    UserBo ins(UserPo userPo);
}
