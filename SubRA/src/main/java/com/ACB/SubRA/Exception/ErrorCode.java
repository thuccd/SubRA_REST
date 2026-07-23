package com.ACB.SubRA.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum ErrorCode {
    USER_EXIT(1001, "User existed"),
    UNCATEGORIZED_EXCEPTION(9999,"uncategorized exceoption"),
    PASSWORD_INVALID(8888,"password invalid"),
    INVALID_KEY(7777, "invalid key code"),
    UNAUTHENTICATED(6666,"unauthenticated")
    ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;
    private String message;

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
