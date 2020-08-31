package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbcDemo01 {
    public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            //1.注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //2.定义sql
            String sql = "insert into account values (null, '张三', 2000)";
            //3.连接数据库
            conn= DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            //4.获取执行sql语句的对象statement
            stmt = conn.createStatement();
            //5.执行sql
            int count = stmt.executeUpdate(sql);
            //6.处理结果
            System.out.println(count);
            if(count > 0){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }
            //7.释放资源
            //由于无论程序有没有报异常，资源都必须清理干净，所以释放资源的程序必须在finally代码块里
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //如果这里直接写stmt.close是会报错是因为stmt的声明在try代码块里为局部声明，所以应该在全局里声明stmt和conn
            if(stmt != null){
                try {//如果程序执行过程中报错则stmt和conn可能会赋值为null，这样会报空指针异常，所以应该用if语句判断是否为空
                    //不为空就释放，为空就不用管了
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
