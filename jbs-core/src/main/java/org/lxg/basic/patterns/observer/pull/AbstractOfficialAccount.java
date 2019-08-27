package org.lxg.basic.patterns.observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xuegangliu
 *  2017/3/16 0016.
 */
public abstract class AbstractOfficialAccount {
    private List<User> userList = new ArrayList<>();

    /**
     * registerUser
     * @param user
     */
    public void registerUser(User user) { userList.add(user); }

    /**
     * unregisterUser
     * @param user
     */
    public void unregisterUser(User user) { userList.remove(user); }

    /**
     * notifyUse
     */
    public void notifyUse() {
        for (User user: userList) {
            user.update(this);
        }
    }
}
