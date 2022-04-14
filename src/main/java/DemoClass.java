/*
Java Database Connectivity theory

1.-import ---> java.sql
2.-load and register the driver --->Mysql driver com.mysql.jdbc.Driver
3.-Create connection
4.-Create a statement
5.-Execute the query
6.-Process the results
7.-close
 */

import java.sql.*;


public class DemoClass
{
    public static void main(String[] args) throws Exception
    {

        String url = "jdbc:mysql://localhost:3306/jdbcexample";
        String uname = "root";
        String pass = "souless123";
        String query = "select userName from student where userid= 3";

        Class.forName("com.mysql.cj.jdbc.Driver"); //class forname register the driver
        Connection con = DriverManager.getConnection(url,uname,pass);//connection

        Statement st = con.createStatement();//create statement

        ResultSet rs = st.executeQuery(query); //execution of query

        rs.next();
        String name = rs.getNString("userName");
        System.out.println(name);

        st.close();
        con.close();
    }
}
