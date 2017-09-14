import java.util.*;
import java.awt.*;
import java.awt.event.*;
class demorand extends Frame implements ActionListener
{
 Random r=new Random();
 int x;
 demorand()
 {
  Button b=new Button("generate");
  b.addActionListener(this);
  add(b);
  setLayout(new FlowLayout());
  setVisible(true);
  setSize(200,200);
 }
 public void actionPerformed(ActionEvent ae)
 {
  x=r.nextInt(100);
  repaint();
 }
 public void paint(Graphics g)
 {
  g.drawString(""+x,100,100);
 }
 public static void main(String args[])
 {
  demorand d=new demorand();
 }
}