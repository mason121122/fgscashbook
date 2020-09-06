package com.fgs.fgscashbook.mapper;

import com.fgs.fgscashbook.bo.UserBo;
import com.fgs.fgscashbook.po.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public UserBo find(Integer id);

    public UserBo del(UserPo userPo);

    public UserBo update(UserPo userPo);

    public UserBo ins(UserPo userPo);
}
