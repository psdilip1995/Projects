import java.awt.*;
import java.awt.event.*;
class demo extends Frame implements ActionListener,AdjustmentListener,ItemListener
{
 Color co;
 int x;
 Panel p;
 Button b,b1,b2,b3;
 Scrollbar s;
 Checkbox cb;
 Choice c;
 demo()
 {
  p=new Panel();
  b1=new Button("circle");
  b2=new Button("rectangle");
  b3=new Button("line");
  cb=new Checkbox("color");
  s=new Scrollbar(0,0,1,0,255);
  c=new Choice();
  c.add("black");
  c.add("green");
  c.add("pink");
  c.add("yellow");
  c.add("red");
  c.add("blue");
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  cb.addItemListener(this);
  c.addItemListener(this);
  s.addAdjustmentListener(this);
  setLayout(new BorderLayout());
  add(s,"South");
  p.add(b1);
  p.add(b2);
  p.add(b3);
  p.add(cb);
  p.add(c);
  p.setLayout(new FlowLayout());
  add(p,"North");
  setVisible(true);
  setSize(600,600);
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  repaint();
 }
 public void itemStateChanged(ItemEvent ie)
 {
  String s=(String)ie.getItem();
  if(s.equals("black"))
	co=Color.black;
  if(s.equals("pink"))
	co=Color.pink;
  if(s.equals("green"))
	co=Color.green;
  if(s.equals("yellow"))
	co=Color.yellow;
  if(s.equals("red"))
	co=Color.red;
  if(s.equals("blue"))
	co=Color.blue;
  repaint();
 }
 public void adjustmentValueChanged(AdjustmentEvent ae)
 {
  x=ae.getValue();
  repaint();
 }
 public static void main(String args[])
 {
  demo d=new demo();
 }
 public void paint(Graphics g)
 {
  if(cb.getState())
  {
   g.setColor(co);
   if(b==b1)
	g.fillOval(100,100,x,x);
   if(b==b2)
	g.fillRect(100,100,x,x+40);
   if(b==b3)
	g.drawLine(20,20,x,x+30);
  }
  else
  {
   if(b==b1)
	g.drawOval(100,100,x,x);
   if(b==b2)
	g.drawRect(100,100,x,x+40);
   if(b==b3)
	g.drawLine(20,20,x,x+30);
  }
 }
}