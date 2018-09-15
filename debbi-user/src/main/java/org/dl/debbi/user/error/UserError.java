package org.dl.debbi.user.error;

import org.dl.debbi.common.error.Error;
import org.dl.debbi.common.error.CommonError;

public enum UserError implements Error {

    INVALID_PRINCIPAL(144101),         // 非法用户名
    INVALID_USER(144102),              // 非法用户
    INVALID_CERTIFICATE(144103),       // 错误的密码
    REGISTER_FAIL(144601),             // 注册失败
    CONFLICT_PRINCIPAL(140901),        // 用户名重复
    INVALID_CAPTCHA(144105),           // 错误的验证码
    INVALID_UPDATE_KEY_WORD(1201),     // 错误的修改字段
    ;

    private int code;

    UserError(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return name().toLowerCase();
    }
}