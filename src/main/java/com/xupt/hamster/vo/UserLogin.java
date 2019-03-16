package com.xupt.hamster.vo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Data
public class UserLogin {
    @NotBlank(message = "username cannot be empty")
    private String username;

    @NotBlank(message = "password cannot be empty")
    private String password;
}
