package cn.edu.jxnu.HappyStudyingBackstage.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

public class JDBCUtil {

    public static DataSource source = new ComboPooledDataSource();

    public static DataSource getDataSource() {
        return source;
    }

}

