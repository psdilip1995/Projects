import java.awt.*;
import java.awt.event.*;
import java.util.*;
class mine extends Frame implements ActionListener
{
 int flag=0;
 Button b[][],b99;
 ArrayList <Integer>al;
 mine()
 {
  al=new ArrayList<Integer>();
  for(int i=0;i<100;i++)
  al.add(i);
  Collections.shuffle(al);
  for(int i=0;i<10;i++)
  System.out.println(al.get(i));
  b=new Button[10][10];
  for(int i=0;i<10;i++)
  for(int j=0;j<10;j++)
  {
   b[i][j]=new Button();
   b[i][j].setPreferredSize(new Dimension(30,30));
   b[i][j].addActionListener(this);
   b[i][j].setBackground(new Color(100,149,237));
   b[i][j].setBounds(j*30+100,i*30+100,30,30);
   b[i][j].setActionCommand(Integer.toString(i)+""+Integer.toString(j));
   add(b[i][j]);
  }
  b99=new Button();
  add(b99);
  b99.setVisible(false);
  setBackground(new Color(202,225,255));
  setSize(500,500);
  setVisible(true);
 }
 public static void main(String args[])
 {
  mine m=new mine();
 }
 public void actionPerformed(ActionEvent ae)
 {
  Button tb=(Button)ae.getSource();
  tb.setVisible(false);
 }
 public void paint(Graphics g)
 {
  update(g);
 }
 public void update(Graphics g)
 {
  for(int i=0;i<10;i++)
  {
   int temp=al.get(i);
   g.fillOval(((temp%10)*30+105),((temp/10)*30+105),20,20);
  }
  for(int i=0;i<10;i++)
  for(int j=0;j<10;j++)
  {
   g.drawRect(100+i*30,100+j*30,30,30);
  }
 }
}
