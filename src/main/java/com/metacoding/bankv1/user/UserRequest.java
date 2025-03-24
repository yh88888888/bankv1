package com.metacoding.bankv1.user;

import lombok.Data;

public class UserRequest {

    @Data //Getter, Setter, ToString
    public static class JoinDTO{
        private String username;
        private String password;
        private String fullname;
    }

    @Data //Getter, Setter, ToString
    public static class LoginDTO{
        private String username;
        private String password;
    }
}
