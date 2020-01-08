package com.xg.biz.impl;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xg.biz.UserServiceBiz;
import com.xg.entity.User;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceBizImpl implements UserServiceBiz {
    @Override
    public boolean insert(User user) {
        return false;
    }

    @Override
    public boolean insertAllColumn(User user) {
        return false;
    }

    @Override
    public boolean insertBatch(List<User> list) {
        return false;
    }

    @Override
    public boolean insertBatch(List<User> list, int i) {
        return false;
    }

    @Override
    public boolean insertOrUpdateBatch(List<User> list) {
        return false;
    }

    @Override
    public boolean insertOrUpdateBatch(List<User> list, int i) {
        return false;
    }

    @Override
    public boolean insertOrUpdateAllColumnBatch(List<User> list) {
        return false;
    }

    @Override
    public boolean insertOrUpdateAllColumnBatch(List<User> list, int i) {
        return false;
    }

    @Override
    public boolean deleteById(Serializable serializable) {
        return false;
    }

    @Override
    public boolean deleteByMap(Map<String, Object> map) {
        return false;
    }

    @Override
    public boolean delete(Wrapper<User> wrapper) {
        return false;
    }

    @Override
    public boolean deleteBatchIds(Collection<? extends Serializable> collection) {
        return false;
    }

    @Override
    public boolean updateById(User user) {
        return false;
    }

    @Override
    public boolean updateAllColumnById(User user) {
        return false;
    }

    @Override
    public boolean update(User user, Wrapper<User> wrapper) {
        return false;
    }

    @Override
    public boolean updateBatchById(List<User> list) {
        return false;
    }

    @Override
    public boolean updateBatchById(List<User> list, int i) {
        return false;
    }

    @Override
    public boolean updateAllColumnBatchById(List<User> list) {
        return false;
    }

    @Override
    public boolean updateAllColumnBatchById(List<User> list, int i) {
        return false;
    }

    @Override
    public boolean insertOrUpdate(User user) {
        return false;
    }

    @Override
    public boolean insertOrUpdateAllColumn(User user) {
        return false;
    }

    @Override
    public User selectById(Serializable serializable) {
        return null;
    }

    @Override
    public List<User> selectBatchIds(Collection<? extends Serializable> collection) {
        return null;
    }

    @Override
    public List<User> selectByMap(Map<String, Object> map) {
        return null;
    }

    @Override
    public User selectOne(Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public Map<String, Object> selectMap(Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public Object selectObj(Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public int selectCount(Wrapper<User> wrapper) {
        return 0;
    }

    @Override
    public List<User> selectList(Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public Page<User> selectPage(Page<User> page) {
        return null;
    }

    @Override
    public List<Map<String, Object>> selectMaps(Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public List<Object> selectObjs(Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public Page<Map<String, Object>> selectMapsPage(Page page, Wrapper<User> wrapper) {
        return null;
    }

    @Override
    public Page<User> selectPage(Page<User> page, Wrapper<User> wrapper) {
        return null;
    }
}
