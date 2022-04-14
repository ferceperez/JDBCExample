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
        String query = "insert into student values (?,?)"; // the ? represents values to be replaced by variables

        int userid = 5;
        String username = "Lucas"; //values to be inserted



        Class.forName("com.mysql.cj.jdbc.Driver"); //class.forname register the driver
        Connection con = DriverManager.getConnection(url,uname,pass);//connection

        PreparedStatement st = con.prepareStatement(query); // we use PreparedStatement to use variables

        st.setInt(1,userid);// we let know that in the first column (the value 1) we are going to insert userid
        st.setString(2,username);// we let know that in the second column (the value 2) we are going to insert username

        int count = st.executeUpdate(); // this gives back the number of rows affected

        System.out.println(count + " row/s affected");


        st.close();
        con.close();
    }
}
