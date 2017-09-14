import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class maptsp extends Frame implements ActionListener,MouseListener,MouseMotionListener
{
 int x=10,y=10;
 BufferedImage img;
 File file;
 Panel p,p1,p2;
 Button b,b1;
 CardLayout c;
 can ca1;
 maptsp()
 {
  c=new CardLayout();
  try{
  file=new File("map5.jpg");
  img=ImageIO.read(file);}catch(Exception e){}
  p=new Panel();
  p.setLayout(c);
  p1=new Panel();
  b1=new Button("ok");
  b1.addActionListener(this);
  ca1=new can();
  p1.add(b1);
  p1.add(ca1);
  ca1.repaint();
  p1.setLayout(new FlowLayout());
  p2=new Panel();
  p.add(p1);
  p.add(p2);
  add(p);
  setLayout(new GridLayout(1,1));
  setSize(650,700);
  setVisible(true);
  ca1.addMouseListener(this);
  ca1.addMouseMotionListener(this);
 }
 public static void main(String args[])
 {
  maptsp m=new maptsp();
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  if(b==b1)
      c.next(p);
 }
 public void paint(Graphics g)
 {
  g.drawImage(img,50,50,this);
 }
 public void mousePressed(MouseEvent me)
 {
  x=me.getX();
  y=me.getY();
  System.out.println("x="+x+" y="+y);
  ca1.repaint();
 }
 public void mouseReleased(MouseEvent me){}
 public void mouseClicked(MouseEvent me){}
 public void mouseEntered(MouseEvent me){}
 public void mouseExited(MouseEvent me){}
 public void mouseMoved(MouseEvent me){}
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
   g.drawImage(img,50,0,this);
   g.fillOval(x-5,y-5,10,10);
  }
 }
}