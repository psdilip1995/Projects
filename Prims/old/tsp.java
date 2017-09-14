import java.applet.*;
import java.awt.*;
import java.awt.event.*;
public class tsp extends Applet implements ActionListener,MouseMotionListener
{
 int i=0,tn,n,x,y;
 String s1,cities[],c2str,c3str;
 can2 c2;
 can3 c3;
 CardLayout c;
 Panel p,p1,p2,p3;
 Label l;
 Button b,b2,b3;
 TextField t1,t2,t3;
 public void init()
 {
  c2=new can2();
  c3=new can3();
  c=new CardLayout();
  p=new Panel();
  p1=new Panel();
  p2=new Panel();
  p3=new Panel();
  l=new Label("enter number of cities");
  t1=new TextField(20);
  t2=new TextField(20);
  t3=new TextField(20);
  b=new Button("submit");
  b2=new Button("ok");
  b3=new Button("ok");
  b.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  addMouseMotionListener(this);
  p1.add(l);
  p1.add(t1);
  p1.add(b);
  p1.setLayout(new FlowLayout());
  p2.add(c2);
  p2.add(t2);
  p2.add(b2);
  p2.setLayout(new FlowLayout());
  //p3.add(c3);
  //p3.add(t3);
  //p3.add(b3);
  //p3.setLayout(new FlowLayout());
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.setLayout(c);
  add(p);
  setLayout(new GridLayout(1,1));
 }
 public void start(){}
 public void run()
 {
  repaint();
 }
 public void stop(){}
 public void paint(Graphics g)
 {
  g.drawString(""+x+" "+y,100,100);
 }
 public void actionPerformed(ActionEvent e)
 {
  Button tb=(Button)e.getSource();
  if(tb==b)
  {
   s1=t1.getText();
   n=Integer.parseInt(s1);
   tn=n;
   cities=new String[n];
   if((!(s1.length()==0)) && n>2)
   {
    c.next(p);
    c2str="enter city "+(i+1);
    c2.repaint();
   }
  }
  if(tb==b2)
  {
   if(t2.getText().length()!=0)
   {
    cities[i]=t2.getText();
    t2.setText("");
    i++;
    tn--;
    if(tn==0)
    {
     c3str="enter distance between "+cities[i]+" and "+cities[i+1];
     c.next(p);
    }
    c2str="enter city "+(i+1);
    c2.repaint();
   }  
  }
  if(tb==b3)
  {
  }
 }
 public void mouseMoved(MouseEvent e)
 {
  x=e.getX();
  y=e.getY();
  repaint();
 }
 public void mouseDragged(MouseEvent e){}
 class can2 extends Canvas
 {
  can2(){setSize(150,30);}
  public void paint(Graphics g){g.drawString(c2str,20,20);}
 }
 class can3 extends Canvas
 {
  can3(){setSize(200,30);}
  public void paint(Graphics g){g.drawString(c3str,20,20);}
 }
}
