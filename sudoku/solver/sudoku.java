import java.awt.*;
import java.awt.event.*;
import java.util.*;
class sudoku extends Frame implements ActionListener,MouseListener,MouseMotionListener,KeyListener
{
 ArrayList <Integer>box1=new ArrayList<Integer>();
 ArrayList <Integer>box2=new ArrayList<Integer>();
 ArrayList <Integer>box3=new ArrayList<Integer>();
 ArrayList <Integer>box4=new ArrayList<Integer>();
 ArrayList <Integer>box5=new ArrayList<Integer>();
 ArrayList <Integer>box6=new ArrayList<Integer>();
 ArrayList <Integer>box7=new ArrayList<Integer>();
 ArrayList <Integer>box8=new ArrayList<Integer>();
 ArrayList <Integer>box9=new ArrayList<Integer>();
 ArrayList <Integer>col1=new ArrayList<Integer>();
 ArrayList <Integer>col2=new ArrayList<Integer>();
 ArrayList <Integer>col3=new ArrayList<Integer>();
 ArrayList <Integer>col4=new ArrayList<Integer>();
 ArrayList <Integer>col5=new ArrayList<Integer>();
 ArrayList <Integer>col6=new ArrayList<Integer>();
 ArrayList <Integer>col7=new ArrayList<Integer>();
 ArrayList <Integer>col8=new ArrayList<Integer>();
 ArrayList <Integer>col9=new ArrayList<Integer>();
 ArrayList <Integer>row1=new ArrayList<Integer>();
 ArrayList <Integer>row2=new ArrayList<Integer>();
 ArrayList <Integer>row3=new ArrayList<Integer>();
 ArrayList <Integer>row4=new ArrayList<Integer>();
 ArrayList <Integer>row5=new ArrayList<Integer>();
 ArrayList <Integer>row6=new ArrayList<Integer>();
 ArrayList <Integer>row7=new ArrayList<Integer>();
 ArrayList <Integer>row8=new ArrayList<Integer>();
 ArrayList <Integer>row9=new ArrayList<Integer>();
 Panel p;
 Button b;
 int start=0,sx=0,sy=0,sxo=0,syo=0,px=0,py=0,pxo=0,pyo=0,count=0,ocount=0;
 int[][] value=new int[10][10];
 int [][][]box=new int[9][3][3];
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
  repaint();
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
  if(k==10)
  {
   /*for(int i=0;i<10;i++)
   {
    for(int j=0;j<10;j++)
    System.out.print("  "+value[i][j]);
    System.out.print("\n");
   }*/
   solve();
  }
  else if(k==37)
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
   if(value[py/50][px/50]==0)
   {
    String s="";
	s=s+ke.getKeyChar();
    value[py/50][px/50]=Integer.parseInt(s);
	count++;
	Graphics g=getGraphics();
	g.drawString(""+s,px+20,py+20);
   }
  }
  else if(k==8)
  {
   if(value[py/50][px/50]!=0)
   {
    String s="";
	value[py/50][px/50]=0;
	count--;
	Graphics g=getGraphics();
	g.setColor(Color.white);
	g.fillRect(px+5,py+5,40,40);
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
 public void solve()
 {
  load();
  System.out.println(count);
  ocount=count;
  count=81-ocount;
  int temp1=count,temp2=count,temp3=count,temp11,temp21,temp31;
  do
  //while(count!=0)
  {
   temp1=count;
   do
   {
    temp2=count;
    completebox1();
    completebox2();
    completebox3();
    completebox4();
    completebox5();
    completebox6();
    completebox7();
    completebox8();
    completebox9();
   }while(count<temp2);
   do
   {
    temp3=count;
	altsolve();
   }while(count<temp3);
  }while(count<temp1);
  printans();
 }
 public void load()
 {
  System.out.println("entering load");
  for(int i=1;i<4;i++)
  for(int j=1;j<4;j++)
  {
   box[0][i-1][j-1]=value[i][j];
   if(value[i][j]!=0)
   box1.add(value[i][j]);
  }
  for(int i=1;i<4;i++)
  for(int j=4;j<7;j++)
  {
   box[1][i-1][j-4]=value[i][j];
   if(value[i][j]!=0)
   box2.add(value[i][j]);
  }
  for(int i=1;i<4;i++)
  for(int j=7;j<10;j++)
  {
   box[2][i-1][j-7]=value[i][j];
   if(value[i][j]!=0)
   box3.add(value[i][j]);
  }
  for(int i=4;i<7;i++)
  for(int j=1;j<4;j++)
  {
   box[3][i-4][j-1]=value[i][j];
   if(value[i][j]!=0)
   box4.add(value[i][j]);
  }
  for(int i=4;i<7;i++)
  for(int j=4;j<7;j++)
  {
   box[4][i-4][j-4]=value[i][j];
   if(value[i][j]!=0)
   box5.add(value[i][j]);
  }
  for(int i=4;i<7;i++)
  for(int j=7;j<10;j++)
  {
   box[5][i-4][j-7]=value[i][j];
   if(value[i][j]!=0)
   box6.add(value[i][j]);
  }
  for(int i=7;i<10;i++)
  for(int j=1;j<4;j++)
  {
   box[6][i-7][j-1]=value[i][j];
   if(value[i][j]!=0)
   box7.add(value[i][j]);
  }
  for(int i=7;i<10;i++)
  for(int j=4;j<7;j++)
  {
   box[7][i-7][j-4]=value[i][j];
   if(value[i][j]!=0)
   box8.add(value[i][j]);
  }
  for(int i=7;i<10;i++)
  for(int j=7;j<10;j++)
  {
   box[8][i-7][j-7]=value[i][j];
   if(value[i][j]!=0)
   box9.add(value[i][j]);
  }
  for(int i=1;i<10;i++)
  if(value[1][i]!=0)
  row1.add(value[1][i]);
  for(int i=1;i<10;i++)
  if(value[2][i]!=0)
  row2.add(value[2][i]);
  for(int i=1;i<10;i++)
  if(value[3][i]!=0)
  row3.add(value[3][i]);
  for(int i=1;i<10;i++)
  if(value[4][i]!=0)
  row4.add(value[4][i]);
  for(int i=1;i<10;i++)
  if(value[5][i]!=0)
  row5.add(value[5][i]);
  for(int i=1;i<10;i++)
  if(value[6][i]!=0)
  row6.add(value[6][i]);
  for(int i=1;i<10;i++)
  if(value[7][i]!=0)
  row7.add(value[7][i]);
  for(int i=1;i<10;i++)
  if(value[8][i]!=0)
  row8.add(value[8][i]);
  for(int i=1;i<10;i++)
  if(value[9][i]!=0)
  row9.add(value[9][i]);
  //now cols
  for(int i=1;i<10;i++)
  if(value[i][1]!=0)
  col1.add(value[i][1]);
  for(int i=1;i<10;i++)
  if(value[i][2]!=0)
  col2.add(value[i][2]);
  for(int i=1;i<10;i++)
  if(value[i][3]!=0)
  col3.add(value[i][3]);
  for(int i=1;i<10;i++)
  if(value[i][4]!=0)
  col4.add(value[i][4]);
  for(int i=1;i<10;i++)
  if(value[i][5]!=0)
  col5.add(value[i][5]);
  for(int i=1;i<10;i++)
  if(value[i][6]!=0)
  col6.add(value[i][6]);
  for(int i=1;i<10;i++)
  if(value[i][7]!=0)
  col7.add(value[i][7]);
  for(int i=1;i<10;i++)
  if(value[i][8]!=0)
  col8.add(value[i][8]);
  for(int i=1;i<10;i++)
  if(value[i][9]!=0)
  col9.add(value[i][9]);
  System.out.println("exiting load");
 }
 public void completebox1()
 {
  System.out.println("gng into 1");
  for(int i=1;i<10;i++)
  {
   if(	value[1][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[1][1]=i;
	col1.add(i);
	row1.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[1][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[1][2]=i;
	col2.add(i);
	row1.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[1][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[1][3]=i;
	col3.add(i);
	row1.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[2][1]=i;
	col1.add(i);
	row2.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[2][2]=i;
	col2.add(i);
	row2.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[2][3]=i;
	col3.add(i);
	row2.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[3][1]=i;
	col1.add(i);
	row3.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[3][2]=i;
	col2.add(i);
	row3.add(i);
	box1.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box1.indexOf(i)==-1	)
   {
    value[3][3]=i;
	col3.add(i);
	row3.add(i);
	box1.add(i);
	count--;
   }
  }
 }
 public void completebox2()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[1][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[1][4]=i;
	col4.add(i);
	row1.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[1][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[1][5]=i;
	col5.add(i);
	row1.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[1][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[1][6]=i;
	col6.add(i);
	row1.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[2][4]=i;
	col4.add(i);
	row2.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[2][5]=i;
	col5.add(i);
	row2.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[2][6]=i;
	col6.add(i);
	row2.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[3][4]=i;
	col4.add(i);
	row3.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[3][5]=i;
	col5.add(i);
	row3.add(i);
	box2.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box2.indexOf(i)==-1	)
   {
    value[3][6]=i;
	col6.add(i);
	row3.add(i);
	box2.add(i);
	count--;
   }
  }
 }
 public void completebox3()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[1][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[1][7]=i;
	col7.add(i);
	row1.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[1][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[1][8]=i;
	col8.add(i);
	row1.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[1][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[1][9]=i;
	col9.add(i);
	row1.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[2][7]=i;
	col7.add(i);
	row2.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[2][8]=i;
	col8.add(i);
	row2.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[2][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	row3.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[2][9]=i;
	col9.add(i);
	row2.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[3][7]=i;
	col7.add(i);
	row3.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[3][8]=i;
	col8.add(i);
	row3.add(i);
	box3.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[3][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row2.indexOf(i)!=-1	&&	row1.indexOf(i)!=-1	&&	box3.indexOf(i)==-1	)
   {
    value[3][9]=i;
	col9.add(i);
	row3.add(i);
	box3.add(i);
	count--;
   }
  }
 }
 public void completebox4()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[4][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[4][1]=i;
	col1.add(i);
	row4.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[4][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[4][2]=i;
	col2.add(i);
	row4.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[4][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[4][3]=i;
	col3.add(i);
	row4.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[5][1]=i;
	col1.add(i);
	row5.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[5][2]=i;
	col2.add(i);
	row5.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[5][3]=i;
	col3.add(i);
	row5.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[6][1]=i;
	col1.add(i);
	row6.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[6][2]=i;
	col2.add(i);
	row6.add(i);
	box4.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box4.indexOf(i)==-1	)
   {
    value[6][3]=i;
	col3.add(i);
	row6.add(i);
	box4.add(i);
	count--;
   }
  }
 }
 public void completebox5()
 {
 for(int i=1;i<10;i++)
  {
   if(	value[4][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[4][4]=i;
	col4.add(i);
	row4.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[4][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[4][5]=i;
	col5.add(i);
	row4.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[4][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[4][6]=i;
	col6.add(i);
	row4.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[5][4]=i;
	col4.add(i);
	row5.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[5][5]=i;
	col5.add(i);
	row5.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[5][6]=i;
	col6.add(i);
	row5.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[6][4]=i;
	col4.add(i);
	row6.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[6][5]=i;
	col5.add(i);
	row6.add(i);
	box5.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box5.indexOf(i)==-1	)
   {
    value[6][6]=i;
	col6.add(i);
	row6.add(i);
	box5.add(i);
	count--;
   }
  }
 }
 public void completebox6()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[4][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[4][7]=i;
	col7.add(i);
	row4.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[4][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[4][8]=i;
	col8.add(i);
	row4.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[4][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[4][9]=i;
	col9.add(i);
	row4.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[5][7]=i;
	col7.add(i);
	row5.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[5][8]=i;
	col8.add(i);
	row5.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[5][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row6.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[5][9]=i;
	col9.add(i);
	row5.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[6][7]=i;
	col7.add(i);
	row6.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[6][8]=i;
	col8.add(i);
	row6.add(i);
	box6.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[6][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row4.indexOf(i)!=-1	&&	row5.indexOf(i)!=-1	&&	box6.indexOf(i)==-1	)
   {
    value[6][9]=i;
	col9.add(i);
	row6.add(i);
	box6.add(i);
	count--;
   }
  }
 }
 public void completebox7()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[7][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[7][1]=i;
	col1.add(i);
	row7.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[7][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[7][2]=i;
	col2.add(i);
	row7.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[7][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[7][3]=i;
	col3.add(i);
	row7.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[8][1]=i;
	col1.add(i);
	row8.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[8][2]=i;
	col2.add(i);
	row8.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[8][3]=i;
	col3.add(i);
	row8.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][1]==0	&&	col2.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[9][1]=i;
	col1.add(i);
	row9.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][2]==0	&&	col1.indexOf(i)!=-1	&&	col3.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[9][2]=i;
	col2.add(i);
	row9.add(i);
	box7.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][3]==0	&&	col2.indexOf(i)!=-1	&&	col1.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box7.indexOf(i)==-1	)
   {
    value[9][3]=i;
	col3.add(i);
	row9.add(i);
	box7.add(i);
	count--;
   }
  }
 }
 public void completebox8()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[7][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[7][4]=i;
	col4.add(i);
	row7.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[7][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[7][5]=i;
	col5.add(i);
	row7.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[7][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[7][6]=i;
	col6.add(i);
	row7.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[8][4]=i;
	col4.add(i);
	row8.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[8][5]=i;
	col5.add(i);
	row8.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[8][6]=i;
	col6.add(i);
	row8.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][4]==0	&&	col5.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[9][4]=i;
	col4.add(i);
	row9.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][5]==0	&&	col4.indexOf(i)!=-1	&&	col6.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[9][5]=i;
	col5.add(i);
	row9.add(i);
	box8.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][6]==0	&&	col4.indexOf(i)!=-1	&&	col5.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box8.indexOf(i)==-1	)
   {
    value[9][6]=i;
	col6.add(i);
	row9.add(i);
	box8.add(i);
	count--;
   }
  }
 }
 public void completebox9()
 {
  for(int i=1;i<10;i++)
  {
   if(	value[7][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[7][7]=i;
	col7.add(i);
	row7.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[7][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[7][8]=i;
	col8.add(i);
	row7.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[7][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[7][9]=i;
	col9.add(i);
	row7.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[8][7]=i;
	col7.add(i);
	row8.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[8][8]=i;
	col8.add(i);
	row8.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[8][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row9.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[8][9]=i;
	col9.add(i);
	row8.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][7]==0	&&	col8.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[9][7]=i;
	col7.add(i);
	row9.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][8]==0	&&	col7.indexOf(i)!=-1	&&	col9.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[9][8]=i;
	col8.add(i);
	row9.add(i);
	box9.add(i);
	count--;
   }
  }
  for(int i=1;i<10;i++)
  {
   if(	value[9][9]==0	&&	col7.indexOf(i)!=-1	&&	col8.indexOf(i)!=-1	&&	row7.indexOf(i)!=-1	&&	row8.indexOf(i)!=-1	&&	box9.indexOf(i)==-1	)
   {
    value[9][9]=i;
	col9.add(i);
	row9.add(i);
	box9.add(i);
	count--;
   }
  }
 }
 public void altsolve()
 {
  int tempnum=0;
  if(box1.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box1.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<4;i++)
   for(int j=1;j<4;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box1.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box2.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box2.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<4;i++)
   for(int j=4;j<7;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box2.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box3.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box3.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<4;i++)
   for(int j=7;j<10;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box3.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box4.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box4.indexOf(i)==-1)
   tempnum=i;
   for(int i=4;i<7;i++)
   for(int j=1;j<4;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box4.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box5.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box5.indexOf(i)==-1)
   tempnum=i;
   for(int i=4;i<7;i++)
   for(int j=4;j<7;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box5.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box6.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box6.indexOf(i)==-1)
   tempnum=i;
   for(int i=4;i<7;i++)
   for(int j=7;j<10;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box6.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box7.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box7.indexOf(i)==-1)
   tempnum=i;
   for(int i=7;i<10;i++)
   for(int j=1;j<4;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box7.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box8.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box8.indexOf(i)==-1)
   tempnum=i;
   for(int i=7;i<10;i++)
   for(int j=4;j<7;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box8.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(box9.size()==8)
  {
   for(int i=1;i<10;i++)
   if(box9.indexOf(i)==-1)
   tempnum=i;
   for(int i=7;i<10;i++)
   for(int j=7;j<10;j++)
   if(value[i][j]==0)
   {
    value[i][j]=tempnum;
	count--;
	box9.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	switch(j)
	{
	 case 1:col1.add(j);break;
	 case 2:col2.add(j);break;
	 case 3:col3.add(j);break;
	 case 4:col4.add(j);break;
	 case 5:col5.add(j);break;
	 case 6:col6.add(j);break;
	 case 7:col7.add(j);break;
	 case 8:col8.add(j);break;
	 case 9:col9.add(j);break;
	}
   }
  }
  if(col1.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col1.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][1]==0)
   {
    value[i][1]=tempnum;
	count--;
	col1.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box1.add(i);
	else if(i<7)
		box4.add(i);
	else if(i<10)
		box7.add(i);
   }
  }
  if(col2.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col2.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][2]==0)
   {
    value[i][2]=tempnum;
	count--;
	col2.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box1.add(i);
	else if(i<7)
		box4.add(i);
	else if(i<10)
		box7.add(i);
   }
  }
  if(col3.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col3.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][3]==0)
   {
    value[i][3]=tempnum;
	count--;
	col3.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box1.add(i);
	else if(i<7)
		box4.add(i);
	else if(i<10)
		box7.add(i);
   }
  }
  if(col4.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col4.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][4]==0)
   {
    value[i][4]=tempnum;
	count--;
	col4.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box2.add(i);
	else if(i<7)
		box5.add(i);
	else if(i<10)
		box8.add(i);
   }
  }
  if(col5.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col5.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][5]==0)
   {
    value[i][5]=tempnum;
	count--;
	col5.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box2.add(i);
	else if(i<7)
		box5.add(i);
	else if(i<10)
		box8.add(i);
   }
  }
  if(col6.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col6.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][6]==0)
   {
    value[i][6]=tempnum;
	count--;
	col6.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box2.add(i);
	else if(i<7)
		box5.add(i);
	else if(i<10)
		box8.add(i);
   }
  }
  if(col7.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col7.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][7]==0)
   {
    value[i][7]=tempnum;
	count--;
	col7.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box3.add(i);
	else if(i<7)
		box6.add(i);
	else if(i<10)
		box9.add(i);
   }
  }
  if(col8.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col8.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][8]==0)
   {
    value[i][8]=tempnum;
	count--;
	col8.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box3.add(i);
	else if(i<7)
		box6.add(i);
	else if(i<10)
		box9.add(i);
   }
  }
  if(col9.size()==8)
  {
   for(int i=1;i<10;i++)
   if(col9.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[i][9]==0)
   {
    value[i][9]=tempnum;
	count--;
	col9.add(i);
	switch(i)
	{
	 case 1:row1.add(i);break;
	 case 2:row2.add(i);break;
	 case 3:row3.add(i);break;
	 case 4:row4.add(i);break;
	 case 5:row5.add(i);break;
	 case 6:row6.add(i);break;
	 case 7:row7.add(i);break;
	 case 8:row8.add(i);break;
	 case 9:row9.add(i);break;
	}
	if(i<4)
		box3.add(i);
	else if(i<7)
		box6.add(i);
	else if(i<10)
		box9.add(i);
   }
  }
  if(row1.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row1.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[1][i]==0)
   {
    value[1][i]=tempnum;
	count--;
	row1.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box1.add(i);
	else if(i<7)
		box2.add(i);
	else if(i<10)
		box3.add(i);
   }
  }
  if(row2.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row2.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[2][i]==0)
   {
    value[2][i]=tempnum;
	count--;
	row2.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box1.add(i);
	else if(i<7)
		box2.add(i);
	else if(i<10)
		box3.add(i);
   }
  }
  if(row3.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row3.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[3][i]==0)
   {
    value[3][i]=tempnum;
	count--;
	row3.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box1.add(i);
	else if(i<7)
		box2.add(i);
	else if(i<10)
		box3.add(i);
   }
  }
  if(row4.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row4.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[4][i]==0)
   {
    value[4][i]=tempnum;
	count--;
	row4.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box4.add(i);
	else if(i<7)
		box5.add(i);
	else if(i<10)
		box6.add(i);
   }
  }
  if(row5.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row5.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[5][i]==0)
   {
    value[5][i]=tempnum;
	count--;
	row5.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box4.add(i);
	else if(i<7)
		box5.add(i);
	else if(i<10)
		box6.add(i);
   }
  }
  if(row6.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row6.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[6][i]==0)
   {
    value[6][i]=tempnum;
	count--;
	row6.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box4.add(i);
	else if(i<7)
		box5.add(i);
	else if(i<10)
		box6.add(i);
   }
  }
  if(row7.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row7.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[7][i]==0)
   {
    value[7][i]=tempnum;
	count--;
	row7.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box7.add(i);
	else if(i<7)
		box8.add(i);
	else if(i<10)
		box9.add(i);
   }
  }
  if(row8.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row8.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[8][i]==0)
   {
    value[8][i]=tempnum;
	count--;
	row8.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box7.add(i);
	else if(i<7)
		box8.add(i);
	else if(i<10)
		box9.add(i);
   }
  }
  if(row9.size()==8)
  {
   for(int i=1;i<10;i++)
   if(row9.indexOf(i)==-1)
   tempnum=i;
   for(int i=1;i<10;i++)
   if(value[9][i]==0)
   {
    value[9][i]=tempnum;
	count--;
	row9.add(i);
	switch(i)
	{
	 case 1:col1.add(i);break;
	 case 2:col2.add(i);break;
	 case 3:col3.add(i);break;
	 case 4:col4.add(i);break;
	 case 5:col5.add(i);break;
	 case 6:col6.add(i);break;
	 case 7:col7.add(i);break;
	 case 8:col8.add(i);break;
	 case 9:col9.add(i);break;
	}
	if(i<4)
		box7.add(i);
	else if(i<7)
		box8.add(i);
	else if(i<10)
		box9.add(i);
   }
  }
  //a
 }
 public void printans()
 {
  for(int i=1;i<10;i++)
  {
   for(int j=1;j<10;j++)
    System.out.print("  "+value[i][j]);
   System.out.println("\n");
  }
 }
}