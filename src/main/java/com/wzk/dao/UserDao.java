package com.wzk.dao;

import com.wzk.entity.User;
import com.wzk.entity.UserAcCode;
import com.wzk.entity.UserState;

/**
 * @author DanRan233
 * @projectName MS_company
 * @description: TODO
 * @date 2020/11/11 20:23
 */
public interface UserDao {

    /**
     * description  TODO
     * date         2020/11/15 17:12
     * @author      DanRan233
     * @Param       [user]
     * @return      com.wzk.entity.User
     */
    User getTel(User user);

    /**
     * description  TODO
     * date         2020/11/12 0:04
     * @author      DanRan233
     * @Param       [user]
     * @return      int
     */
    int addUser(User user);

    /**
     * description  TODO
     * date         2020/11/12 12:05
     * @author      DanRan233
     * @Param       [user]
     * @return      com.wzk.entity.User
     */
    User loginUser(User user);

    /**
     * description  TODO
     * date         2020/11/12 12:05
     * @author      DanRan233
     * @Param       [user]
     * @return      int
     */
    int updateUserStateId(User user);

    /**
     * description  TODO
     * date         2020/11/12 15:13
     * @author      DanRan233
     * @Param       [userState]
     * @return      int
     */
    int addLoginInfo(UserState userState);

    int addCode(UserAcCode userAcCode);

}
