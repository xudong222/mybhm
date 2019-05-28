package com.example.demo.base.entity;
//绑卡申请短信验证
public class AuthConfirmResp {
private String applicationId;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    @Override
    public String toString() {
        return "AuthConfirmResp{" +
                "applicationId='" + applicationId + '\'' +
                '}';
    }
}
