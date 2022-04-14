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
        String query = "select * from student";

        Class.forName("com.mysql.cj.jdbc.Driver"); //class forname register the driver
        Connection con = DriverManager.getConnection(url,uname,pass);//connection

        Statement st = con.createStatement();//create statement

        ResultSet rs = st.executeQuery(query); //execution of query

        String userdData = ""; //here we save the info from the row

        while (rs.next()) //moves the cursor to show the next row until there is no row left
        {
            userdData = rs.getInt(1) + " : " + rs.getString(2); //getint gets the first column and the values are int in the db, the first column is 1
            System.out.println(userdData);                                            //getString gets the second column and the values are strings in the db, the second column is 2
        }


        st.close();
        con.close();
    }
}
