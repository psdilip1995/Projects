import java.awt.*;
import java.awt.event.*;
import java.applet.*;
//<applet code="kru" height=500 width=500></applet>
public class kru extends Applet implements ActionListener
{
 String s1="",s2="";
 int n,tn,i=1,j=2,w[][],edg[][],parent[],res[][],mincost=0,count=0,ptr=0;
 CardLayout c;
 Panel p,p1,p2,p3;
 TextField t1,t2;
 Button b1,b2,b3;
 Label l1;
 can1 c1;
 public void init()
 {
  p=new Panel();
  p1=new Panel();
  p2=new Panel();
  p3=new Panel();
  c=new CardLayout();
  l1=new Label("enter no. of nodes ");
  t1=new TextField(20);
  b1=new Button("ok");
  b1.addActionListener(this);
  p1.add(l1);
  p1.add(t1);
  p1.add(b1);
  p1.setLayout(new FlowLayout());
  c1=new can1();
  t2=new TextField(20);
  b2=new Button("next");
  b2.addActionListener(this);
  p2.add(c1);
  p2.add(t2);
  p2.add(b2);
  p2.setLayout(new FlowLayout());
  b3=new Button("print");
  b3.addActionListener(this);
  p3.add(b3);
  p3.setLayout(new FlowLayout());
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.setLayout(c);
  add(p);
  setLayout(new GridLayout(1,1));
 }
 public void start(){}
 public void run(){}
 public void stop(){}
 public void actionPerformed(ActionEvent e)
 {
  Button b=(Button)e.getSource();
  if(b==b1)
  {
   int temp=Integer.parseInt(t1.getText());
   if(temp>2)
   {
    n=temp;
	w=new int[n][n];
	parent=new int[n+1];
	res=new int[n][2];
	edg=new int[n*(n-1)/2][3];
	for(int l=0;l<n+1;l++)
	parent[l]=-1;
	for(int l=0;l<n;l++)
	for(int k=0;k<n;k++)
	w[l][k]=-1;
	tn=n*(n-1)/2;
    c.next(p);
    //System.out.println(""+n);
	s1="enter distance between 1 & 2";
   }
  }
  if(b==b2)
  {
   if(tn>1)
   {
    int temp=Integer.parseInt(t2.getText());
	w[i-1][j-1]=temp;
	w[j-1][i-1]=temp;
	t2.setText("");
	tn--;
	j++;
	if(j>n)
	{
	 i++;
	 j=i+1;
	}
	s1="enter distance between "+i+" and "+j;
	c1.repaint();
   }
   else
   {
    int temp=Integer.parseInt(t2.getText());
	w[i-1][j-1]=temp;
	w[j-1][i-1]=temp;
    c.next(p);
    //int count=0;
    for(int q=0;q<n-1;q++)
    for(int z=q+1;z<n;z++)
    {
	 if(w[q][z]>=0)
	 {
      edg[count][0]=w[q][z];
      edg[count][1]=q+1;
      edg[count][2]=z+1;
      count++;
	 }
    }
	//System.out.println("count : "+count);
    int value0,value1,value2,hole;
    for(int l=1;l<count;l++)
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
  if(b==b3)
  {
   for(int l=0;l<n;l++)
   {
   for(int k=0;k<n;k++)
   System.out.print(" "+w[l][k]);
   System.out.println("\n");
   }
   for(int l=0;l<(n*(n-1)/2);l++)
   System.out.println("edges : "+edg[l][0]+" "+edg[l][1]+" "+edg[l][2]);
   System.out.println("\nresult\n");
   for(int l=0;l<n;l++)
   System.out.println(""+res[l][0]+" "+res[l][1]);
   System.out.println("\nmincost : "+mincost);
   }
 }
 class can1 extends Canvas
 {
  can1(){setSize(250,30);}
  public void paint(Graphics g)
  {
   g.drawString(s1,10,20);
  }
 }
 public void kruskal()
 {
  int l=0,temp;
  while(l<n-1 && ptr<count)
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