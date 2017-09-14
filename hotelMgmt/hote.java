import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
class hote extends Frame implements ActionListener
{
 usercan1 us1;
 usercan2 us2;
 admin adm;
 can ca1;
 String showid,canstr,welcomeuser="",userbook="",userfrom="",userto="",usertype="";
 int count=1001,userroom,userbill,userid;
 show s;
 regbox reg;
 Statement stmt;
 PreparedStatement pstmt;
 Connection con;
 Label l1,l2;
 TextField t1,t2;
 Panel p,p1,p2,p3,p4;
 Button b1,b2,b3,login,newuser,checkout,userlogout,back,adminlogin;
 CardLayout c;
 adminlog admlog;
 BufferedImage img;
 File f;
 imgcan ican;
 hote()
 {
  try{
  f=new File("hotel.jpg");
  img=ImageIO.read(f);}catch(Exception e){}
  ican=new imgcan();
  admlog=new adminlog(this);
  adm=new admin(this);
  s=new show(this);
  reg=new regbox(this);
  c=new CardLayout();
  p=new Panel();
  p.setLayout(c);
  p1=new Panel();
  b1=new Button("Restuarant");
  b1.addActionListener(this);
  b2=new Button("Lodge");
  b2.addActionListener(this);
  p1.add(b1);
  p1.add(b2);
  p1.add(ican);
  p1.setLayout(new FlowLayout());
  p2=new Panel();
  l1=new Label("user ID");
  l2=new Label("password");
  t1=new TextField(20);
  t2=new TextField(20);
  t2.setEchoChar('*');
  login=new Button("login");
  login.addActionListener(this);
  newuser=new Button("new user");
  newuser.addActionListener(this);
  adminlogin=new Button("Admin Login");
  adminlogin.addActionListener(this);
  b3=new Button("back");
  b3.addActionListener(this);
  p2.add(l1);
  p2.add(t1);
  p2.add(l2);
  p2.add(t2);
  p2.add(login);
  p2.add(newuser);
  p2.add(adminlogin);
  p2.add(b3);
  p2.setLayout(new FlowLayout());
  p3=new Panel();
  us1=new usercan1();
  us2=new usercan2();
  checkout=new Button("check out");
  checkout.addActionListener(this);
  userlogout=new Button("logout");
  userlogout.addActionListener(this);
  p3.add(us1);
  p3.add(checkout);
  p3.add(userlogout);
  p3.add(us2);
  p3.setLayout(new FlowLayout());
  p4=new Panel();
  back=new Button("Back");
  back.addActionListener(this);
  p4.add(back);
  p4.setLayout(new FlowLayout());
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.add(p4);
  add(p);
  setLayout(new GridLayout(1,1));
  setSize(600,600);
  setVisible(true);
 }
 public static void main(String args[])
 {
  try{
  Class.forName("oracle.jdbc.driver.OracleDriver");}catch(Exception ex){}
  hote h=new hote();
 }
 class adminlog extends Dialog implements ActionListener
 {
  Label adminl1,adminl2;
  TextField admint1,admint2;
  Button adminb1,adminb2;
  adminlog(Frame f)
  {
   super(f,"Admin",true);
   adminl1=new Label("User ID");
   adminl2=new Label("Password");
   admint1=new TextField(20);
   admint2=new TextField(20);
   admint2.setEchoChar('*');
   adminb1=new Button("login");
   adminb2=new Button("back");
   adminb1.addActionListener(this);
   adminb2.addActionListener(this);
   add(adminl1);
   add(admint1);
   add(adminl2);
   add(admint2);
   add(adminb1);
   add(adminb2);
   setLayout(new FlowLayout());
   setSize(280,150);
  }
  public void actionPerformed(ActionEvent ae)
  {
   if((Button)ae.getSource()==adminb1)
   {
    if(admint1.getText().equals("1000"))
	{
	 if(admint2.getText().equals("naveen"))
	 {
	  admint1.setText("");
	  admint2.setText("");
	  setVisible(false);
	  adm.showadmin();
	 }
	 else
	 {
	  admint2.setText("");
	 }
	}
	else
	{
	 admint1.setText("");
	 admint2.setText("");
	}
   }
   if((Button)ae.getSource()==adminb2)
   {
    admint1.setText("");
	admint2.setText("");
	setVisible(false);
   }
  }
  public void showadminlog()
  {
   setVisible(true);
  }
 }
 public void actionPerformed(ActionEvent e)
 {
  Button b=(Button)e.getSource();
  if(b==b3)
  {
   c.first(p);
  }
  if(b==adminlogin)
  {
   admlog.showadminlog();
  }
  if(b==b1)
  {
   c.next(p);
   c.next(p);
   c.next(p);
  }
  if(b==back)
  {
   c.first(p);
  }
  if(b==userlogout)
  {
   t1.setText("");
   t2.setText("");
   c.first(p);
  }
  if(b==checkout)
  {
   try{
    stmt.executeQuery("delete from hotel where id='"+userid+"'");
   }catch(Exception exce){System.out.println("exception while deleting\n"+exce);}
   t1.setText("");
   t2.setText("");
   c.previous(p);
  }
  if(b==b2)
  c.next(p);
  if(b==login)
  {
   if(t1.getText().equals("1000"))
   {
    if(t2.getText().equals("naveen"))
	{
	 adm.showadmin();
	}
	else
	{
	 t2.setText("");
	}
   }
   else
   {
   try{
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
   stmt=con.createStatement();
   ResultSet rs=stmt.executeQuery("select id,password,name,type,roomno,bill,one,two,btime from hotel");
   while(rs.next())
   {
    //System.out.println(rs.getInt(1));
    if(Integer.parseInt(t1.getText())==rs.getInt(1))
    if(t2.getText().equals(rs.getString(2)))
	{
	  userid=Integer.parseInt(t1.getText());
	  welcomeuser="welcome "+rs.getString(3);
	  us1.repaint();
	  userroom=rs.getInt(5);
	  userbill=rs.getInt(6);
	  userfrom=rs.getString(7);
	  userto=rs.getString(8);
	  userbook=rs.getString(9);
	  switch(rs.getInt(4))
	  {
	   case 0:usertype="Non-Ac";
			   break;
	   case 1:usertype="Ac";
				break;
	   case 2:usertype="Suit";
				break;
	  }
	  us2.repaint();
      c.next(p);
	}
   }
   }catch(Exception ee){System.out.println("login exception "+ee);}
   }
  }
  if(b==newuser)
  {
   reg.open();
  }
 }
 public class admin extends Dialog implements ActionListener
 {
  int sid,stype,sroomno,sbill,cox=100,coy=100;
  String sname,sphno,semail,sone,stwo,sbtime,result="";
  Button ab,ab1,ab2,ab3;
  Label al;
  TextField at;
  admin(Frame f)
  {
   super(f,"admin",true);
   ab1=new Button("view Table");
   ab1.addActionListener(this);
   al=new Label("search by id : ");
   at=new TextField(20);
   ab2=new Button("search");
   ab2.addActionListener(this);
   ab3=new Button("logout");
   ab3.addActionListener(this);
   add(ab1);
   add(al);
   add(at);
   add(ab2);
   add(ab3);
   setLayout(new FlowLayout());
   setSize(1100,500);
  }
  public void actionPerformed(ActionEvent ae)
  {
   ab=(Button)ae.getSource();
   if(ab==ab1)
	viewtable();
   if(ab==ab2)
   {
    showcust();
	//Graphics g=getGraphics();
	//g.drawString(""+at.getText(),100,100);
   }
   if(ab==ab3)
   {
    setVisible(false);
   }
  }
  public void paint(Graphics g)
  {
   g.drawString(result,100,100);
  }
  public void showcust()
  {
   if(at.getText().equals(""))
   {
    result="";
	repaint();
   }
   else
   {
    sid=Integer.parseInt(at.getText());
   try{
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
   stmt=con.createStatement();
   ResultSet rs=stmt.executeQuery("select id,name,phno,email,type,roomno,bill,one,two,btime from hotel");
   while(rs.next())
   {
    //System.out.println(rs.getInt(1));
    if(sid==rs.getInt(1))
    {
	 sname=rs.getString(2);
	 sphno=rs.getString(3);
	 semail=rs.getString(4);
	 stype=rs.getInt(5);
	 sroomno=rs.getInt(6);
	 sbill=rs.getInt(7);
	 sone=rs.getString(8);
	 stwo=rs.getString(9);
	 sbtime=rs.getString(10);
	 result=""+sid+"       "+sname+"        "+sphno+"        "+semail+"          "+stype+"          "+sroomno+"         "+sbill+"          "+sone+"        "+stwo+"         "+sbtime;
	 repaint();
 	 break;
     }	
    }
    }catch(Exception ee){System.out.println("login exception "+ee);}
   }
  }
  public void viewtable()
  {
   at.setText("");
   //showcust();
   coy=130;
   try{
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
   stmt=con.createStatement();
   ResultSet rs=stmt.executeQuery("select id,name,phno,email,type,roomno,bill,one,two,btime from hotel");
   Graphics g=getGraphics();
   rs.next();
   while(rs.next())
   {
     sid=rs.getInt(1);
     sname=rs.getString(2);
	 sphno=rs.getString(3);
	 semail=rs.getString(4);
	 stype=rs.getInt(5);
	 sroomno=rs.getInt(6);
	 sbill=rs.getInt(7);
	 sone=rs.getString(8);
	 stwo=rs.getString(9);
	 sbtime=rs.getString(10);
	 result=""+sid+"       "+sname+"        "+sphno+"        "+semail+"          "+stype+"          "+sroomno+"         "+sbill+"          "+sone+"        "+stwo+"         "+sbtime;
     g.drawString(result,cox,coy);
	 coy+=25;
	}
   }catch(Exception ee){System.out.println("login exception "+ee);}
  }
  public void showadmin()
  {
   t1.setText("");
   t2.setText("");
   at.setText("");
   result="";
   repaint();
   setVisible(true);
  }
 }
 public class regbox extends Dialog implements ActionListener
 {
  Label name,phno,from,to,type,email,password,reenter,_1,_2,_3,_4;
  TextField na,ph,fr1,fr2,fr3,tot1,tot2,tot3,em,pass,ree;
  List lis;
  Button ok,cancel;
  int tempbill;
  regbox(Frame f)
  {
   super(f,"new registration",true);
   setLayout(new FlowLayout());
   //setLayout(new GridLayout(4,3));
   _1=new Label("-");
   _2=new Label("-");
   _3=new Label("-");
   _4=new Label("-");
   name=new Label("name");
   phno=new Label("phone no.");
   email=new Label("email");
   from=new Label("from(date)");
   to=new Label("to(date)");
   type=new Label("type");
   password=new Label("password");
   reenter=new Label("re-enter password");
   ok=new Button("ok");
   ok.addActionListener(this);
   cancel=new Button("cancel");
   cancel.addActionListener(this);
   na=new TextField(20);
   ph=new TextField(20);
   fr1=new TextField(2);
   fr2=new TextField(2);
   fr3=new TextField(4);
   tot1=new TextField(2);
   tot2=new TextField(2);
   tot3=new TextField(4);
   em=new TextField(20);
   pass=new TextField(20);
   pass.setEchoChar('*');
   ree=new TextField(20);
   ree.setEchoChar('*');
   lis=new List();
   lis.add("Non-Ac");
   lis.add("Ac");
   lis.add("Suit");
   add(name);
   add(na);
   add(phno);
   add(ph);
   add(email);
   add(em);
   add(from);
   add(fr1);
   add(_1);
   add(fr2);
   add(_2);
   add(fr3);
   add(to);
   add(tot1);
   add(_3);
   add(tot2);
   add(_4);
   add(tot3);
   add(type);
   add(lis);
   add(password);
   add(pass);
   add(reenter);
   add(ree);
   add(ok);
   add(cancel);
   setSize(300,350);
  }
  public void open()
  {
   na.setText("");
   ph.setText("");
   fr1.setText("");
   fr2.setText("");
   fr3.setText("");
   tot1.setText("");
   tot2.setText("");
   tot3.setText("");
   em.setText("");
   pass.setText("");
   ree.setText("");
   setVisible(true);
  }
  public void actionPerformed(ActionEvent ae)
  {
   //System.out.println(lis.getSelectedIndex());
   Button tempb=(Button)ae.getSource();
   if(tempb==ok)
   {
   if(pass.getText().equals(ree.getText()))
   {
   int room[]=new int[31],rom=0,flag=0;
   for(int i=0;i<31;i++)
   room[i]=0;
   try{
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
   stmt=con.createStatement();
   //pstmt=con.prepareStatement("insert into hotel values(?,?,null,null,null,null,null,null,null,null)");
   ResultSet rs=stmt.executeQuery("select id,roomno from hotel");
   while(rs.next()){
	 count=rs.getInt(1);
	 room[rs.getInt("roomno")]=1;
	}
	count++;}catch(Exception eeee){}
	//System.out.println(""+count);
	for(int i=1;1<31;i++)
	{
	 if(room[i]==0)
	 {
	  rom=i;
	  flag=1;
	  break;
	 }
	}
	//System.out.println(""+room[25]);
   showid=Integer.toString(count);
   canstr="your id is : "+showid+" room no. is :"+rom;
   ca1.repaint();
   //System.out.println(showid);
   String sname,spass,smail;
   sname=na.getText();
   spass=pass.getText();
   smail=em.getText();
   
   int itype=lis.getSelectedIndex();
   if(itype==0)
		tempbill=500;
   if(itype==1)
		tempbill=850;
   if(itype==2)
		tempbill=1350;
   String frdate=fr1.getText()+"-"+fr2.getText()+"-"+fr3.getText();
   String todate=tot1.getText()+"-"+tot2.getText()+"-"+tot3.getText();
   //System.out.println(""+frdate+"\n"+todate);
   int nodays=diffdate(Integer.parseInt(fr1.getText()),Integer.parseInt(fr2.getText()),Integer.parseInt(fr3.getText()),Integer.parseInt(tot1.getText()),Integer.parseInt(tot2.getText()),Integer.parseInt(tot3.getText()));
   tempbill*=nodays;
   DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
   Date dateobj = new Date();
   String curdate=df.format(dateobj).toString();
   //System.out.println(curdate);
   if(flag==1){
   try{
   //'"+tot1.getText()+"-"+tot2.getText()+"-"+tot3.getText()+"'
   //,'"+fr1.getText()+"-"fr2.getText()+"-"+fr3.getText()+"'
   stmt.executeUpdate("insert into hotel values('"+count+"','"+sname+"','"+spass+"','"+ph.getText()+"','"+smail+"','"+lis.getSelectedIndex()+"','"+rom+"','"+tempbill+"','"+frdate+"','"+todate+"','"+curdate+"')");
   
   }catch(Exception ex){System.out.println("exception"+ex);}
   setVisible(false);
   s.openshow();
   }
  }
  else
  {
   pass.setText("");
   ree.setText("");
   canstr="password donnot match";
   ca1.repaint();
   s.openshow();
  }
  }
   if(tempb==cancel)
   {
    setVisible(false);
   }
  }
 }
 public class show extends Dialog implements ActionListener
  {
   show(Frame f)
   {
    super(f,"id",true);
	Button ok1=new Button("ok");
	ok1.addActionListener(this);
	ca1=new can();
	add(ca1);
	
	add(ok1);
	setLayout(new FlowLayout());
	setSize(400,100);
   }
   public void openshow()
   {
    setVisible(true);
   }
   public void actionPerformed(ActionEvent ea)
   {
    //System.out.println(showid);
    setVisible(false);
   }
  }
  class can extends Canvas
  {
   can(){setSize(200,50);}
   public void paint(Graphics g)
   {
    g.drawString(canstr,20,20);
   }
  }
 public int diffdate(int d1,int m1,int y1,int d2,int m2,int y2)
 {
  int days=0,monday[];
  monday=new int[12];
  monday[0]=monday[2]=monday[4]=monday[6]=monday[7]=monday[9]=monday[11]=31;
  monday[3]=monday[5]=monday[8]=monday[10]=30;
  if(y1%4==0) monday[1]=29;
  else monday[1]=28;
  if(y1==y2)
  {
   if(m1==m2)
	days=d2-d1;
   else
   {
    //System.out.println("rwo");
    int tmon=m2-m1;
	days=(monday[m1-1]-d1)+(d2);
	if(tmon>1)
	for(int x=1;x<tmon;x++)
	days=days+monday[m1-1+x];
   }
  }
  else if(y1!=y2)
  {
   //System.out.println("one");
   days=monday[m1-1]-d1;
   for(int tm1=m1;tm1<12;tm1++)
   days+=monday[tm1];
   for(int x=0;x<m2-1;x++)
   days+=monday[x];
   days=days+d2;
  }
  //System.out.println(days);
  return days;
 }
 class usercan1 extends Canvas
 {
  usercan1(){setSize(200,40);}
  public void paint(Graphics g)
  {
   g.drawString(welcomeuser,20,15);
  }
 }
 class usercan2 extends Canvas
 {
  usercan2(){setSize(550,550);}
  public void paint(Graphics g)
  {
   g.drawString("room no  : "+userroom,50,100);
   g.drawString("room type: "+usertype,50,130);
   g.drawString("booked on: "+userbook,50,160);
   g.drawString("From     : "+userfrom,50,190);
   g.drawString("to       : "+userto,50,210);
   g.drawString("bill     : "+userbill,50,240);
  }
 }
 class imgcan extends Canvas
 {
  imgcan(){setSize(600,600);}
  public void paint(Graphics g)
  {
   g.drawImage(img,0,0,this);
  }
 }
}