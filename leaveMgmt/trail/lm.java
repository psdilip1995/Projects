import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.io.*;
import java.util.*;
class lm extends Frame implements ActionListener,ItemListener
{
 Statement stmt;
 Connection con;
 int tempid,cl,sl,el;
 String p2can1str="welcome ",fromdate="22-10-2014",todate="25-10-2014",state="Accepted";
 Button b,b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11;
 TextField t1,t2,t3,t4,t5,t6;
 Label l1,l2,l3,l4,l5,l6,l7,l8;
 Choice p32choice;
 Panel p,p1,p11,p2,p21,p22,p3,p31,p32;
 homecan hc;
 p2can1 p2c1,p3c1;
 p2can2 p2c2;
 BufferedImage cbit;
 CardLayout c;
 GridBagLayout homegbl,p32gbl;
 GridBagConstraints homegc,p32gc;
 login lo;
 admin ad;
 status st;
 apply ap;
 change ch;
 lm()
 {
  setConnection();
  ch=new change(this);
  ap=new apply(this);
  st=new status(this);
  lo=new login(this);
  ad=new admin(this);
  c=new CardLayout();
  p=new Panel();
  p1=new Panel();
  hc=new homecan();
  try{
  File f=new File("cbit.jpg");
  cbit=ImageIO.read(f);}catch(Exception e){};
  hc.repaint();
  p11=new Panel();
  homegbl=new GridBagLayout();
  homegc=new GridBagConstraints();
  p11.setLayout(homegbl);
  //p11.setBackground(Color.lightGray);
  l1=new Label("Faculty Login :");
  l2=new Label("User ID ");
  l3=new Label("Password");
  t1=new TextField(20);
  t2=new TextField(20);
  t2.setEchoChar('*');
  b1=new Button("Login");
  b2=new Button("Admin Login");
  b3=new Button("HOD Login");
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  homegc.gridx=0;
  homegc.gridy=0;
  homegbl.setConstraints(l1,homegc);
  homegc.gridx=0;
  homegc.gridy=1;
  homegc.anchor=GridBagConstraints.WEST;
  homegbl.setConstraints(l2,homegc);
  homegc.gridx=1;
  homegc.gridy=1;
  homegbl.setConstraints(t1,homegc);
  homegc.gridx=0;
  homegc.gridy=2;
  homegbl.setConstraints(l3,homegc);
  homegc.gridx=1;
  homegc.gridy=2;
  homegbl.setConstraints(t2,homegc);
  homegc.gridx=1;
  homegc.gridy=3;
  homegc.anchor=GridBagConstraints.EAST;
  homegbl.setConstraints(b1,homegc);
  homegc.gridx=0;
  homegc.gridy=4;
  homegc.anchor=GridBagConstraints.WEST;
  homegbl.setConstraints(b2,homegc);
  homegc.gridx=1;
  homegc.gridy=4;
  homegbl.setConstraints(b3,homegc);
  p11.add(l1);
  p11.add(l2);
  p11.add(t1);
  p11.add(l3);
  p11.add(t2);
  p11.add(b1);
  p11.add(b2);
  p11.add(b3);
  p1.add(hc);
  p1.add(p11);
  p1.setLayout(new FlowLayout());
  p.add(p1);
  p2=new Panel();
  p21=new Panel();
  p2c1=new p2can1();
  b4=new Button("change details");
  b5=new Button("logout");
  b4.addActionListener(this);
  b5.addActionListener(this);
  p21.add(p2c1);
  p21.add(b4);
  p21.add(b5);
  p21.setLayout(new FlowLayout());
  p2c2=new p2can2();
  p22=new Panel();
  b6=new Button("View Status");
  b7=new Button("Apply Leave");
  b6.addActionListener(this);
  b7.addActionListener(this);
  p22.add(b6);
  p22.add(b7);
  p22.setLayout(new FlowLayout());
  p2.setLayout(new BorderLayout());
  p2.add(p21,"North");
  p2.add(p2c2,"Center");
  p2.add(p22,"South");
  p.add(p2);
  p3=new Panel();
  p3.setLayout(new BorderLayout());
  p31=new Panel();
  p3c1=new p2can1();
  b8=new Button("Change Details");
  b9=new Button("Logout");
  b8.addActionListener(this);
  b9.addActionListener(this);
  p31.add(p3c1);
  p31.add(b8);
  p31.add(b9);
  p31.setLayout(new FlowLayout());
  p3.add(p31,"North");
  p32=new Panel();
  l4=new Label("Pending Requests : ");
  l5=new Label("No.of Leaves : ");
  l6=new Label("From : ");
  l7=new Label("To : ");
  l8=new Label("Type : ");
  t3=new TextField(20);
  t4=new TextField(20);
  t5=new TextField(20);
  t6=new TextField(20);
  t3.setEditable(false);
  t4.setEditable(false);
  t5.setEditable(false);
  t6.setEditable(false);
  p32choice=new Choice();
  p32choice.addItemListener(this);
  //p32choice.add("one");
  //p32choice.add("two");
  //p32choice.add("three");
  //p32choice.add("four");
  b10=new Button("Accept");
  b11=new Button("Reject");
  b10.addActionListener(this);
  b11.addActionListener(this);
  p32gbl=new GridBagLayout();
  p32gc=new GridBagConstraints();
  p32.setLayout(p32gbl);
  p32gc.gridx=0;
  p32gc.gridy=0;
  p32gc.anchor=GridBagConstraints.EAST;
  p32gbl.setConstraints(l4,p32gc);
  p32gc.gridx=1;
  p32gc.gridy=0;
  p32gc.anchor=GridBagConstraints.WEST;
  p32gbl.setConstraints(p32choice,p32gc);
  p32gc.gridx=0;
  p32gc.gridy=1;
  p32gc.anchor=GridBagConstraints.EAST;
  p32gbl.setConstraints(l5,p32gc);
  p32gc.gridx=1;
  p32gc.gridy=1;
  //p32gc.gridwidth=2;
  //p32gc.fill=GridBagConstraints.HORIZONTAL;
  p32gbl.setConstraints(t3,p32gc);
  p32gc.gridx=0;
  p32gc.gridy=2;
  p32gbl.setConstraints(l8,p32gc);
  p32gc.gridx=1;
  p32gc.gridy=2;
  p32gbl.setConstraints(t6,p32gc);
  p32gc.gridx=0;
  p32gc.gridy=3;
  //p32gc.anchor=GridBagConstraints.WEST;
  p32gbl.setConstraints(l6,p32gc);
  p32gc.gridx=1;
  p32gc.gridy=3;
  //p32gc.gridwidth=2;
  p32gbl.setConstraints(t4,p32gc);
  p32gc.gridx=0;
  p32gc.gridy=4;
  //p32gc.gridwidth=1;
  p32gbl.setConstraints(l7,p32gc);
  p32gc.gridx=1;
  p32gc.gridy=4;
  //p32gc.gridwidth=2;
  p32gbl.setConstraints(t5,p32gc);
  p32gc.gridx=1;
  p32gc.gridy=5;
  //p32gc.gridwidth=1;
  p32gc.anchor=GridBagConstraints.WEST;
  p32gbl.setConstraints(b10,p32gc);
  p32gc.gridx=2;
  p32gc.gridy=5;
  p32gbl.setConstraints(b11,p32gc);
  p32.add(l4);
  p32.add(p32choice);
  p32.add(l5);
  p32.add(t3);
  p32.add(l8);
  p32.add(t6);
  p32.add(l6);
  p32.add(t4);
  p32.add(l7);
  p32.add(t5);
  p32.add(b10);
  p32.add(b11);
  p3.add(p32);
  p.add(p3);
  add(p);
  p.setLayout(c);
  setLayout(new GridLayout(1,1));
  setSize(500,300);
  setVisible(true);
  setTitle("CBIT ");
  addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
   {
    System.exit(0); 
   }
  });
 }
 public static void main(String args[])
 {
  try{
  Class.forName("oracle.jdbc.OracleDriver");}catch(Exception ex){System.out.println("exception in main function\n"+ex);}
  lm l=new lm();
 }
 public void itemStateChanged(ItemEvent ie)
 {
  System.out.println("displaying details");
  displaydetails();
 }
 public void displaydetails()
 {
  ResultSet rs;
  try{
  rs=stmt.executeQuery("select one,two,nol,seen from staff where name='"+p32choice.getSelectedItem()+"'");
  rs.next();
  t3.setText(Integer.toString(rs.getInt(3)));
  t4.setText(rs.getString(1).substring(0,11));
  t5.setText(rs.getString(2).substring(0,11));
  switch(rs.getInt(4))
  {
   case 1:t6.setText("General");break;
   case 2:t6.setText("Medical");break;
   case 3:t6.setText("Earned");break;
  }
  }catch(Exception e){System.out.println("exception in displaydetails\n"+e);}
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  if(b==b1)
  {
   userlogin();
   //c.next(p);
  }
  if(b==b2)
  {
   lo.showlogin();
  }
  if(b==b3)
  {
   lo.showlogin();
  }
  if(b==b4)
  {
   ch.showchange();
  }
  if(b==b5)
  {
   t1.setText("");
   t2.setText("");
   c.previous(p);
  }
  if(b==b6)
  {
   viewstatus();
   st.showstatus();
  }
  if(b==b7)
  {
   ap.showapply();
  }
  if(b==b8)
  {
   ch.showchange();
  }
  if(b==b9)
  {
   hodlogout();
   c.first(p);
  }
  if(b==b10)
  {
   hodaccept();
  }
  if(b==b11)
  {
   hodreject();
  }
 }
 public void hodaccept()
 {
  String tempselectedname=p32choice.getSelectedItem();
  try{
  stmt.executeUpdate("update staff set nol=null where name='"+p32choice.getSelectedItem()+"'");
  stmt.executeUpdate("update staff set seen=0 where name='"+p32choice.getSelectedItem()+"'");
  stmt.executeUpdate("update staff set accept=1 where name='"+p32choice.getSelectedItem()+"'");
  switch(t6.getText())
  {
   case "General":stmt.executeUpdate("update staff set cl=cl-'"+Integer.parseInt(t3.getText())+"' where name='"+p32choice.getSelectedItem()+"'");break;
   case "Medical":stmt.executeUpdate("update staff set sl=sl-'"+Integer.parseInt(t3.getText())+"' where name='"+p32choice.getSelectedItem()+"'");break;
   case  "Earned":stmt.executeUpdate("update staff set el=el-'"+Integer.parseInt(t3.getText())+"' where name='"+p32choice.getSelectedItem()+"'");break;
  }
  }catch(Exception e){System.out.println("exception in hodaccept\n"+e);}
  t3.setText("");
  t4.setText("");
  t5.setText("");
  t6.setText("");
  p32choice.remove(tempselectedname);
 }
 public void hodreject()
 {
  String tempselectedname=p32choice.getSelectedItem();
  try{
  stmt.executeUpdate("update staff set nol=null where name='"+p32choice.getSelectedItem()+"'");
  stmt.executeUpdate("update staff set seen=0 where name='"+p32choice.getSelectedItem()+"'");
  stmt.executeUpdate("update staff set accept=0 where name='"+p32choice.getSelectedItem()+"'");
  }catch(Exception e){System.out.println("exception in hodaccept\n"+e);}
  t3.setText("");
  t4.setText("");
  t5.setText("");
  t6.setText("");
  p32choice.remove(tempselectedname);  
 }
 public void hodlogin1()
 {
  p32choice.addItemListener(this);
 }
 public void hodlogout()
 {
  t5.setText("");
  t3.setText("");
  t4.setText("");
  t6.setText("");
  p32choice.removeAll();
  p32choice.addItemListener(this);
 }
 public void viewstatus()
 {
  ResultSet rs;
  try{
  rs=stmt.executeQuery("select one,two,accept from staff where id='"+tempid+"'");
  rs.next();
  fromdate=rs.getString(1).substring(0,11);
  todate=rs.getString(2).substring(0,11);
  switch(rs.getInt(3))
  {
   case 0:state="Rejected";
			break;
   case 1:state="Accepted";
			break;
   case 2:state="Pending";
			break;
  }
  }catch(Exception excep){System.out.println("exception in view status\n"+excep);}
  st.repaint();
 }
 class homecan extends Canvas
 {
  homecan(){setSize(200,300);}
  public void paint(Graphics g)
  {
   g.drawImage(cbit,0,0,this);
  }
 }
 class p2can1 extends Canvas
 {
  p2can1(){setSize(200,30);}
  public void paint(Graphics g)
  {
   g.drawString(p2can1str,30,10);
  }
 }
 class p2can2 extends Canvas
 {
  p2can2(){setSize(250,250);}
  public void paint(Graphics g)
  {
   g.drawString("General Leaves Available : "+cl,50,50);
   g.drawString("Medical Leaves Available : "+sl,50,90);
   g.drawString("Earned Leaves Available  : "+el,50,130);
   }
 }
 class login extends Dialog implements ActionListener
 {
  Panel loginp;
  Label loginl1,loginl2;
  TextField logint1,logint2;
  Button loginb,loginb1,loginb2;
  GridBagLayout logingbl;
  GridBagConstraints logingc;
  login(Frame f)
  {
   super(f,"Login",true);
   logingbl=new GridBagLayout();
   logingc=new GridBagConstraints();
   loginp=new Panel();
   loginp.setLayout(logingbl);
   loginl1=new Label("User ID ");
   loginl2=new Label("Password");
   logint1=new TextField(20);
   logint2=new TextField(20);
   logint2.setEchoChar('*');
   loginb1=new Button("back");
   loginb2=new Button("Login");
   loginb1.addActionListener(this);
   loginb2.addActionListener(this);
   logingc.gridx=0;
   logingc.gridy=0;
   logingbl.setConstraints(loginl1,logingc);
   logingc.gridx=1;
   logingc.gridy=0;
   logingbl.setConstraints(logint1,logingc);
   logingc.gridx=0;
   logingc.gridy=1;
   logingbl.setConstraints(loginl2,logingc);
   logingc.gridx=1;
   logingc.gridy=1;
   logingbl.setConstraints(logint2,logingc);
   logingc.gridx=0;
   logingc.gridy=2;
   logingbl.setConstraints(loginb1,logingc);
   logingc.gridx=1;
   logingc.gridy=2;
   logingbl.setConstraints(loginb2,logingc);
   loginp.add(loginl1);
   loginp.add(logint1);
   loginp.add(loginl2);
   loginp.add(logint2);
   loginp.add(loginb1);
   loginp.add(loginb2);
   add(loginp);
   setSize(350,150);
  }
  public void actionPerformed(ActionEvent e)
  {
   loginb=(Button)e.getSource();
   if(loginb==loginb1)
   {
    setVisible(false);
   }
   if(loginb==loginb2)
   {
    if(logint1.getText().equals("admin"))
	{
	 if(logint2.getText().equals("admin"))
	 {
	  setVisible(false);
	  logint1.setText("");
	  logint2.setText("");
	  ad.showadmin();
	 }
	 else
	 {
	  logint2.setText("");
	 }
	}
	else
	{
	 tempid=Integer.parseInt(logint1.getText());
	 if(hodlogin()==1)
	 {
      setVisible(false);
	  c.next(p);
	  c.next(p);
	 }
	 else
	 {
	  logint1.setText("");
	  logint2.setText("");
	 }
	}
   }
  }
  public int hodlogin()
  {
   hodlogin1();
   String tempdept;
   ResultSet rs,rs1;
   if(Integer.parseInt(logint1.getText())>=700)
   {
   try{
   rs=stmt.executeQuery("select password,name,dept from staff where id='"+tempid+"'");
   rs.next();
   if(rs.getString(1).equals(logint2.getText()))
   {
    p2can1str="welcome  "+rs.getString(2);
	p3c1.repaint();
	tempdept=rs.getString(3);
	rs1=stmt.executeQuery("select name from staff where nol>0 and dept='"+tempdept+"'");
	while(rs1.next())
	{
	 p32choice.add(rs1.getString(1));
	}
	hodlogin1();
	return 1;
   }
   else
   {
    logint2.setText("");
   }
   }catch(Exception e)
   {
    System.out.println("exception in hod login \n"+e);
	return 0;
   }
   return 0;
   }
   else
   {
    logint1.setText("");
	logint2.setText("");
	return 0;
   }
  }
  public void showlogin()
  {
   logint1.setText("");
   logint2.setText("");
   setVisible(true);
  }
 }
 class admin extends Dialog implements ActionListener
 {
  ArrayList<Integer> al_id;
  ArrayList<String> al_name,al_phno,al_email,al_dept,al_desig;
  int admin_id,count;
  String admin_name,admin_phno,admin_email,admin_dept,admin_desig;
  Button adminb,adminb1,adminb2,adminb3;
  TextField admint1;
  Choice adminchoice;
  Label adminl1,adminl2;
  admin(Frame f)
  {
   super(f,"Admin",true);
   al_id=new ArrayList<Integer>();
   al_name=new ArrayList<String>();
   al_phno=new ArrayList<String>();
   al_email=new ArrayList<String>();
   al_dept=new ArrayList<String>();
   al_desig=new ArrayList<String>();
   adminchoice=new Choice();
   adminchoice.add("cse");
   adminchoice.add("ece");
   adminchoice.add("eee");
   adminchoice.add("civil");
   adminchoice.add("mech");
   adminchoice.add("it");
   adminchoice.add("prod");
   adminchoice.add("bio-tech");
   adminb1=new Button("View Details");
   adminb2=new Button("Search");
   adminb3=new Button("Logout");
   adminl1=new Label("Search by name :");
   adminl2=new Label("select dept :");
   admint1=new TextField(20);
   adminb1.addActionListener(this);
   adminb2.addActionListener(this);
   adminb3.addActionListener(this);
   add(adminl2);
   add(adminchoice);
   add(adminb1);
   add(adminl1);
   add(admint1);
   add(adminb2);
   add(adminb3);
   setLayout(new FlowLayout());
   setSize(1100,500);
  }
  public void actionPerformed(ActionEvent e)
  {
   adminb=(Button)e.getSource();
   if(adminb==adminb1)
   {
    al_id.clear();
	al_name.clear();
	al_phno.clear();
	al_email.clear();
	al_dept.clear();
	al_desig.clear();
	count=0;
    ResultSet rs;
	try{
	rs=stmt.executeQuery("select id,name,phno,email,dept,desig from staff where dept='"+adminchoice.getSelectedItem()+"'");
	while(rs.next())
	{
	 al_id.add(rs.getInt(1));
	 al_name.add(rs.getString(2));
	 al_phno.add(rs.getString(3));
	 al_email.add(rs.getString(4));
	 al_dept.add(rs.getString(5));
	 al_desig.add(rs.getString(6));
	 count++;
	 //System.out.println(count);
	}
	}catch(Exception e1){System.out.println("exception in admin b\n"+e1);}
	admint1.setText("");
   }
   if(adminb==adminb2)
   {
    ResultSet rs;
	try{
	 rs=stmt.executeQuery("select id,name,phno,email,dept,desig from staff where name='"+admint1.getText()+"'");
	 rs.next();
	 admin_id=rs.getInt(1);
	 admin_name=rs.getString(2);
	 admin_phno=rs.getString(3);
	 admin_email=rs.getString(4);
	 admin_dept=rs.getString(5);
	 admin_desig=rs.getString(6);
	}catch(Exception e1){System.out.println("exception in adminsearch(adminb2)\n"+e1);}
	admint1.setText("");
   }
   if(adminb==adminb3)
   {
    admint1.setText("");
    setVisible(false);
   }
   repaint();
  }
  public void showadmin()
  {
   count=0;
   admint1.setText("");
   setVisible(true);
  }
  public void paint(Graphics g)
  {
   g.setColor(Color.red);
   g.drawString("ID",50,100);
   g.drawString("NAME",100,100);
   g.drawString("Phone No.",250,100);
   g.drawString("E-Mail",400,100);
   g.drawString("Department",600,100);
   g.drawString("Designation",700,100);
   g.setColor(Color.black);
   if(adminb==adminb2)
   {
    g.drawString(""+admin_id,50,130);
    g.drawString(admin_name,100,130);
    g.drawString(admin_phno,250,130);
    g.drawString(admin_email,400,130);
    g.drawString(admin_dept,600,130);
    g.drawString(admin_desig,700,130);
   }
   if(adminb==adminb1)
   {
    for(int i=0,cox=130;i<count;i++,cox+=30)
	{
	 g.drawString(""+al_id.get(i),50,cox);
     g.drawString(al_name.get(i),100,cox);
     g.drawString(al_phno.get(i),250,cox);
     g.drawString(al_email.get(i),400,cox);
     g.drawString(al_dept.get(i),600,cox);
     g.drawString(al_desig.get(i),700,cox);
	}
   }
  }
 }
 class status extends Dialog implements ActionListener
 {
  Button statusb1;
  status(Frame f)
  {
   super(f,"Status",true);
   statusb1=new Button("ok");
   statusb1.addActionListener(this);
   add(statusb1);
   setSize(300,140);
   setLayout(new FlowLayout());
  }
  public void actionPerformed(ActionEvent e)
  {
   setVisible(false);
  }
  public void showstatus()
  {
   setVisible(true);
  }
  public void paint(Graphics g)
  {
   g.drawString("your    request    from     "+fromdate+"     to ",30,80);
   g.drawString(""+todate+"      is     "+state,30,110);
  }
 }
 class apply extends Dialog implements ActionListener
 {
  int tempnol;
  String date1,date2;
  Label applyl1,applyl2,applyl3,applyl4;
  TextField applyt1;
  Choice applyc1,applyc2,applyc3,applyc4,applyc5,applyc6,applyc7;
  Button applyb,applyb1,applyb2;
  GridBagLayout applygbl;
  GridBagConstraints applygc;
  apply(Frame f)
  {
   super(f,"Apply Leave",true);
   applygbl=new GridBagLayout();
   applygc=new GridBagConstraints();
   setLayout(applygbl);
   applyl1=new Label("Type of Laeve : ");
   applyl2=new Label("No. of Leaves : ");
   applyl3=new Label("From :");
   applyl4=new Label("To :");
   applyt1=new TextField(20);
   applyc1=new Choice();
   applyc2=new Choice();
   applyc3=new Choice();
   applyc4=new Choice();
   applyc5=new Choice();
   applyc6=new Choice();
   applyc7=new Choice();
   applyb1=new Button("cancel");
   applyb2=new Button("Apply");
   applyb1.addActionListener(this);
   applyb2.addActionListener(this);
   applyc1.add("General");
   applyc1.add("Medical");
   applyc1.add("Earned");
   for(int i=1;i<32;i++)
   {
    applyc2.add(Integer.toString(i));
	applyc5.add(Integer.toString(i));
   }
   for(int i=1;i<13;i++)
   {
    applyc3.add(Integer.toString(i));
	applyc6.add(Integer.toString(i));
   }
   applyc4.add("2014");
   applyc4.add("2015");
   applyc4.add("2016");
   applyc7.add("2014");
   applyc7.add("2015");
   applyc7.add("2016");
   applygc.gridx=0;
   applygc.gridy=0;
   applygc.anchor=GridBagConstraints.EAST;
   applygbl.setConstraints(applyl1,applygc);
   applygc.gridx=1;
   applygc.gridy=0;
   applygc.gridwidth=3;
   applygc.anchor=GridBagConstraints.WEST;
   applygbl.setConstraints(applyc1,applygc);
   applygc.gridx=0;
   applygc.gridy=1;
   applygc.gridwidth=1;
   applygc.anchor=GridBagConstraints.EAST;
   applygbl.setConstraints(applyl2,applygc);
   applygc.gridx=1;
   applygc.gridy=1;
   applygc.gridwidth=3;
   applygbl.setConstraints(applyt1,applygc);
   applygc.gridx=0;
   applygc.gridy=2;
   applygc.gridwidth=1;
   applygbl.setConstraints(applyl3,applygc);
   applygc.gridx=1;
   applygc.gridy=2;
   applygbl.setConstraints(applyc2,applygc);
   applygc.gridx=2;
   applygc.gridy=2;
   applygbl.setConstraints(applyc3,applygc);
   applygc.gridx=3;
   applygc.gridy=2;
   applygc.anchor=GridBagConstraints.WEST;
   applygbl.setConstraints(applyc4,applygc);
   applygc.gridx=0;
   applygc.gridy=3;
   applygc.anchor=GridBagConstraints.EAST;
   applygbl.setConstraints(applyl4,applygc);
   applygc.gridx=1;
   applygc.gridy=3;
   applygbl.setConstraints(applyc5,applygc);
   applygc.gridx=2;
   applygc.gridy=3;
   applygbl.setConstraints(applyc6,applygc);
   applygc.gridx=3;
   applygc.gridy=3;
   applygc.anchor=GridBagConstraints.WEST;
   applygbl.setConstraints(applyc7,applygc);
   applygc.gridx=0;
   applygc.gridy=4;
   applygc.anchor=GridBagConstraints.EAST;
   applygbl.setConstraints(applyb1,applygc);
   applygc.gridx=3;
   applygc.gridy=4;
   applygc.anchor=GridBagConstraints.WEST;
   applygbl.setConstraints(applyb2,applygc); 
   add(applyl1);
   add(applyc1);
   add(applyl2);
   add(applyt1);
   add(applyl3);
   add(applyc2);
   add(applyc3);
   add(applyc4);
   add(applyl4);
   add(applyc5);
   add(applyc6);
   add(applyc7);
   add(applyb1);
   add(applyb2);
   setSize(350,300);
  }
  public void actionPerformed(ActionEvent e)
  {   
   applyb=(Button)e.getSource();
   if(applyb==applyb1)
   {
    setVisible(false);
    applyt1.setText("");
   }
   if(applyb==applyb2)
   {
    if(applyt1.getText().equals(""))
	{
	 applyt1.setText("enter no. of leaves");
	}
	else
	{
	 applyleave();
	 //setVisible(false);
	 applyt1.setText("");
	}
   }
  }
  public void showapply()
  {
   setVisible(true);
  }
  public void applyleave()
  {
   int temptypeindex;
   String temptype;
   ResultSet rs;
   temptypeindex=applyc1.getSelectedIndex()+1;
   tempnol=Integer.parseInt(applyt1.getText());
   date1=applyc2.getSelectedItem()+"-"+applyc3.getSelectedItem()+"-"+applyc4.getSelectedItem();
   date2=applyc5.getSelectedItem()+"-"+applyc6.getSelectedItem()+"-"+applyc7.getSelectedItem();
   //System.out.println("\n"+temptypeindex+"\n"+tempnol+"\n"+date1+"   to   "+date2+"\n");
   if(verify()==1)
   {
    try{
    stmt.executeUpdate("update staff set seen='"+temptypeindex+"' where id='"+tempid+"'");
	stmt.executeUpdate("update staff set accept=2 where id='"+tempid+"'");
    stmt.executeUpdate("update staff set one='"+date1+"' where id='"+tempid+"'");
    stmt.executeUpdate("update staff set two='"+date2+"' where id='"+tempid+"'");
    stmt.executeUpdate("update staff set nol='"+tempnol+"' where id='"+tempid+"'");
	hodlogin1();
    }catch(Exception e){System.out.println("exception in applyleave\n"+e);}
	setVisible(false);
   }
   else
   {
    applyt1.setText("");
   }
  }
  public int verify()
  {
   if(condition1() && condition2())
   return 1;
   else
   return 0;
  }
  public boolean condition1()
  {
   int templeaves=0;
   ResultSet rs;
   try{
   switch(applyc1.getSelectedItem())
   {
    case "General":rs=stmt.executeQuery("select cl from staff where id='"+tempid+"'");rs.next();templeaves=rs.getInt(1);break;
	case "Medical":rs=stmt.executeQuery("select sl from staff where id='"+tempid+"'");rs.next();templeaves=rs.getInt(1);break;
	case  "Earned":rs=stmt.executeQuery("select el from staff where id='"+tempid+"'");rs.next();templeaves=rs.getInt(1);break;
   }
   //rs.next();
   //templeaves=rs.getInt(1);
   }catch(Exception e){System.out.println("exception in condition 1\n"+e);}
   if(templeaves < Integer.parseInt(applyt1.getText()))
   return false;
   else 
   return true;
  }
  public boolean condition2()
  {
   int tempdiffdate=diffdate(Integer.parseInt(applyc2.getSelectedItem()),Integer.parseInt(applyc3.getSelectedItem()),Integer.parseInt(applyc4.getSelectedItem()),Integer.parseInt(applyc5.getSelectedItem()),Integer.parseInt(applyc6.getSelectedItem()),Integer.parseInt(applyc7.getSelectedItem()));
   if(tempdiffdate==Integer.parseInt(applyt1.getText()))
   return true;
   else
   return false;
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
 }
 public void setConnection()
 {
  try{
   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
   stmt=con.createStatement();
  }catch(Exception e){System.out.println("exception in setConnection function\n"+e);}
 }
 public void userlogin()
 {
  String temppass="admin security break",tempname="anonymous";
  int tempcl=0,tempsl=0,tempel=0;
  ResultSet rs;
  tempid=Integer.parseInt(t1.getText());
  if(tempid<700)
  {
  try{
  rs=stmt.executeQuery("select password,name,cl,sl,el from staff where id='"+tempid+"'");
  rs.next();
  temppass=rs.getString(1);
  tempname=rs.getString(2);
  tempcl=rs.getInt(3);
  tempsl=rs.getInt(4);
  tempel=rs.getInt(5);
  //System.out.println(temppass);
  }catch(Exception e)
  {
   t1.setText("");
   System.out.println("exception in userlogin\n"+e);
  }
  if(t2.getText().equals(temppass))
  {
   p2can1str="welcome "+tempname;
   p2c1.repaint();
   fromdate="";
   todate="";
   state="";
   st.repaint();
   cl=tempcl;
   sl=tempsl;
   el=tempel;
   p2c2.repaint();
   c.next(p);
  }
  else
  {
   t2.setText("");
  }
  }
  else
  {
   t1.setText("");
   t2.setText("");
  }
 }
 class change extends Dialog implements ActionListener
 {
  Panel changep,changep1,changep2,changep3;
  Button changeb,changeb1,changeb2,changeb3,changeb4,changeb5;
  String changetype;
  CardLayout changec;
  Label changel1,changel2;
  TextField changet1;
  change(Frame f)
  {
   super(f,"Change Details",true);
   changec=new CardLayout();
   changep=new Panel();
   changep.setLayout(changec);
   changep1=new Panel();
   changep2=new Panel();
   changep3=new Panel();
   changeb1=new Button("Change Password");
   changeb2=new Button("Change Phone No.");
   changeb3=new Button("Change E-mail");
   changeb4=new Button("Change");
   changeb5=new Button("ok");
   changeb1.addActionListener(this);
   changeb2.addActionListener(this);
   changeb3.addActionListener(this);
   changeb4.addActionListener(this);
   changeb5.addActionListener(this);
   changep1.add(changeb1);
   changep1.add(changeb2);
   changep1.add(changeb3);
   changep1.setLayout(new FlowLayout());
   changel1=new Label("Enter new Detail :");
   changel2=new Label("Successfully Changed");
   changet1=new TextField(20);
   changep2.add(changel1);
   changep2.add(changet1);
   changep2.add(changeb4);
   changep2.setLayout(new FlowLayout());
   changep3.add(changel2);
   changep3.add(changeb5);
   changep3.setLayout(new FlowLayout());
   changep.add(changep1);
   changep.add(changep2);
   changep.add(changep3);
   add(changep);
   setLayout(new GridLayout(1,1));
   setSize(200,150);
  }
  public void actionPerformed(ActionEvent ae)
  {
   changeb=(Button)ae.getSource();
   if(changeb==changeb1)
   {
    changetype="password";
	changec.next(changep);
   }
   if(changeb==changeb2)
   {
    changetype="phno";
	changec.next(changep);
   }
   if(changeb==changeb3)
   {
    changetype="email";
	changec.next(changep);
   }
   if(changeb==changeb4)
   {
    try{
	switch(changetype)
	{
	case "password":stmt.executeUpdate("update staff set password='"+changet1.getText()+"' where id='"+tempid+"'");break;
	case "phno":stmt.executeUpdate("update staff set phno='"+changet1.getText()+"' where id='"+tempid+"'");break;
	case "email":stmt.executeUpdate("update staff set email='"+changet1.getText()+"' where id='"+tempid+"'");break;
	}
    changec.next(changep);}catch(Exception e){System.out.println("exception in change details\n"+e);}
   }
   if(changeb==changeb5)
   {
    changet1.setText("");
	changec.first(changep);
    setVisible(false);
   }
  }
  public void showchange()
  {
   setVisible(true);
  }
 }
}