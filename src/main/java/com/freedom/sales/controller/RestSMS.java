package com.freedom.sales.controller;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: freedom
 * @Date: 2022-02-18 21:13
 **/
@XmlRootElement(name ="Message")
public class RestSMS {
    private String Message_Body;

    private String request;
    private String content;
    private String status;
    private String deliverCode;
    public String getSmsType() {
        return Message_Body;
    }
    public void setSmsType(String Message_Body) {
        this.Message_Body = Message_Body;
    }
    public String getrequest() {
        return request;
    }
    public void setrequest(String request) {
        this.request = request;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getDeliverCode() {
        return deliverCode;
    }
    public void setDeliverCode(String deliverCode) {
        this.deliverCode = deliverCode;
    }

    @Override
    public String toString() {
        return "[Message_Body="+Message_Body+",request="+request+",content="+content+",status="+status+",deliverCode="+deliverCode+"]";
    }

}