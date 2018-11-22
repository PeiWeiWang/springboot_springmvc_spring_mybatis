package net.wanho.service;

import net.wanho.entity.User;
import net.wanho.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public List<User> queryUsers() {
        return userMapper.query();
    }

    @Transactional(readOnly = true)
    public void delete(int id) {
        userMapper.delete(id);
    }

    public User getUserById(int id)
    {
        return userMapper.get(id);
    }

    public void insertUser(String name) {
        userMapper.insert(name);
    }

    public void update(int id, String name) {
        userMapper.update(id,name);
    }
}
