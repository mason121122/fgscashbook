package com.fgs.fgscashbook.Controller;

import com.fgs.fgscashbook.enums.ResultEnum;
import com.fgs.fgscashbook.po.UserPo;
import com.fgs.fgscashbook.service.UserService;
import com.fgs.fgscashbook.support.ReturnResult;
import com.fgs.fgscashbook.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangfeng
 * @NAME: UserController
 * @DATE: 2020/9/6
 **/
@Api("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "查询账户信息", notes = "查询账户信息")
    @RequestMapping(value = {"/user"}, method = {RequestMethod.GET}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReturnResult<UserVo> find(
            @ApiParam(name = "id", value = "账户id", required = true) @RequestParam(value = "id", required = true) Integer id) {
        return new ReturnResult<>(ResultEnum.SUCCESS.getCode(),
                ResultEnum.SUCCESS.getDesc(), userService.find(id));
    }

    @ApiOperation(value = "注销账户", notes = "注销账户")
    @RequestMapping(value = {"/user"}, method = {RequestMethod.DELETE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReturnResult<UserVo> del() {

        return null;
    }

    @ApiOperation(value = "修改账户信息", notes = "修改账户信息")
    @RequestMapping(value = {"/user"}, method = {RequestMethod.PUT}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReturnResult<UserVo> update() {

        return null;
    }

    @ApiOperation(value = "新增账户", notes = "新增账户")
    @RequestMapping(value = {"/user"}, method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ReturnResult<UserVo> ins(@RequestBody List<UserPo> userPos) {

        List<UserPo> user = new ArrayList<>();
        userPos.get(1).setNickname(null);
        userService.ins(userPos);
        return null;
    }
}
