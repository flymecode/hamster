package com.xupt.hamster.core.model;

import lombok.Data;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Data
public abstract class TokenDetail {

    public String username;
    public String password;
}