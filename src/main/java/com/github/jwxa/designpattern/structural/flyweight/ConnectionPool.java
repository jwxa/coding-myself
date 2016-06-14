package com.github.jwxa.designpattern.structural.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * 享元模式（Flyweight）<br>
 * FlyWeightFactory负责创建和管理享元单元，当一个客户端请求时，工厂需要检查当前对象池中是否有符合条件的对象，如果有，就返回已经存在的对象，如果没有，则创建一个新对象<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class ConnectionPool {

    private Vector<Connection> pool;


    /**公有属性**/
    private String url = "jdbc:mysql://localhost:3306/test";

    private String username = "root";

    private String pwd = "root";

    private String driverName = "com.mysql.jdbc.Driver";

    private int poolSize =100;

    private static ConnectionPool instance = null;

    Connection conn = null;

    private ConnectionPool(){
        pool = new Vector<Connection>(poolSize);
        for (int i = 0; i < poolSize; i++) {
            try {
                Class.forName(driverName);
                conn =  DriverManager.getConnection(url,username,pwd);
                pool.add(conn);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void release(){
        pool.add(conn);
    }

    public synchronized  Connection getConnection(){
        if(pool.size()>0){
            Connection connection = pool.get(0);
            pool.remove(connection);
            return connection;
        }else{
            return null;
        }
    }



}
