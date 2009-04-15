package net.fly78.dafei1288.util.sql;

import java.sql.Connection;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class MysqlConnection {
	private static MysqlConnection dc;
	private Connection conn = null;
	private Statement stmt = null;

	private MysqlConnection() {
	}

	public static MysqlConnection instance() {
		if (dc == null) {
			dc = new MysqlConnection();
		}
		return dc;
	}

	public Statement openStmt() {
		if (stmt == null) {
			conn = getConn();
			try {
				stmt = conn.createStatement();
			} catch (Exception e) {
				System.err.println("创建Statement异常:" + e.getMessage());
			}
		}
		return stmt;
	}

	public void closeStmt() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				System.err.println("Statement关闭异常");
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				System.err.println("数据库关闭异常");
			}
		}
	}

	private Connection getConn() {
		if (conn == null) {
			try {
				// 创建连接池实例
				ComboPooledDataSource ds = new ComboPooledDataSource();
				// 设置连接池连接数据库所需的驱动
				ds.setDriverClass("com.mysql.jdbc.Driver");
				// 连接数据库的用户名;
				ds.setUser("root");
				// 连接数据库的密码
				ds.setPassword("321478");
				// 设置连接池的最大连接数
				ds.setMaxPoolSize(40);
				// 连接池的最小连接数
				ds.setMinPoolSize(2);
				// 设置连接池的缓存Statement的最大数
				ds.setMaxStatements(180);
				// 获得连接
				conn = ds.getConnection();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}

/*
 SystemConfigResources.properties

#db config 
DRIVER_NAME=oracle.jdbc.driver.OracleDriver 
DATABASE_URL=jdbc:oracle:thin:@127.0.0.1:1521:Test 
DATABASE_USER=Test 
DATABASE_PASSWORD=Test


#c3p0 config 
Initial_PoolSize=10 
Min_PoolSize=10 
Max_PoolSize=50 
Acquire_Increment=5 
TIMEOUT=5000 
MAX_IdleTime=1800 
Idle_Test_Period=3000 
Validate=true


SystemConfig.java

package com.kevin.common; 
import java.util.*; 
public class SystemConfig { 
    static String configFile = "com.kevin.common.SystemConfigResources"; 
    public static String getConfigInfomation(String itemIndex) { 
        try { 
            ResourceBundle resource = ResourceBundle.getBundle(configFile); 
            return resource.getString(itemIndex); 
        } catch (Exception e) { 
            return ""; 
        } 
    } 
}

DBConnectionManager.java

package com.kevin.common.database; 
import java.sql.*; 
import com.kevin.common.*; 
import com.mchange.v2.c3p0.*; 
public class DBConnectionManager { 
    private static ComboPooledDataSource cpds = null; 
    public static void init() { 
       // 建立数据库连接池 
        String DRIVER_NAME = SystemConfig.getConfigInfomation("DRIVER_NAME"); // 驱动器 
        String DATABASE_URL = SystemConfig.getConfigInfomation("DATABASE_URL"); // 数据库连接url 
        String DATABASE_USER = SystemConfig.getConfigInfomation("DATABASE_USER"); // 数据库用户名 
        String DATABASE_PASSWORD = SystemConfig.getConfigInfomation("DATABASE_PASSWORD"); // 数据库密码 
       int Min_PoolSize = 5; 
       int Max_PoolSize = 50; 
       int Acquire_Increment = 5; 
       int Initial_PoolSize = 10; 
       // 每隔3000s测试连接是否可以正常使用 
       int Idle_Test_Period = 3000; 
       // 每次连接验证连接是否可用 
        String Validate = SystemConfig.getConfigInfomation("Validate"); 
   if (Validate.equals("")) { 
           Validate = "false"; 
       } 
       // 最小连接数 
        try { 
            Min_PoolSize = Integer.parseInt(SystemConfig.getConfigInfomation("Min_PoolSize")); 
       } catch (Exception ex) { 
           ex.printStackTrace(); 
       } 
       // 增量条数 
        try { 
            Acquire_Increment = Integer.parseInt(SystemConfig.getConfigInfomation("Acquire_Increment")); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
        // 最大连接数 
        try { 
            Max_PoolSize = Integer.parseInt(SystemConfig.getConfigInfomation("Max_PoolSize")); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
        // 初始化连接数 
        try { 
            Initial_PoolSize = Integer.parseInt(SystemConfig.getConfigInfomation("Initial_PoolSize")); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
        // 每隔3000s测试连接是否可以正常使用 
        try { 
            Idle_Test_Period = Integer.parseInt(SystemConfig.getConfigInfomation("Idle_Test_Period")); 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        }

        try { 
              cpds = new ComboPooledDataSource(); 
              cpds.setDriverClass(DRIVER_NAME); // 驱动器 
              cpds.setJdbcUrl(DATABASE_URL); // 数据库url 
              cpds.setUser(DATABASE_USER); // 用户名 
              cpds.setPassword(DATABASE_PASSWORD); // 密码 
              cpds.setInitialPoolSize(Initial_PoolSize); // 初始化连接池大小 
              cpds.setMinPoolSize(Min_PoolSize); // 最少连接数 
              cpds.setMaxPoolSize(Max_PoolSize); // 最大连接数 
              cpds.setAcquireIncrement(Acquire_Increment); // 连接数的增量 
              cpds.setIdleConnectionTestPeriod(Idle_Test_Period); // 测连接有效的时间间隔 
              cpds.setTestConnectionOnCheckout(Boolean.getBoolean(Validate)); // 每次连接验证连接是否可用 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
       } 
    }

    public static Connection getConnection() { 
            Connection connection = null; 
        try { 
            if (cpds == null) { 
                init(); 
            } 
            // getconnection 
            connection = cpds.getConnection(); 
        } catch (SQLException ex) { 
            ex.printStackTrace(); 
        } 
        return connection; 
    }

    public static void release() { 
        try { 
            if (cpds != null) { 
                cpds.close(); 
            } 
        } catch (Exception ex) { 
            ex.printStackTrace(); 
        } 
    } 
}

 
 */
