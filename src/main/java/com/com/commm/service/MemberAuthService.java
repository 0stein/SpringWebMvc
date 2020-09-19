package com.com.commm.service;

public interface MemberAuthService {
	boolean IsExist(String id);
	boolean IsMatchIDPW(String id, String password);
}
