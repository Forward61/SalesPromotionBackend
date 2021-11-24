package com.freedom.sales.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: freedom
 * @Date: 2021-11-20 21:42
 **/
@Component
@Data
public class UserPojo {

    private String id;
    private String user_id;
    private String user_name;
    private String openid;
    private String session_key;
    private String unionid;
    //user_id	varchar(50)	No
    //user_name	varchar(300)	Yes
    //openid	varchar(100)	Yes
    //session_key	varchar(500)	Yes
    //unionid
}
