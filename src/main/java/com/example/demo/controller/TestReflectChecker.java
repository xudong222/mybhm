package com.example.demo.controller;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class TestReflectChecker {

    public class Param {
        private String id;

        private String name;

        private String year;

        private String month;

        private String day;

        public Param() {}

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }
    }

    /**
     * CHECK_FIELD
     */
    private enum CHECK_FIELD {
        id,

        name,

        year,

        month,

        day
    }

    private static Map<String, CHECK_FIELD[]> matchMap = new HashMap<String, CHECK_FIELD[]>();

    static {
        //id 1 : name is not null;
        matchMap.put("1",
                new CHECK_FIELD[] { CHECK_FIELD.id, CHECK_FIELD.name });

        //id 2 : year, month, day is not null;
        matchMap.put("2", new CHECK_FIELD[] { CHECK_FIELD.id, CHECK_FIELD.year,
                CHECK_FIELD.month, CHECK_FIELD.day });
    }

    private TestReflectChecker() {

    }

    /**
     * パラメータをチェック
     *
     * @param param
     * @return
     */
    public static boolean check(Param param) {
        if (param == null) {
            return false;
        }

        String id = param.getId();

        CHECK_FIELD[] checkFields = matchMap.get(id);

        if (checkFields == null) {
            return false;
        }

        for (CHECK_FIELD field : checkFields) {
            Method getFieldMethod = getGetMehtodByField(Param.class, field
                    .toString());
            try {
                Object value = getFieldMethod.invoke(param, new Object[] {});
                if (value == null) {
                    System.out.println(field + " is null, false will be return .");
                    return false;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        return true;
    }

    /**
     * fieldからmethodを取得
     *
     * @param clazz
     * @param field
     * @return
     */
    private static Method getGetMehtodByField(Class clazz, String field) {
        Method method = null;

        String methodName = "get" + field.substring(0, 1).toUpperCase()
                + field.substring(1);
        try {
            method = clazz.getMethod(methodName, new Class[] {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return method;
    }

    public static void main(String[] args) {
        Param param = new TestReflectChecker().new Param();
        param.setId("1");
        param.setName("name");
        System.out.println(TestReflectChecker.check(param));

        param.setId("2");
        param.setYear("2011");
        System.out.println(TestReflectChecker.check(param));
    }

}
