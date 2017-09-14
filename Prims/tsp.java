import optimal.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
//<applet code="tsp" height=600 width=700></applet>
public class tsp extends Applet implements ActionListener
{
 int i=0,j=0,k=1,t,tn,n,distance[][],x=10,y=20,result[];
 String s1,cities[],c2str,c3str,c4str;
 CardLayout c;
 Panel p,p1,p2,p3,p4;
 Label l;
 Button b1,b2,b3;
 TextField t1,t2,t3;
 can2 c2;
 can3 c3;
 can4 c4;
 opt o;
 public void init()
 {
  o=new opt();
  c=new CardLayout();
  p=new Panel();
  p1=new Panel();
  p2=new Panel();
  p3=new Panel();
  p4=new Panel();
  l=new Label("enter number of cities : ");
  t1=new TextField(20);
  t2=new TextField(20);
  t2=new TextField(20);
  t3=new TextField(20);
  b1=new Button("submit");
  b1.addActionListener(this);
  b2=new Button("ok");
  b2.addActionListener(this);
  b3=new Button("ok");
  b3.addActionListener(this);
  c2=new can2();
  c3=new can3();
  c4=new can4();
  p1.add(l);
  p1.add(t1);
  p1.add(b1);
  p1.setLayout(new FlowLayout());
  p2.add(c2);
  p2.add(t2);
  p2.add(b2);
  p2.setLayout(new FlowLayout());
  p3.add(c3);
  p3.add(t3);
  p3.add(b3);
  p3.setLayout(new FlowLayout());
  p4.add(c4);
  p4.setLayout(new FlowLayout());
  p.add(p1);
  p.add(p2);
  p.add(p3);
  p.add(p4);
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
   s1=t1.getText();
   n=Integer.parseInt(s1);
   tn=n;
   cities=new String[n];
   result=new int[n+2];
   distance=new int[n][n];
   for(int w=0;w<n;w++)
   for(int q=0;q<n;q++)
   distance[w][q]=-1;
   c2str="enter city "+(i+1)+" (Starting)";
   c2.repaint();
   if(n>2)
   c.next(p);
  }
  if(b==b2)
  {
   if(t2.getText().length()!=0)
   {
    cities[i]=t2.getText();
    t2.setText("");
    i++;
    tn--;
    c2str="enter city "+(i+1);
    c2.repaint();
    c3str="enter distance between "+cities[j]+" and "+cities[k];
    if(tn==0)
    {
     tn=n;
     t=tn;
     c.next(p);
    }
   }
  }
  if(b==b3)
  {
   int temp=Integer.parseInt(t3.getText());
   if(temp>0 || temp==-1)
   {
    //System.out.println(temp);
    if(j<n-1)
    {
     if(k<n)
     {
      distance[j][k]=temp;
      distance[k][j]=temp;
      t3.setText("");
      k++;
      if(k==n)
      {
       j++;
       k=j+1;
      }
      if(j==n-1)
      {
       c3str="over";
       c.next(p);
       result=o.optimal(n,distance);
       c4str="number of cities entered is "+n;
for(int y=0;y<n;y++)
{
for(int u=0;u<n;u++)
System.out.print(" "+distance[y][u]);
System.out.println("");
}
System.out.println("");
for(int g=0;g<n+2;g++)
System.out.print(" "+result[g]);
      }
      else
      c3str="enter distance between "+cities[j]+" and "+cities[k];
      c3.repaint();
     }
    }
   }
  }
  //if(b==b4){}
 }
 class can2 extends Canvas
 {
  can2(){setSize(150,30);}
  public void paint(Graphics g){g.drawString(c2str,20,20);}
 }
 class can3 extends Canvas
 {
  can3(){setSize(300,30);}
  public void paint(Graphics g){g.drawString(c3str,20,20);}
 }
 class can4 extends Canvas
 {
  can4(){setSize(700,700);setBackground(Color.lightGray);}
  public void paint(Graphics g)
  {
   g.drawString(c4str,x,y);
   y+=15;
   for(int l=0;l<n;l++,y+=15)
   g.drawString(""+(l+1)+". "+cities[l],x,y);
   g.drawLine(140,30,140,700);
   x=150;
   y=50;
   g.drawString("optimal path is : ",x,y);
   y+=20;
   for(int l=0;l<n+1;l++,x+=50)
   g.drawString(""+(result[l]+1)+"---->",x,y);
  }
 }
}