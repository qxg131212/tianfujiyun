package com.xg.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xg.biz.UserServiceBiz;
import com.xg.biz.impl.UserServiceBizImpl;
import com.xg.common.BaseResponse;
import com.xg.common.TableResultResponse;
import com.xg.dao.UserDao;
import com.xg.entity.User;
import com.xg.entity.fo.UserFo;
import com.xg.entity.fo.UsersFo;
import com.xg.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceBizImpl.class);

    @Autowired
    private  UserDao userDao;

 /*   @Autowired
    private UserServiceBiz userServiceBiz;*/

    @Override
    public TableResultResponse getAllUser(UserFo userFo) {
        if (userFo == null) {
            return new TableResultResponse();
        }
        logger.info("查询条件："+userFo.getEntityWrapper());
        List<User> list = userDao.selectList(userFo.getEntityWrapper());
        logger.info("结果为:"+userDao.selectList(userFo.getEntityWrapper()).toString());
        TableResultResponse response = new TableResultResponse(list.size(), list);
        return response;
    }

    @Override
    public BaseResponse delectUserId(String id) {
        if (StringUtils.isBlank(id)){
            return new TableResultResponse();
        }
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("u_id",id);
        List<User> users = userDao.selectList(wrapper);
        BaseResponse response = new BaseResponse();
        User user = users.get(0);
        user.setU_delete(true);
//        userDao.updateById(user); 不能用对象来操作
        userDao.update(user,wrapper);
        response.setMessage("删除成功");
        return response;
    }

    @Override
    public BaseResponse updateOrInsert(UsersFo usersFo) {
        BaseResponse response = new BaseResponse();
        if (usersFo == null) {
            response.setMessage("参数为空");
            return response;
        }
        if (StringUtils.isNotBlank(usersFo.getU_id())) {
            User user = userDao.selectById(usersFo.getU_id());
            if (user == null) {
                response.setMessage("暂无此数据");
                return response;
            }
            BeanUtils.copyProperties(usersFo,user);
            userDao.updateById(user);
            response.setMessage("更新成功");
            return response;
        }
        // **********问题同上可以搞起来***********
        /*EntityWrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtils.isBlank(usersFo.getU_name())) {
            wrapper.eq("u_name",usersFo.getU_name());
            List<User> users = userDao.selectList(wrapper);
            if (users != null) {
                response.setMessage("此名字已存在，重名后面加1或者大小区分");
                return  response;
            }
        }

        */
        // *********************
        User user = new User();
        user.setU_delete(false);
        user.setU_id(UUID.randomUUID().toString());
        BeanUtils.copyProperties(usersFo, user);
        userDao.insert(user);
        response.setMessage("添加成功");

        return response;
    }


}
