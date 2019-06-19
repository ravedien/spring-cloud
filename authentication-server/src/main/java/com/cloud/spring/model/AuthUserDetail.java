package com.cloud.spring.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetail extends User implements UserDetails {

	private static final long serialVersionUID = 2702769756265401228L;

	public AuthUserDetail(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

		getRoles().forEach(role -> {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission -> {
				grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()));
			});

		});
		return grantedAuthorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return super.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled();
	}

}
