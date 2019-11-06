package ru.vallball.school01.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
	ROLE_STUDENT, ROLE_ADMIN, ROLE_TEACHER, ROLE_DIRECTOR;

	@Override
	public String getAuthority() {
		return name();
	}
}
