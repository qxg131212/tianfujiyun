package com.xg.service;

import com.baomidou.mybatisplus.service.IService;
import com.xg.common.BaseResponse;
import com.xg.common.TableResultResponse;
import com.xg.entity.User;
import com.xg.entity.fo.UserFo;
import com.xg.entity.fo.UsersFo;

import java.util.List;

public interface UserService{

    TableResultResponse getAllUser(UserFo userFo);

    BaseResponse delectUserId(String id);

    BaseResponse updateOrInsert(UsersFo usersFo);
}
