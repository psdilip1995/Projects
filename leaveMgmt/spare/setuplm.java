import java.io.*;
import java .sql.*;
public class setuplm 
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
stmt.execute("create table staff(id number primary key,password varchar2(20),name varchar2(20),phno varchar2(20),email varchar2(40),dept varchar2(5),desig varchar2(15),seen number,accept number,cl number,sl number,el number,one date,two date,nol number)");
//stmt.executeUpdate("insert into staff values(101,'101','one','1111111111','one@gmail.com','cse','professor',2,2,10,10,10,null,null,null)");
//stmt.executeUpdate("insert into staff values(102,'102','two','2222222222','two@gmail.com','cse','asst. professor',2,2,10,10,10,null,null,null)");
//stmt.executeUpdate("insert into staff values(103,'103','three','3333333333','three@gmail.com','ece','professor',2,2,10,10,10,null,null,null)");
//stmt.executeUpdate("insert into staff values(104,'104','four','4444444444','four@gmail.com','ece','asst. professor',2,2,10,10,10,null,null,null)");
System.out.println(" 1 row inserted");

con.close();
}
catch(Exception e){System.out.println("exception occurred"+e);}
}
}