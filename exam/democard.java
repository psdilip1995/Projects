import java.awt.*;
import java.awt.event.*;
class democard extends Frame implements ActionListener
{
 CardLayout cl;
 Panel p,p1,p2;
 Button b,b1,b2,b3,b4,b5;
 democard()
 {
  p=new Panel();
  p1=new Panel();
  p2=new Panel();
  p2.setLayout(new BorderLayout());
  cl=new CardLayout();
  b5=new Button("back");
  b1=new Button("circle");
  b2=new Button("Oval");
  b3=new Button("Rectangle");
  b4=new Button("Line");
  b5.addActionListener(this);
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  b4.addActionListener(this);
  p1.add(b1);
  p1.add(b2);
  p1.add(b3);
  p1.add(b4);
  p2.add(b5,"North");
  p2.add(new mycan(),"Center");
  p1.setLayout(new GridLayout(2,2));
  p.add(p1);
  p.add(p2);
  p1.setVisible(true);
  p2.setVisible(true);
  p.setVisible(true);
  p.setLayout(cl);
  add(p);
  setLayout(new GridLayout(1,1));
  setVisible(true);
  setSize(400,400);
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  cl.next(p);
 }
 public static void main(String args[])
 {
  democard d=new democard();
 }
 class mycan extends Canvas
 {
  mycan()
  {
   setBackground(Color.white);
   setSize(300,300);
  }
  public void paint(Graphics g)
  {
  if(b==b1)
	g.drawOval(100,100,200,200);
  if(b==b2)
	g.drawOval(100,100,200,100);
  if(b==b3)
	g.drawRect(100,100,200,200);
  if(b==b4)
	g.drawLine(100,100,300,300);
  //if(b==b5)
	//g.drawLine(0,0,0,0);
  }
 }
}