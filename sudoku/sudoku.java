import java.awt.*;
import java.awt.event.*;
import java.util.*;
class sudoku extends Frame implements ActionListener,MouseListener,MouseMotionListener,KeyListener
{
 int start=0,sx=0,sy=0,sxo=0,syo=0,px=0,py=0,pxo=0,pyo=0;
 int[][] value=new int[10][10];
 sudoku()
 {
  for(int i=0;i<10;i++)
  for(int j=0;j<10;j++)
  value[i][j]=0;
  addMouseListener(this);
  addMouseMotionListener(this);
  addKeyListener(this);
  setSize(600,600);
  setVisible(true);
  setResizable(false);
 }
 public static void main(String args[])
 {
  sudoku sudo=new sudoku();
 }
 public void actionPerformed(ActionEvent ae)
 {
 }
 public void mousePressed(MouseEvent me)
 {
 }
 public void mouseReleased(MouseEvent me)
 {
 }
 public void mouseClicked(MouseEvent me)
 {
  int x=me.getX();
  int y=me.getY();
  if(x<500 && y<500 && x>50 && y>50)
  {
   pxo=px;
   pyo=py;
   px=(x/50)*50;
   py=(y/50)*50;
   repaint();
  }
 }
 public void mouseEntered(MouseEvent me)
 {
 }
 public void mouseExited(MouseEvent me)
 {
 }
 public void mouseMoved(MouseEvent me)
 {
  int x=me.getX();
  int y=me.getY();
  if(x<500 && y<500 && x>50 && y>50)
  {
   sxo=sx;
   syo=sy;
   sx=(x/50)*50;
   sy=(y/50)*50;
   repaint();
  }
  else
  {
   sxo=sx;
   syo=sy;
   sx=0;
   sy=0;
   repaint();
  }
 }
 public void mouseDragged(MouseEvent me)
 {
  /*for(int i=0;i<10;i++)
  {
  for(int j=0;j<10;j++)
  System.out.print("  "+value[j][i]);
  System.out.print("\n");
  }*/
 }
 public void keyPressed(KeyEvent ke)
 {
  int k=ke.getKeyCode();
  //System.out.println(k);
  if(k==37)
  {//left
   if(px!=50)
   {
    pxo=px;
	pyo=py;
    px-=50;
	repaint();
   }
  }
  else if(k==38)
  {//up
   if(py!=50)
   {
    pxo=px;
	pyo=py;
	py-=50;
	repaint();
   }
  }
  else if(k==39)
  {//right
   if(px!=450)
   {
    pxo=px;
	pyo=py;
	px+=50;
	repaint();
   }
  }
  else if(k==40)
  {//bottom
   if(py!=450)
   {
    pxo=px;
	pyo=py;
	py+=50;
	repaint();
   }
  }
  else if(k>48 && k<=57)
  {
   if(value[px/50][py/50]==0)
   {
    String s="";
	s=s+ke.getKeyChar();
    value[px/50][py/50]=Integer.parseInt(s);
	Graphics g=getGraphics();
	g.drawString(""+s,px+20,py+20);
   }
  }
 }
 public void keyReleased(KeyEvent ke)
 {
 }
 public void keyTyped(KeyEvent ke)
 {
 }
 public void paint(Graphics g)
 {
  if(start==0)
  {
   g.drawRect(50,50,450,450);
   for(int i=0,x1=100;i<9;i++,x1+=50)
	g.drawLine(x1,50,x1,500);
   for(int i=0,y1=100;i<9;i++,y1+=50)
	g.drawLine(50,y1,500,y1);
   start=1;
  }
  else
   update(g);
 }
 public void update(Graphics g)
 {
  g.drawRect(pxo,pyo,50,50);
  g.drawRect(sxo,syo,50,50);
  g.setColor(Color.green);
  g.drawRect(sx,sy,50,50);
  g.setColor(Color.red);
  g.drawRect(px,py,50,50);
 }
}