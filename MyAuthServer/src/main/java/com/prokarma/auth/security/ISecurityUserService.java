package com.prokarma.auth.security;

public interface ISecurityUserService {

    String validatePasswordResetToken(long id, String token);

}
