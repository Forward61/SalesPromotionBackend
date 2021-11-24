package com.freedom.sales.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: freedom
 * @Date: 2021-11-22 10:22
 **/
@Component
@Data
public class WechatConfigPojo {
    @Value("${Wechat.MiniProgram.AppId}")
    String AppId;

    @Value("${Wechat.MiniProgram.secret}")
    String secret;
}
