package com.xupt.hamster.pojo;

import com.xupt.hamster.core.model.TokenDetail;
import lombok.Data;

/**
 * @author maxu
 * @date 2019/3/16
 */
@Data
public class Student extends TokenDetail {

    private Integer id;
    // 姓名
    private String name;
    // 邮箱
    private String email;
    // 是否评教
    private Boolean state = false;
}
