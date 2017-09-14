import java.awt.*;
import java.awt.event.*;
class textfield extends Frame implements ActionListener
{
 TextField tf;
 textfield()
 {
  tf=new TextField(20);
  Button b=new Button("ok");
  b.addActionListener(this);
  add(tf);
  add(b);
  setLayout(new FlowLayout());
  setVisible(true);
  setSize(200,200);
 }
 public static void main(String args[])
 {
  textfield t=new textfield();
 }
 public void actionPerformed(ActionEvent ae)
 {
  System.out.println(tf.getText());
 }
}