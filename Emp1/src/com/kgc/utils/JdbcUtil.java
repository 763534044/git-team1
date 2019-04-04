package com.kgc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.util.Map;

public class JdbcUtil {
    private static DataSource ds=new ComboPooledDataSource();
    public static DataSource getDataSource(){
        return ds;
    }

    public static <T> T toBean(Class<T> c, Map map){
        try {
            T t = c.newInstance();
            BeanUtils.populate(t,map);
            return t;
        }  catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
