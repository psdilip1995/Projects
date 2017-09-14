import java.awt.*;
import java.awt.event.*;
class democbox extends Frame implements ItemListener
{
 Checkbox c1,c2;
 democbox()
 {
  c2=new Checkbox("red");
  c1=new Checkbox("pink");
  c1.addItemListener(this);
  c2.addItemListener(this);
  add(c2);
  add(c1);
  setSize(400,400);
  setVisible(true);
  setLayout(new FlowLayout());
 }
 public void itemStateChanged(ItemEvent ie)
 {
  if(ie.getSource()==c1)
  if(c1.getState()==true)
  setBackground(Color.pink);
  else
  setBackground(Color.white);
  if(ie.getSource()==c2)
  setBackground(Color.red);
 }
 public static void main(String args[])
 {
  democbox d=new democbox();
 }
}