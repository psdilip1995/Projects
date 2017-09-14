import optimal.*;
import java.io.File;
import java.io.IOException;
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class maptsp extends Frame implements ActionListener,MouseListener,MouseMotionListener
{
 ArrayList <Integer>al;
 int mx,my,txy[][],cx=5,cy=5,flag=0,o=0,hx,hy,dx1,dy1,dx2,dy2,startindex=90,n,result[],distance[][];
 Color col;
 BufferedImage img,resimg;
 File file;
 Panel p,p0,p1,p2;
 Button b,b0,b1,b3;
 CardLayout c;
 can ca1;
 can1 c1;
 can2 c2;
 can3 c3;
 can4 c4;
 saveres save;
 String cities[],can2str,can3str;
 opt op;
 maptsp()
 {
  save=new saveres(this);
  op=new opt();
  al=new ArrayList<Integer>();
  col=new Color(255,255,255);
  cities=new String[29];
  c=new CardLayout();
  try{
  file=new File("map5.jpg");
  resimg=ImageIO.read(file);
  img=ImageIO.read(file);}catch(Exception e){}
  setimg();
  p=new Panel();
  p.setLayout(c);
  p0=new Panel();
  b0=new Button("start");
  b0.addActionListener(this);
  c1=new can1();
  p0.add(b0);
  p0.add(c1);
  p0.setLayout(new FlowLayout());
  p1=new Panel();
  can2str="not selected";
  can3str="welcome";
  c2=new can2();
  b1=new Button("ok");
  b1.addActionListener(this);
  c3=new can3();
  ca1=new can();
  ca1.addMouseListener(this);
  ca1.addMouseMotionListener(this);
  p1.add(c2);
  p1.add(b1);
  p1.add(c3);
  p1.add(ca1);
  ca1.repaint();
  p1.setLayout(new FlowLayout());
  p2=new Panel();
  b3=new Button("Save As Image");
  b3.addActionListener(this);
  c4=new can4();
  p2.add(b3);
  p2.add(c4);
  p.add(p0);
  p.add(p1);
  p.add(p2);
  add(p);
  setLayout(new GridLayout(1,1));
  setSize(650,700);
  setVisible(true);
 }
 public static void main(String args[])
 {
  maptsp m=new maptsp();
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  if(b==b0)
      c.next(p);
  if(b==b1)
  {
   if(startindex<29)
   {
	  setalgo();
	  if(n>2)
	  {
	   c.next(p);
	   res();
	   //disp();
	  }
	  else
	  {
	   can3str="minimum three cities should be selected";
	   c3.repaint();
	  }
   }
   else
   {
    can3str="starting city is not selected";
	c3.repaint();
   }
  }
  if(b==b3)
  {
   save.showsave();
  }
 }
 public void paint(Graphics g)
 {
  g.drawImage(img,50,50,this);
 }
 public void mousePressed(MouseEvent me)
 {
  dx1=me.getX();
  dy1=me.getY();
  /*mx=me.getX();
  my=me.getY();
  flag=0;
  find();*/
  //System.out.println(""+dx1+" "+dy1);
 }
 public void mouseReleased(MouseEvent me)
 {
  dx2=me.getX();
  dy2=me.getY();
  //System.out.println(""+dx2+" "+dy2);
  setstart();
  //System.out.println(""+dx2+" "+dy2);
 }
 public void mouseClicked(MouseEvent me)
 {
  mx=me.getX();
  my=me.getY();
  find();
 }
 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseMoved(MouseEvent me)
 {
  hx=me.getX();
  hy=me.getY();
  hover();
 }
 public void mouseDragged(MouseEvent me){}
 class can extends Canvas
 {
  can(){setSize(650,700);}
  public void paint(Graphics g)
  {
   update(g);
  }
  public void update(Graphics g)
  {
    if(o==0)
	{
    g.drawImage(img,50,0,this);
    /*g.setColor(Color.blue);
    for(int z=0;z<29;z++)
    g.fillOval(txy[z][0]-5,txy[z][1]-5,10,10);*/
	o=1;
	}
	else if(o==1)
	{
	 g.setColor(col);
	 g.fillOval(cx-5,cy-5,11,11);
	}
  }
 }
 class can1 extends Canvas
 {
  can1(){setSize(650,700);}
  public void paint(Graphics g)
  {
   update(g);
  }
  public void update(Graphics g)
  {
   g.drawString("1.double the city into box to select starting city",100,100);
   g.drawString("2.click on the circles to select the city",100,120);
   g.drawString("3.click ok to continue",100,140);
   g.drawString("4.color terminology",100,160);
   g.setColor(Color.blue);
   g.fillOval(150,180,10,10);
   g.setColor(Color.green);
   g.fillOval(150,200,10,10);
   /*g.setColor(Color.red);
   g.fillOval(150,220,10,10);*/
   g.setColor(Color.yellow);
   g.fillOval(150,220,10,10);
   g.setColor(Color.black);
   g.drawString("----> available cities",170,190);
   g.drawString("----> selected  cities",170,210);
   //g.drawString("----> starting city",170,230);
   g.drawString("----> extra cities added",170,230);
  }
 }
 public void setimg()
 {
  int q=0,x,y,city,tx,ty;
  String sx="",sy="",scity="";
  txy=new int[29][3];
  try{
  FileInputStream ftx=new FileInputStream("tx.txt");
  FileInputStream fty=new FileInputStream("ty.txt");
  FileInputStream ftcity=new FileInputStream("city.txt");
  x=ftx.read();
  y=fty.read();
  city=ftcity.read();
  while((char)x!='}')
  {
   while((char)x!=',')
   {
    sx=sx+(char)x;
	x=ftx.read();
   }
   while((char)y!=',')
   {
    sy=sy+(char)y;
	y=fty.read();
   }
   while((char)city!=',')
   {
    scity=scity+(char)city;
	city=ftcity.read();
   }
   tx=Integer.parseInt(sx);
   ty=Integer.parseInt(sy);
   txy[q][0]=tx;
   txy[q][1]=ty;
   txy[q][2]=0;
   cities[q]=scity;
   q++;
   x=ftx.read();
   y=fty.read();
   city=ftcity.read();
   sx="";
   sy="";
   //System.out.println("x= "+tx+" y= "+ty+" city= "+scity);
   scity="";
  }
  }catch(Exception e){}
  Graphics g=img.getGraphics();
  g.setColor(Color.black);
  g.drawRect(400,450,50,50);
  g.drawString("drag the starting city here",400,440);
  g.setColor(Color.blue);
  for(int z=0;z<29;z++)
  g.fillOval(txy[z][0]-55,txy[z][1]-5,10,10);
 }
 public void find()
 {
  int l;
  for(l=0;l<29;l++)
   if((mx > txy[l][0]-5 && mx < txy[l][0]+5)&&(my > txy[l][1]-5 && my < txy[l][1]+5))
   {
    cx=txy[l][0];
	cy=txy[l][1];
	break;
   }
  //System.out.println(""+cx+" "+cy);
  if(l<29)
  {
   if(txy[l][2]==0)
   {
    txy[l][2]=1;
    col=new Color(0,255,0);
   }
   else if(txy[l][2]==1)
   {
    txy[l][2]=0;
    col=new Color(0,0,255);
   }
   ca1.repaint();
  }
  if(l==29)
  {
   cx=5;
   cy=5;
   col=new Color(255,255,255);
  }
 }
 class can2 extends Canvas
 {
  can2(){setSize(200,30);}
  public void paint(Graphics g)
  {
   g.drawString("starting city : "+can2str,30,10);
  }
 }
 class can3 extends Canvas
 {
  can3(){setSize(300,30);}
  public void paint(Graphics g)
  {
   g.drawString(""+can3str,30,10);
  }
 }
 public void hover()
 {
  int l;
  for(l=0;l<29;l++)
   if((hx > txy[l][0]-5 && hx < txy[l][0]+5)&&(hy > txy[l][1]-5 && hy < txy[l][1]+5))
   {
    /*cx=txy[l][0];
	cy=txy[l][1];*/
	can3str=cities[l];
	c3.repaint();
	break;
   }
  if(l==29)
  {
   can3str="";
   c3.repaint();
  }
 }
 public void setstart()
 {
  int l=90;
  if((dx2 > 400 && dx2 < 500)&&(dy2 > 400 && dy2 < 500))
  for(l=0;l<29;l++)
   if((dx1 > txy[l][0]-5 && dx1 < txy[l][0]+5)&&(dy1 > txy[l][1]-5 && dy1 < txy[l][1]+5))
   {
    can2str=cities[l];
	c2.repaint();
	break;
   }
  //System.out.println(startindex+" "+l );
  /*cx=txy[startindex][0];
  cx=txy[startindex][1];
  col=new Color(0,255,0);
  ca1.repaint();*/
  if(l<29)
  {
   cx=txy[l][0];
   cy=txy[l][1];
   txy[l][2]=1;
   col=new Color(0,255,0);
   ca1.repaint();
   startindex=l;
  }
  //System.out.println(startindex);
 }
 public void setalgo()
 {
  n=1;
  //System.out.println(startindex);
  al.add(startindex);
  txy[startindex][2]=0;
  for(int z=0;z<29;z++)
  if(txy[z][2]==1)
  {
   al.add(z);
   n++;
  }
  result=new int[n+2];
  distance=new int[n][n];
  for(int w=0;w<n;w++)
  for(int q=0;q<n;q++)
  distance[w][q]=-1;
  for(int k=0;k<n-1;k++)
  for(int l=k+1;l<n;l++)
  {
   distance[k][l]=((txy[al.get(k)][0]-txy[al.get(l)][0])*(txy[al.get(k)][0]-txy[al.get(l)][0]))+((txy[al.get(k)][1]-txy[al.get(l)][1])*(txy[al.get(k)][1]-txy[al.get(l)][1]));
   distance[l][k]=((txy[al.get(k)][0]-txy[al.get(l)][0])*(txy[al.get(k)][0]-txy[al.get(l)][0]))+((txy[al.get(k)][1]-txy[al.get(l)][1])*(txy[al.get(k)][1]-txy[al.get(l)][1]));
  }
  result=op.optimal(n,distance);
  /*for(int z=0;z<n+2;z++)
  System.out.println(result[z]);*/
  //System.out.println(al);
 }
 class can4 extends Canvas
 {
  can4(){setSize(650,700);}
  public void paint(Graphics g)
  {
   update(g);
  }
  public void update(Graphics g)
  {
   g.drawImage(resimg,50,0,this);
  }
 }
 public void res()
 {
  Graphics2D g=(Graphics2D)resimg.getGraphics();
  g.setColor(Color.blue);
  for(int l=0;l<n;l++)
   g.fillOval(txy[al.get(l)][0]-7-50,txy[al.get(l)][1]-7,14,14);
  c4.repaint();
  g.setColor(Color.red);
  g.setStroke(new BasicStroke(3));
  for(int l=0;l<n;l++)
  {
   //System.out.println(""+txy[al.get(result[l])][0]);
   g.drawLine(txy[al.get(result[l])][0]-50,txy[al.get(result[l])][1],txy[al.get(result[l+1])][0]-50,txy[al.get(result[l+1])][1]);
   c4.repaint();
   //try{
   //Thread.sleep(500);}catch(Exception e){}
  }
 }
 /*public void disp()
 {
  Graphics2D g=(Graphics2D)resimg.getGraphics();
  g.setColor(Color.red);
  g.setStroke(new BasicStroke(3));
  for(int l=0;l<n;l++)
  {
   //System.out.println(""+txy[al.get(result[l])][0]);
   g.drawLine(txy[al.get(result[l])][0]-50,txy[al.get(result[l])][1],txy[al.get(result[l+1])][0]-50,txy[al.get(result[l+1])][1]);
   c4.repaint();
   try{
   Thread.sleep(500);}catch(Exception e){}
   c4.repaint();
  }
 }*/
 class saveres extends Dialog implements ActionListener
 {
  Label l1;
  TextField t1;
  Button sb;
  saveres(Frame f)
  {
   super(f,"Save As",true);
   l1=new Label("save as");
   t1=new TextField(20);
   sb=new Button("save");
   sb.addActionListener(this);
   add(l1);
   add(t1);
   add(sb);
   setLayout(new FlowLayout());
   setSize(300,100);
  }
  public void actionPerformed(ActionEvent ae)
  {
   try{
   File savefile=new File("C:\\Users\\srinivas\\Desktop\\tspoutput\\"+t1.getText()+".jpg");
   ImageIO.write(resimg,"jpg",savefile);}catch(Exception ee){}
   setVisible(false);
  }
  public void showsave()
  {
   setVisible(true);
  }
 }
}