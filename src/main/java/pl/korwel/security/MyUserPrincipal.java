package pl.korwel.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.korwel.model.Privilege;
import pl.korwel.model.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserPrincipal implements UserDetails {
    private UserInfo userInfo;

    public MyUserPrincipal(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Privilege> privileges = userInfo.getPrivileges();
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Privilege p: privileges) {
            authorities.add(new SimpleGrantedAuthority(p.getName()));
        }
        return authorities;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    @JsonIgnore
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
