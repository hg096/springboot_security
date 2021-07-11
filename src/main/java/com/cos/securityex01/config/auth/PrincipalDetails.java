package com.cos.securityex01.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cos.securityex01.model.User;

import lombok.Data;

// 시큐리티가 /loginProc 주소요청이 오면 로그인
// 로그인 완료가 되면 시큐리티 session을 생성(Security ContextHolder)
// 오브젝트 -> Authentication 타입 객체 안에 User 정보가 있어야함 
// User오브젝트 타입  -> UserDitails타입 객체

// Security Session -> Authentication -> UserDetails(PrincipalDetails) 
// Authentication 객체에 저장할 수 있는 유일한 타입
@Data
public class PrincipalDetails implements UserDetails{

	
	private static final long serialVersionUID = 3025802600098717900L;
	
	private User user; //콤포지션

	public PrincipalDetails(User user) {
		super();
		this.user = user;
	}
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
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
		// 1년동안 회원이 로그인을 안하면 휴먼으로 전환
		// 현재시간 - 로그인시간 -> 1년초과시 return false;
		return true;
	}
	
	// 해당 User의 권한을 리턴하는 곳
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
		collet.add(()->{ return user.getRole();});
		return collet;
	}


	
}
