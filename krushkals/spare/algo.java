import java.util.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
class algo extends Frame implements MouseListener,ActionListener
{
 ArrayList <Integer>alx;
 ArrayList <Integer>aly;
 can c1=new can();
 can c2=new can();
 can c3=new can();
 Label l1;
 Panel p,p1,p2,p3,p4;
 CardLayout c;
 Button b,b1,b2,b3,b4,b5,b6;
 TextField t1;
 BufferedImage img;
 Graphics imgg;
 int x,y,dx,dy,count=0,count2=0,m=1,n=2,tn,w[][],edg[][],parent[],res[][],mincost=0,cou=0,ptr=0,flag=0;;
 algo()
 {
  alx=new ArrayList<Integer>();
  aly=new ArrayList<Integer>();
  p=new Panel();
  c=new CardLayout();
  p.setLayout(c);
  p1=new Panel();
  b4=new Button("start");
  b4.addActionListener(this);
  p1.add(b4);
  p1.setLayout(new FlowLayout());
  p2=new Panel();
  b1=new Button("add node");
  b2=new Button("delete node");
  b3=new Button("ok");
  b1.addActionListener(this);
  b2.addActionListener(this);
  b3.addActionListener(this);
  c1.addMouseListener(this);
  p2.add(b1);
  p2.add(b2);
  p2.add(b3);
  p2.add(c1);
  p2.setLayout(new FlowLayout());
  p3=new Panel();
  l1=new Label("enter distance");
  t1=new TextField(20);
  b5=new Button("next");
  b5.addActionListener(this);
  p3.add(l1);
  p3.add(t1);
  p3.add(b5);
  p3.add(c2);
  p3.setLayout(new FlowLayout());
  p4=new Panel();
  b6=new Button("next");
  b6.addActionListener(this);
  p4.add(b6);
  p4.add(c3);
  p4.setLayout(new FlowLayout());
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.add(p4);
  add(p);
  addMouseListener(this);
  setSize(500,500);
  setVisible(true);
  setLayout(new GridLayout(1,1));
 }
 public static void main(String args[])
 {
  algo a=new algo();
 }
 public void mouseEntered(MouseEvent e){}
 public void mouseExited(MouseEvent e){}
 public void mouseClicked(MouseEvent e){}
 public void mousePressed(MouseEvent e)
 {
  x=e.getX();
  y=e.getY();
  repaint();
 }
 public void mouseReleased(MouseEvent e){}
 public void paint(Graphics g)
 {
  update(g);
 }
 public void update(Graphics g)
 {
  if(b==b1)
  {
   alx.add(x);
   aly.add(y);
   count++;
   imgg.setColor(Color.black);
   imgg.fillOval(x-20,y-20,40,40);
   c1.repaint();
  }
  if(b==b2)
  {
   fin();
   imgg.setColor(Color.white);
   imgg.fillOval(dx-20,dy-20,40,40);
   c1.repaint();
  }
  if(b==b3)
  {
   imgg.setColor(Color.white);
   for(int i=0;i<count;i++)
   imgg.drawString(""+(i+1),alx.get(i),aly.get(i));
   c2.repaint();
  }
  if(b==b5)
  {
   c2.repaint();
  }
  if(b==b6)
  {
   if(count2<count-1)
   {
    //System.out.println(""+res[count2][0]+" "+res[count2][1]+" w[][]= "+w[res[count2][0]][res[count2][1]]);
    imgg.setColor(Color.black);
	imgg.drawLine(alx.get(res[count2][0]-1),aly.get(res[count2][0]-1),alx.get(res[count2][1]-1),aly.get(res[count2][1]-1));
	imgg.setColor(Color.blue);
	imgg.drawString(""+(w[res[count2][0]-1][res[count2][1]-1]),(alx.get(res[count2][0]-1)+alx.get(res[count2][1]-1))/2,(aly.get(res[count2][0]-1)+aly.get(res[count2][1]-1))/2);
	count2++;
	c3.repaint();
   }
   else
   {
    b6.setVisible(false);
	c3.repaint();
   }
  }
 }
 public void actionPerformed(ActionEvent e)
 {
  b=(Button)e.getSource();
  if(b==b4)
  {
   img=new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
   imgg=img.getGraphics();
   imgg.setColor(Color.white);
   imgg.fillRect(0,0,500,500);
   c.next(p);
  }
  if(b==b3)
  {
   if(count>2)
   {
    w=new int[count][count];
    parent=new int[count+1];
    res=new int[count][2];
    edg=new int[count*(count-1)/2][3];
    for(int l=0;l<count+1;l++)
    parent[l]=-1;
    for(int l=0;l<count;l++)
    for(int k=0;k<count;k++)
    w[l][k]=-1;
    tn=count*(count-1)/2;
    repaint();
    c.next(p);
   }
   /*try{
   imgg.dispose();
   File file=new File("map.jpg");
   ImageIO.write(img,"jpg",file);}catch(Exception ee){}*/
  }
  if(b==b5)
  {



   if(tn>1)
   {
    //System.out.println(""+m+" "+n);
    int temp=Integer.parseInt(t1.getText());
	w[m-1][n-1]=temp;
	w[n-1][m-1]=temp;
	repaint();
	t1.setText("");
	tn--;
	n++;
	if(n>count)
	{
	 m++;
	 n=m+1;
	}
	//repaint();
   }
   else
   {
    //System.out.println(""+m+" "+n);
    int temp=Integer.parseInt(t1.getText());
	w[m-1][n-1]=temp;
	w[n-1][m-1]=temp;
	flag=1;
    c.next(p);
    //int count=0;
    for(int q=0;q<count-1;q++)
    for(int z=q+1;z<count;z++)
    {
	 if(w[q][z]>=0)
	 {
      edg[cou][0]=w[q][z];
      edg[cou][1]=q+1;
      edg[cou][2]=z+1;
      cou++;
	 }
    }
	//System.out.println("count : "+count);
    int value0,value1,value2,hole;
    for(int l=1;l<cou;l++)
    {
     value0=edg[l][0];
     value1=edg[l][1];
     value2=edg[l][2];
     hole=l;
     while(hole>0 && edg[hole-1][0]>value0)
     {
      edg[hole][0]=edg[hole-1][0];
      edg[hole][1]=edg[hole-1][1];
      edg[hole][2]=edg[hole-1][2];
      hole--;
     }
     edg[hole][0]=value0;
     edg[hole][1]=value1;
     edg[hole][2]=value2;
    }
    kruskal();
   }
  }
      if(b==b6)
	{
	 /*for(int l=0;l<count;l++)
     {
      for(int k=0;k<count;k++)
      System.out.print(" "+w[l][k]);
      System.out.println("\n");
     }
     for(int l=0;l<(count*(count-1)/2);l++)
     System.out.println("edges : "+edg[l][0]+" "+edg[l][1]+" "+edg[l][2]);
     System.out.println("\nresult\n");
     for(int l=0;l<count-1;l++)
     System.out.println(""+res[l][0]+" "+res[l][1]);
     System.out.println("\nmincost : "+mincost);*/
	 repaint();
	}
 }
 class can extends Canvas
 {
  can(){setSize(500,500);}
  public void paint(Graphics g)
  {
   g.drawImage(img,0,0,this);
   if((b==b3 || b==b5) && flag==0)
   {
    g.setColor(Color.blue);
    g.drawLine(alx.get(m-1),aly.get(m-1),alx.get(n-1),aly.get(n-1));
   }
   if(b==b6)
   {
    g.drawImage(img,0,0,this);
	if(count2 == count-1)
	g.drawString("minimum spanning tree",10,400);
   }
  }
 }
 public void fin()
 {
  Color c=new Color(img.getRGB(x,y));
  if(c.getRed()==0 && c.getBlue()==0 && c.getGreen()==0)
  {
   for(int i=0;i<count;i++)
   if((((x-alx.get(i))*(x-alx.get(i)))+((y-aly.get(i))*(y-aly.get(i))))<400)
   {
    dx=alx.get(i);
    dy=aly.get(i);
    count--;
    alx.remove(i);
    aly.remove(i);
    break;
   }
  }
  else
  {
   dx=600;
   dy=600;
  }
 }


 public void kruskal()
 {
  int l=0,temp;
  while(l<count-1 && ptr<cou)
  {
   temp=edg[ptr][0];
   if(find(edg[ptr][1])!=find(edg[ptr][2]))
   {
	res[l][0]=edg[ptr][1];
	res[l][1]=edg[ptr][2];
	mincost+=temp;
	union(edg[ptr][1],edg[ptr][2]);
	l++;
   }
   ptr++;
  }
  if(l!=n-1)
  System.out.println("no spanning tree");
 }
 public void union(int g,int h)
 {
  parent[g]=h;
 }
 public int find(int d)
 {
  while(parent[d]>=0)
  d=parent[d];
  return d;
 }


}