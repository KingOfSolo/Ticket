package nju.edu.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by xiaoJun on 2018/3/7.
 */
public class BadAccountException extends AuthenticationException{

    public static final int ACCOUNT_FREEZE = 0;  // 账户未激活
    public static final int ACCOUNT_STOP = 2;    // 账户已停用
    public static final int BAD_Credentials = 3; // 用户名/密码 错误

    private int status;

    public BadAccountException(String msg, Throwable t) {
        super(msg, t);
    }

    public BadAccountException(String msg) {
        super(msg);
    }

    public BadAccountException(String msg, int status) {
        super(msg);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
