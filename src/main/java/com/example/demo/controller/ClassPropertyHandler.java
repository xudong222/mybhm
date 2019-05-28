package com.example.demo.controller;

import com.example.demo.base.constants.CodeEnum;
import com.example.demo.base.entity.AuthConfirmReq;
import com.example.demo.base.entity.ReturnEntity;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/** 传入需要校验的实体类对象,检验必填参数是否为空或者null
 * @author xinjian
 * @created 2019/2/27 13:06
 * @description
 */
public class ClassPropertyHandler<T> {

    private Field[] fields = new Field[]{};

    private T t;

    private Class clazz;

    public ClassPropertyHandler(T t){
        this.t = t;
        this.fields = t.getClass().getDeclaredFields();
        this.clazz = t.getClass();
    }
    /**获取所有get方法 方法名
     * @return
     */
    private List<String> getGetMethodName(){
        List<String> list = new ArrayList<>();
        for(Field field : fields){
            //可自定义注解,标识必填字段
            Annotation annotation = field.getAnnotation(NotNull.class);
            if(26 == field.getModifiers() || annotation == null){
                continue;
            }
            char[] cs = field.getName().toCharArray();
            //首字母大写
            cs[0] -= 32;
            list.add("get" + String.valueOf(cs));
        }
        return list;
    }
    /**判断实体类属性值那些必填字段为空
     * @return 返回空表示 必须有值的属性都满足需求 其他看返回值
     */
    public boolean noHasNullOrEmptyPropertyValue(){
        String result = "";
        List<String> list = getGetMethodName();
        for(String methodName : list){
            try {
                Method method = clazz.getMethod(methodName);
                Object res = method.invoke(t,null);
                if(res == null || "".equals(res)){
                    //把 "get"截掉
                    String property = methodName.substring(3);
                    char[] chars = property.toCharArray();
                    //首字母变小写
                    chars[0] += 32;
                    result = result + ", " + String.valueOf(chars);
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
//        if("".equals(result)){
//            return result;
//        }
//        System.out.println(clazz.getSimpleName() + "的属性: " + result.substring(2,result.length()-1) + " : 值为空或者null");

        return StringUtils.isEmpty(result);
    }

    public static void main(String[] args) {
        AuthConfirmReq account = new AuthConfirmReq();
//        account.setName("111111");

    }
}