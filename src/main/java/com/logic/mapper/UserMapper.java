package com.logic.mapper;

import com.logic.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jiming.luo
 * @date 2018/1/31 13:32
 * @since 1.0
 */
@Mapper
public interface UserMapper {
    Integer addUser(User user);

    List<User> listUsers();

    /**
     * 修改User
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);
}
