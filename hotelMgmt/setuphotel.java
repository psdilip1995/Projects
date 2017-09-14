import java.io.*;
import java .sql.*;
public class setuphotel 
{
public static void main(String a[])
{
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con;
con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
System.out.println("connected to DB Suc");
Statement stmt=con.createStatement();
/*
ResultSet rs=stmt.executeQuery("select * from emp");
while(rs.next()){
	System.out.println(rs.getInt(1));

	System.out.println(rs.getString(2));
	}
*/
stmt.execute("create table hotel(id number primary key,name varchar2(20),password varchar2(20),phno varchar2(11),email varchar2(20),type number,roomno number,bill number,one date,two date,btime date)");
stmt.executeUpdate("insert into hotel values(1000,'admin','naveen',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL)");
//stmt.executeUpdate("insert into staff values(101,'def','345',10,10,0,null)");
//stmt.executeUpdate("insert into staff values(102,'ghi','678',10,10,0,null)");
//stmt.executeUpdate("insert into staff values(103,'jkl','910',10,10,0,null)");
System.out.println(" 1 row inserted");

con.close();
}
catch(Exception e){System.out.println("exception occurred"+e);}
}
}