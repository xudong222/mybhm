package com.example.demo.base.constants;

import java.util.ArrayList;
import java.util.List;

/**
 * 操作码
 *
 * @author MrBai
 * @create 2019-05-28 下午13:57:00
 */
public enum CodeEnum {

    /**
     * 通用成功操作
     */
    SUCCESS(10000, "成功"),

    /**
     * 通用失败操作
     */
    ERROR(20000, "系统异常"),

    REQUIRED_VERIFICATION_EROOR(31001,"必填校验失败");




    private final int code;
    private final String message;

    private CodeEnum(int _code, String _message) {
        this.code = _code;
        this.message = _message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 通过枚举code获取对应的message
     *
     * @return 取不到时返回null
     * @author MrBai
     */
    public static String getMessageByCode(int code) {
        for (CodeEnum _enum : values()) {
            if (_enum.getCode() == code) {
                return _enum.getMessage();
            }
        }
        return null;
    }

    /**
     * 通过枚举code获取枚举对象
     *
     * @return 取不到时返回null
     * @author MrBai
     */
    public static CodeEnum getByCode(int code) {
        for (CodeEnum _enum : values()) {
            if (_enum.getCode() == code) {
                return _enum;
            }
        }
        return null;
    }

    /**
     * 获取全部枚举
     *
     * @return 取不到时返回空List, 即new ArrayList<CodeEnum>()
     * @author MrBai
     */
    public List<CodeEnum> getAllEnum() {
        List<CodeEnum> list = new ArrayList<CodeEnum>();
        for (CodeEnum _enum : values()) {
            list.add(_enum);
        }
        return list;
    }

    /**
     * 获取全部枚举code
     *
     * @return 取不到时返回空List, 即new ArrayList<Integer>()
     * @author MrBai
     */
    public List<Integer> getAllEnumCode() {
        List<Integer> list = new ArrayList<Integer>();
        for (CodeEnum _enum : values()) {
            list.add(_enum.getCode());
        }
        return list;
    }
}



