package com.github.jwxa.designpattern.structural.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

/**
 * ��Ԫģʽ��Flyweight��<br>
 * FlyWeightFactory���𴴽��͹�����Ԫ��Ԫ����һ���ͻ�������ʱ��������Ҫ��鵱ǰ��������Ƿ��з��������Ķ�������У��ͷ����Ѿ����ڵĶ������û�У��򴴽�һ���¶���<br>
 * User: Jwxa<br>
 * Date: 2016/6/13.
 */
public class ConnectionPool {

    private Vector<Connection> pool;


    /**��������**/
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
