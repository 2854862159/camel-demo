package com.example.cameldemo.route;

import java.util.Collection;

/**
 * ClassName: UserService <br/>
 * Description: <br/>
 * date: 2021/11/22 10:49 上午<br/>
 *
 * @author tooru<br />
 */
public interface UserService {

    /**
     * Find a user by the given ID
     *
     * @param id
     *            the ID of the user
     * @return the user, or <code>null</code> if user not found.
     */
    User findUser(Integer id);

    /**
     * Find all users
     *
     * @return a collection of all users
     */
    Collection<User> findUsers();

    /**
     * Update the given user
     *
     * @param user
     *            the user
     */
    void updateUser(User user);

}
