package com.ssm.config.predefined;

/**
 * @author FaceFeel
 * @Created 2018-01-28 12:32
 */

public class DataSourceContextHolder {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 设置数据库类型/数据源
     * @param dbType 数据源类型
     */
    public static void setDbType(String dbType){
        contextHolder.set(dbType);
    }

    /**
     * 获取数据源
     */
    public static String getDbType(){
        return contextHolder.get();
    }

    /**
     * 清除数据源
     */
    public static void clearDbType(){
        contextHolder.remove();
    }
}
