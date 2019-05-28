package com.example.demo.base.entity;

import com.example.demo.base.constants.CodeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @see 统一返回值包装类
 * @author MrBai
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // 不输出NULL字段
public class ReturnEntity<T> implements Serializable {

    private static final long serialVersionUID = 8604305629479659253L;

    /**
     * 响应码
     */
    private int errorCode;

    /**
     * 响应码描述
     */
    private String errorMsg;

    /**
     * 请求参数的签名串
     */
    public String sign;
    /**
     * 业务参数（bizContent）加密秘钥，这里是密文。为空时表示不加密。业务参数加解密参见附录“2.4
     * 内容加密与解密
     */
    private String encryptKey;
    /**
     * 业务参数加密算法，默认AES
     */
    private String encryptType ;
    /**
     * 响应数据体
     */
    private T data;


    public ReturnEntity(int errorCode, String errorMsg, String sign, String encryptKey, String encryptType, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.sign = sign;
        this.encryptKey = encryptKey;
        this.encryptType = encryptType;
        this.data = data;
    }

    public ReturnEntity(int errorCode, String errorMsg, String sign, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.sign = sign;
        this.data = data;
    }

    /**
     * 通用返回   加密业务参数
     * @param data
     * @return
     */
    public static <T> ReturnEntity<T> returnEntity(CodeEnum codeEnum, String sign, String encryptKey, String encryptType, T data){
        return new ReturnEntity<T>(codeEnum.getCode(), codeEnum.getMessage(), sign, encryptKey,encryptType,data);
    }


    /**
     * 通用返回   不加密业务参数
     * @param data
     * @return
     */
    public static <T> ReturnEntity<T> returnEntity(CodeEnum codeEnum,String sign,T data){
        return new ReturnEntity<T>(codeEnum.getCode(), codeEnum.getMessage(), sign,data);
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public String getEncryptType() {
        return encryptType;
    }

    public void setEncryptType(String encryptType) {
        this.encryptType = encryptType;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

