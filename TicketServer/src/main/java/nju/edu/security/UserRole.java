package nju.edu.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by LENOVO on 2018/3/7.
 */
public class UserRole implements GrantedAuthority{
    public static final String ROLE_MEMBER = "ROLE_MEMBER";
    public static final String ROLE_VENUE = "ROLE_VENUE";
    public static final String ROLE_MANAGER = "ROLE_MANAGER";
    public static final int MEMBER = 0;
    public static final int VENUE = 1;
    public static final int MANAGER = 2;

    private String name;

    public UserRole(String name) {
        this.name = name;
    }
    @Override
    public String getAuthority() {
        return name;
    }
}
