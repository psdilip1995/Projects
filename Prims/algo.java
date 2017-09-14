import optimal.*;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
//<applet code="algo" width=700 height=600></applet>
public class algo extends Applet implements MouseListener,ActionListener
{
 opt o;
 ArrayList <Integer>alx;
 ArrayList <Integer>aly;
 can c1=new can();
 can c2=new can();
 can c3=new can();
 Label l1,l2;
 Panel p,p1,p2,p3,p4;
 CardLayout c;
 Button b,b1,b2,b3,b4,b5,b6;
 TextField t1;
 BufferedImage img;
 Graphics imgg;
 int x,y,dx,dy,count=0,count2=0,m=1,n=2,tn,w[][],res[],mincost=0,flag=0;;
 public void init()
 {
  o=new opt();
  alx=new ArrayList<Integer>();
  aly=new ArrayList<Integer>();
  p=new Panel();
  c=new CardLayout();
  p.setLayout(c);
  p1=new Panel();
  b4=new Button("start");
  b4.addActionListener(this);
  p1.add(b4);
  p1.setLayout(new FlowLayout());
  p2=new Panel();
  l2=new Label("draw the graph here ");
  b1=new Button("add node");
  b2=new Button("delete node");
  b3=new Button("ok");
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  c1.addMouseListener(this);
  p2.add(l2);
  p2.add(b1);
  p2.add(b2);
  p2.add(b3);
  p2.add(c1);
  p2.setLayout(new FlowLayout());
  p3=new Panel();
  l1=new Label("enter distance");
  t1=new TextField(20);
  b5=new Button("next");
  b5.addActionListener(this);
  p3.add(l1);
  p3.add(t1);
  p3.add(b5);
  p3.add(c2);
  p3.setLayout(new FlowLayout());
  p4=new Panel();
  b6=new Button("next");
  b6.addActionListener(this);
  p4.add(b6);
  p4.add(c3);
  p4.setLayout(new FlowLayout());
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.add(p4);
  add(p);
  addMouseListener(this);
  //setSize(500,500);
  setVisible(true);
  setLayout(new GridLayout(1,1));
 }
 public void start(String args[])
 {
 }
 public void run(){}
 public void stop(){}
 public void mouseEntered(MouseEvent e){}
 public void mouseExited(MouseEvent e){}
 public void mouseClicked(MouseEvent e){}
 public void mousePressed(MouseEvent e)
 {
  x=e.getX();
  y=e.getY();
  repaint();
 }
 public void mouseReleased(MouseEvent e){}
 public void paint(Graphics g)
 {
  update(g);
 }
 public void update(Graphics g)
 {
  if(b==b1)
  {
   alx.add(x);
   aly.add(y);
   count++;
   imgg.setColor(Color.black);
   imgg.fillOval(x-20,y-20,40,40);
   c1.repaint();
  }
  if(b==b2)
  {
   fin();
   imgg.setColor(Color.white);
   imgg.fillOval(dx-20,dy-20,40,40);
   c1.repaint();
  }
  if(b==b3)
  {
   imgg.setColor(Color.white);
   for(int i=0;i<count;i++)
   imgg.drawString(""+(i+1),alx.get(i),aly.get(i));
   c2.repaint();
  }
  if(b==b5)
  {
   c2.repaint();
  }
  if(b==b6)
  {
   if(count2<count)
   {
    imgg.setColor(Color.black);
	imgg.drawLine(alx.get(res[count2]),aly.get(res[count2]),alx.get(res[count2+1]),aly.get(res[count2+1]));
	imgg.setColor(Color.red);
	imgg.drawString(""+(count2+1/*w[res[count2]][res[count2+1]]*/),(alx.get(res[count2])+alx.get(res[count2+1]))/2,(aly.get(res[count2])+aly.get(res[count2+1]))/2);
	count2++;
	c3.repaint();
   }
   else
   {
    b6.setVisible(false);
	try{
    imgg.dispose();
    File file=new File("map-output.jpg");
    ImageIO.write(img,"jpg",file);}catch(Exception ee){}
	c3.repaint();
   }
  }
 }
 public void actionPerformed(ActionEvent e)
 {
  b=(Button)e.getSource();
  if(b==b4)
  {
   img=new BufferedImage(700,600,BufferedImage.TYPE_INT_RGB);
   imgg=img.getGraphics();
   imgg.setColor(Color.white);
   imgg.fillRect(0,0,700,600);
   c.next(p);
  }
  if(b==b3)
  {
   if(count>2)
   {
    w=new int[count][count];
    res=new int[count+1];
    for(int l=0;l<count;l++)
    for(int k=0;k<count;k++)
    w[l][k]=-1;
    tn=count*(count-1)/2;
    repaint();
    c.next(p);
   }
  }
  if(b==b5)
  {
   if(tn>1)
   {
    int temp=Integer.parseInt(t1.getText());
	w[m-1][n-1]=temp;
	w[n-1][m-1]=temp;
	repaint();
	t1.setText("");
	tn--;
	n++;
	if(n>count)
	{
	 m++;
	 n=m+1;
	}
   }
   else
   {
    int temp=Integer.parseInt(t1.getText());
	w[m-1][n-1]=temp;
	w[n-1][m-1]=temp;
	flag=1;
	res=o.optimal(count,w);
    c.next(p);
   }
  }
  if(b==b6)
  {
   repaint();
  }
 }
 class can extends Canvas
 {
  can(){setSize(700,600);}
  public void paint(Graphics g)
  {
   g.drawImage(img,0,0,this);
   if((b==b3 || b==b5) && flag==0)
   {
    g.setColor(Color.blue);
    g.drawLine(alx.get(m-1),aly.get(m-1),alx.get(n-1),aly.get(n-1));
   }
   if(b==b6)
   {
    g.drawImage(img,0,0,this);
	if(count2 == count)
	g.drawString("minimum cost : "+res[count+1],10,400);
   }
  }
 }
 public void fin()
 {
  Color c=new Color(img.getRGB(x,y));
  if(c.getRed()==0 && c.getBlue()==0 && c.getGreen()==0)
  {
   for(int i=0;i<count;i++)
   if((((x-alx.get(i))*(x-alx.get(i)))+((y-aly.get(i))*(y-aly.get(i))))<400)
   {
    dx=alx.get(i);
    dy=aly.get(i);
    count--;
    alx.remove(i);
    aly.remove(i);
    break;
   }
  }
  else
  {
   dx=800;
   dy=800;
  }
 }
}