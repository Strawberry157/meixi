package com.huanke.iot.user.service.user;

import com.huanke.iot.base.exception.BusinessException;
import com.huanke.iot.base.util.MD5Util;
import com.huanke.iot.user.dao.user.UserManagerMapper;
import com.huanke.iot.user.model.user.LoginRsp;
import com.huanke.iot.user.model.user.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserManagerMapper userManagerMapper;

    @Value("${saltEncrypt}")
    private String saltEncrypt;

    @SuppressWarnings("unchecked")
    public LoginRsp login(String userName, String pwd) {

        UserValidator.getInstance().validateLogin(userName, pwd);

        String password = MD5Util.md5(MD5Util.md5(pwd) + saltEncrypt);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (!subject.isAuthenticated()) {
                throw new AccountException();
            }
        } catch (IncorrectCredentialsException | AccountException e) {
            throw new AccountException("用户名或密码错误");
        }
        //返回用户信息（置空密码）和权限
        LoginRsp rsp = new LoginRsp();
        User user = (User) subject.getSession().getAttribute("user");
        user.setPassword(null);
        rsp.setUser(user);
        rsp.setPermissions((List<String>) subject.getSession().getAttribute("permission"));
        return rsp;
    }

    public Boolean logout() {

        final Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return true;
    }

    public User getCurrentUser() {

        User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        user.setPassword(null);
        return user;
    }

    public Integer createUser(User user) {

        UserValidator.getInstance().validateCreateUser(user);
        if (null != userManagerMapper.selectByUserName(user.getUserName())) {
            throw new BusinessException("用户名已存在");
        }
        user.setPassword(MD5Util.md5(MD5Util.md5(user.getPassword()) + saltEncrypt));
        userManagerMapper.insert(user);
        return user.getId();
    }

    public Boolean updateUser(User user) {

        UserValidator.getInstance().validateUpdateUser(user);
        return 1 == userManagerMapper.updateById(user);
    }

    public Boolean delUser(Integer userId) {

        UserValidator.getInstance().validateDelUser(userId);
        return 1 == userManagerMapper.deleteById(userId);
    }

    public List<User> getUserList() {

        return userManagerMapper.selectAll();
    }
}
