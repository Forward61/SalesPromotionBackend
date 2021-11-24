package com.freedom.sales.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @Author: freedom
 * @Date: 2021-11-22 09:38
 **/
@Component
@Data
public class ResponseVos {
    private String reqId;
    private String resId;
    private String respCode;
    private String respMsg;
    private String respTime;
    private String version;
    private String openId;
}
