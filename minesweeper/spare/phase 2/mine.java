import java.awt.*;
import java.awt.event.*;
import java.util.*;
class mine extends Frame implements ActionListener
{
 int flag=0;
 int bomb[][];
 Button b[][],b99;
 ArrayList <Integer>al;
 mine()
 {
  bomb=new int[10][10];
  al=new ArrayList<Integer>();
  for(int i=0;i<100;i++)
  al.add(i);
  Collections.shuffle(al);
  for(int i=0;i<10;i++)
  {
   System.out.println(al.get(i));
   bomb[(al.get(i))/10][(al.get(i))%10]=-1;
  }
  setbomb();
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
  String temp=ae.getActionCommand();
  int tt=Integer.parseInt(temp);
  tb.setVisible(false);
  if(bomb[tt/10][tt%10]==-1)
  System.out.println("GameOver");
  if(bomb[tt/10][tt%10]==0)
  play(tt);
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
   if(bomb[i][j]!=-1 && bomb[i][j]!=0)
   {
    g.drawString(Integer.toString(bomb[i][j]),110+j*30,118+i*30);
   }
  }
 }
 void setbomb()
 {
  for(int x=0;x<10;x++)
  for(int y=0;y<10;y++)
  {
   int nob=0;
   if(bomb[x][y]!=-1)
   {
		if(x-1>=0 && y-1>=0)
		 if(bomb[x-1][y-1]==-1)
		  nob++;
		if(x-1>=0)
		 if(bomb[x-1][y]==-1)
		  nob++;
		if(y-1>=0)
		 if(bomb[x][y-1]==-1)
		  nob++;
		if(x+1<10 && y-1>=0)
		 if(bomb[x+1][y-1]==-1)
		  nob++;
		if(x+1<10)
		 if(bomb[x+1][y]==-1)
		  nob++;
		if(x-1>=0 && y+1<10)
		 if(bomb[x-1][y+1]==-1)
		  nob++;
		if(y+1<10)
		 if(bomb[x][y+1]==-1)
		  nob++;
		if(x+1<10 && y+1<10)
		 if(bomb[x+1][y+1]==-1)
		  nob++;
		bomb[x][y]=nob;
   }
  }
  for(int i=0;i<10;i++)
  {
   for(int j=0;j<10;j++)
   System.out.print(" "+bomb[i][j]);
   System.out.println("\n");
  }
 }
 void play(int tt)
 {
  int ox=tt%10;
  int oy=tt/10;
  int tx=ox;
  int ty=oy;
   while(bomb[ty][tx]!=-1 && tx<10)
   {
    b[ty][tx].setVisible(false);
    tx++;
    if(tx==10)
    break;
   }
   tx=ox;
   while(bomb[ty][tx]!=-1 && tx>=0)
   {
    b[ty][tx].setVisible(false);
    tx--;
    if(tx==-1)
    break;
   }
   tx=ox;
   while(bomb[ty][tx]!=-1 && ty<10)
   {
    b[ty][tx].setVisible(false);
	ty++;
	if(ty==10)
	break;
   }
   ty=oy;
   while(bomb[ty][tx]!=-1 && ty>=0)
   {
    b[ty][tx].setVisible(false);
	ty--;
	if(ty==-1)
	break;
   }
   ty=oy;
 }
}
