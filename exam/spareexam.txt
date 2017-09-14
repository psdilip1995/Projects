import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
class newdail extends Dialog implements ActionListener
{
 int flag=0;
 StringTokenizer e;
 File fu;
 String s="",s1,s2,s3,s4;
 Label l5,l6;
 TextField t1,t2,t3,t4;
 Button b1,b2;
 newdail(Frame f)
 {
  super(f,"new registration",true);
  Label l1=new Label("user ID*");
  t1=new TextField(20);
  t1.setText("");
  Label l2=new Label("Name*");
  t2=new TextField(20);
  t2.setText("");
  Label l3=new Label("enter password*");
  t3=new TextField(20);
  t3.setText("");
  t3.setEchoChar('*');
  Label l4=new Label("re-enter password*");
  t4=new TextField(20);
  t4.setText("");
  t4.setEchoChar('*');
  l5=new Label("userID exsit already");
  l5.setVisible(false);
  l6=new Label("re-enter password");
  l6.setVisible(false);
  l1.setAlignment(2);
  l2.setAlignment(2);
  l3.setAlignment(2);
  l4.setAlignment(2);
  b1=new Button("back");
  b2=new Button("submit");
  b1.addActionListener(this);
  b2.addActionListener(this);
  setLayout(new GridLayout(6,2,0,10));
  add(l1);
  add(t1);
  add(l2);
  add(t2);
  add(l3);
  add(t3);
  add(l4);
  add(t4);
  add(b1);
  add(b2);
  add(l5);
  add(l6);
  setSize(250,250);
  fu=new File("C:\\config86\\security","user.dil");
  try
  {
   FileInputStream fis=new FileInputStream(fu);
   int k=fis.read();
   while(k!=-1)
   {
    s=s+(char)k;
    k=fis.read();
   }
  }
  catch(Exception ee){}
  e=new StringTokenizer(s,":");
 }
 public void actionPerformed(ActionEvent ae)
 {
  l5.setVisible(false);
  l6.setVisible(false);
  Button b=(Button)ae.getSource();
  if(b==b1)
	setVisible(false);
  if(b==b2)
  {
   e=new StringTokenizer(s,":");
   flag=0;
   s1=t1.getText();
   s2=t2.getText();
   s3=t3.getText();
   s4=t4.getText();
   if(s1.length()==0||s2.length()==0||s3.length()==0||s4.length()==0)
	flag=1;
   while(e.hasMoreTokens())
   {
    if((e.nextToken()).equals(s1))
    {
     flag=1;
     l6.setVisible(false);
     l5.setVisible(true);
     break;
    }
   }
   if(!s3.equals(s4))
   {
    flag=1;
    l5.setVisible(false);
    l6.setVisible(true);
    t3.setText("");
    t4.setText("");
   }
   if(flag==0)
   {
    String mon[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
    GregorianCalendar gc=new GregorianCalendar();
    String count="",details="";
    s=s+s1+":";
    try
    {
     FileOutputStream fos=new FileOutputStream(fu);
     for(int l=0;l<s.length();l++)
	fos.write(s.charAt(l));
     fos.close();
     File fc=new File("C:\\config86\\system","count.dil");
     FileInputStream fis2=new FileInputStream(fc);
     int q=fis2.read();
     while(q!=-1)
     {
      count=count+(char)q;
      q=fis2.read();
     }
     int cou=Integer.parseInt(count);
     ++cou;
     count=String.valueOf(cou);
     FileOutputStream fos2=new FileOutputStream(fc);
     for(int l=0;l<count.length();l++)
	fos2.write(count.charAt(l));
     fos2.close();
     fis2.close();
     File fn=new File("C:\\config86\\A3C5F3",s1+".dil");
     fn.createNewFile();
     fos2=new FileOutputStream(fn);
     details=details+s2+":"+s3+":"+gc.get(Calendar.YEAR)+"/"+mon[gc.get(Calendar.MONTH)]+"/"+gc.get(Calendar.DATE)+"  "+gc.get(Calendar.HOUR)+"/"+gc.get(Calendar.MINUTE)+"/"+gc.get(Calendar.SECOND)+":";
     for(int l=0;l<details.length();l++)
	fos2.write(details.charAt(l));
     fos2.close();
    }
    catch(Exception e){} 
    setVisible(false);
   }
  }
 }
 void shownewdail()
 {
  setVisible(true);
  t1.setText("");
  t2.setText("");
  t3.setText("");
  t4.setText("");
 }
}
class exam extends Frame implements ActionListener
{
 can1 c1;
 can2 c2;
 can3 c3;
 can4 c4;
 CheckboxGroup cbg;
 Checkbox cb1,cb2,cb3,cb4;
 can c;
 String cans="click next to start quiz";
 String ans1="",ans2="",ans3="",ans4="";
 GregorianCalendar gc;
 Panel pe,pe2,pe3,pe4,pe5,pe6,pe7;
 String userdet[]=new String[15];
 newdail nd;
 CardLayout cl;
 Panel p,p1,p2,p3,p4;
 Button b,b1,b2,b3,b4,b5,b6,b7,b8,b9;
 TextField t1,t2,t3;
 Label l1,l2,l3,l4,l5;
 exam()
 {
  c1=new can1();
  c2=new can2();
  c3=new can3();
  c4=new can4();
  cbg=new CheckboxGroup();
  cb1=new Checkbox("A.  ",cbg,false);
  cb2=new Checkbox("B.  ",cbg,false);
  cb3=new Checkbox("C.  ",cbg,false);
  cb4=new Checkbox("D.  ",cbg,false);
  l3=new Label("");
  l4=new Label("");
  l5=new Label("");
  c=new can();
  pe7=new Panel();
  pe6=new Panel();
  pe5=new Panel();
  pe4=new Panel();
  pe3=new Panel();
  pe2=new Panel();
  pe=new Panel();
  nd=new newdail(this);
  Label l=new Label("enter key");
  l1=new Label("user ID");
  l1.setAlignment(2);
  l2=new Label("Password");
  l2.setAlignment(2);
  cl=new CardLayout();
  p=new Panel();
  p1=new Panel();
  p2=new Panel();
  p3=new Panel();
  p4=new Panel();
  b1=new Button("submit");
  b2=new Button("new user");
  b3=new Button("login");
  b4=new Button("back");
  b5=new Button("login");
  b6=new Button("logout");
  b7=new Button("prev");
  b8=new Button("next");
  b9=new Button("submit");
  t1=new TextField(20);
  t2=new TextField(20);
  t3=new TextField(20);
  t3.setEchoChar('*');
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  b5.addActionListener(this);
  b6.addActionListener(this);
  b7.addActionListener(this);
  b8.addActionListener(this);
  b9.addActionListener(this);
  setVisible(true);
  setSize(500,500);
  setLayout(new GridLayout(1,1));
  pe7.add(cb4);
  pe7.add(c4);
  pe6.add(cb3);
  pe6.add(c3);
  pe5.add(cb2);
  pe5.add(c2);
  pe4.add(cb1);
  pe4.add(c1);
  pe4.setLayout(new FlowLayout());
  pe5.setLayout(new FlowLayout());
  pe6.setLayout(new FlowLayout());
  pe7.setLayout(new FlowLayout());
  pe3.setLayout(new GridLayout(6,0));
  pe3.add(c);
  pe3.add(l3);
  pe3.add(pe4);
  pe3.add(pe5);
  pe3.add(pe6);
  pe3.add(pe7);
  pe2.add(b7);
  pe2.add(b8);
  pe2.add(b9);
  pe2.setLayout(new FlowLayout());
  pe.add(b6);
  pe.add(new cancan());
  pe.setLayout(new FlowLayout());
  p1.add(l);
  p1.add(t1);
  p1.add(b1);
  p2.add(b3);
  p2.add(b2);
  p3.add(l1);
  p3.add(t2);
  p3.add(l2);
  p3.add(t3);
  p3.add(b4);
  p3.add(b5);
  p4.setLayout(new BorderLayout());
  p4.add(pe,"North");
  p4.add(pe2,"South");
  p4.add(pe3,"Center");
  p4.add(l4,"East");
  p4.add(l5,"West");
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.add(p4);
  p.setLayout(cl);
  p1.setLayout(new FlowLayout());
  p2.setLayout(new FlowLayout());
  p3.setLayout(new FlowLayout());
  add(p);
  addWindowListener(new WindowAdapter()
  {
   public void windowClosing(WindowEvent e)
  {
   System.exit(0);
  }
  });
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  if(b==b1)
  {
   try
   {
   verify();
   }
   catch(Exception e){}
  }
  if(b==b2)
	nd.shownewdail();
  if(b==b3)
	cl.next(p);
  if(b==b4)
  {
   cl.previous(p);
   t2.setText("");
   t3.setText("");
  }
  if(b==b5)
	login();
  if(b==b6)
  {
   File foo=new File("C:\\config86\\A3C5F3",t2.getText()+".dil");
   t2.setText("");
   t3.setText("");
   cl.previous(p);
   userdet[4]=userdet[3];
   String fin="";
   for(int b=0;b<15;b++)
	fin=fin+userdet[b]+":";
   try
   {
    FileOutputStream foos=new FileOutputStream(foo);
    for(int g=0;g<fin.length();g++)
	foos.write(fin.charAt(g));
    foos.close();
   }
   catch(Exception eeee){}
  }
 }
 public static void main(String args[])
 {
  exam e=new exam();
 }
 void verify()throws Exception
 {
  File f=new File("C:\\config86\\S5F8I2B9","conf.dil");
  FileInputStream fis=new FileInputStream(f);
  String str="";
  int j=fis.read();
  while(j!=-1)
  {
   str=str+(char)j;
   j=fis.read();
  }
  fis.close();
  if(str.equals(t1.getText()))
	cl.next(p);
 }
 public void login()
 {
  int flo=0;
  String s="";
  File fu=new File("C:\\config86\\security","user.dil");
  try
  {
   FileInputStream fis=new FileInputStream(fu);
   int k=fis.read();
   while(k!=-1)
   {
    s=s+(char)k;
    k=fis.read();
   }
  }
  catch(Exception ee){}
  StringTokenizer e=new StringTokenizer(s,":");
  while(e.hasMoreTokens())
  {
   if((e.nextToken()).equals(t2.getText()))
   {
    flo=1;
   }
  }
  if(flo==0)
	t2.setText("");
  else
  {
   int z=0;
   String det="";
   File foo=new File("C:\\config86\\A3C5F3",t2.getText()+".dil");
   try
   {
    FileInputStream foos=new FileInputStream(foo);
    int q=foos.read();
    while(q!=-1)
    {
     det=det+(char)q;
     q=foos.read();
    }
   }
   catch(Exception eee){}
   StringTokenizer ds=new StringTokenizer(det,":");
   while(ds.hasMoreTokens())
   {
    userdet[z]=ds.nextToken();
    z++;
   }
   for(int d=z;d<15;d++)
	userdet[d]=null;
   if(userdet[1].equals(t3.getText()))
   {
    cl.next(p);
    String mon[]={"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
    gc=new GregorianCalendar();
    String lastlog=gc.get(Calendar.YEAR)+"/"+mon[gc.get(Calendar.MONTH)]+"/"+gc.get(Calendar.DATE)+"  "+gc.get(Calendar.HOUR)+"/"+gc.get(Calendar.MINUTE)+"/"+gc.get(Calendar.SECOND);
    userdet[3]=lastlog;
   }
   else
	t3.setText("");
  }
 }
 class cancan extends Canvas
 {
  cancan()
  {
   setBackground(Color.white);
   setSize(400,30);
   repaint();
  }
  public void paint(Graphics g)
  {
   g.drawString("welcome "+userdet[0]+" last login is at "+userdet[4],10,20);
  }
 }
 class can extends Canvas
 {
  can()
  {
   setBackground(Color.lightGray);
   setSize(200,10);
   repaint();
  }
  public void paint(Graphics g)
  {
   g.drawString(cans,5,20);
  }
 }
 class can1 extends Canvas
 {
  can1(){setSize(300,30);}
  public void paint(Graphics g){g.drawString(ans1,20,20);}
 }
 class can2 extends Canvas
 {
  can2(){setSize(300,30);}
  public void paint(Graphics g){g.drawString(ans2,20,20);}
 }
 class can3 extends Canvas
 {
  can3(){setSize(300,30);}
  public void paint(Graphics g){g.drawString(ans3,20,20);}
 }
 class can4 extends Canvas
 {
  can4(){setSize(300,30);}
  public void paint(Graphics g){g.drawString(ans4,20,20);}
 }
}