import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
class scaner extends Frame implements ActionListener
{
 HashMap<String,String>hm=new HashMap<String,String>();
 TreeSet<String> key=new TreeSet<String>();
 BufferedReader br=null;
 Panel p,p1,p2;
 Button b,b1,b2,b3;
 TextField t1;
 Label l1,l2,l3;
 CardLayout c;
 TextArea ta,ta2;
 String temp;
 scaner()
 {
  set();
  c=new CardLayout();
  p=new Panel();
  p.setLayout(c);
  p1=new Panel();
  l1=new Label("Enter file name :");
  t1=new TextField(20);
  b1=new Button("ok");
  b1.addActionListener(this);
  ta=new TextArea(23,55);
  ta.setEditable(false);
  l2=new Label("your program is as above");
  b2=new Button("done");
  b2.addActionListener(this);
  p1.add(l1);
  p1.add(t1);
  p1.add(b1);
  p1.add(ta);
  p1.add(l2);
  p1.add(b2);
  p.add(p1);
  p2=new Panel();
  l3=new Label("Tokens and Type");
  b3=new Button("Back");
  b3.addActionListener(this);
  ta2=new TextArea("Token\t\t\t\tType\n",25,55);
  ta2.setEditable(false);
  p2.add(l3);
  p2.add(b3);
  p2.add(ta2);
  p2.setLayout(new FlowLayout());
  p.add(p2);
  add(p);
  setLayout(new GridLayout(1,1));
  setVisible(true);
  setSize(500,500);
  setResizable(false);
 }
 public static void main(String args[])
 {
  scaner s=new scaner();
 }
 public void actionPerformed(ActionEvent ae)
 {
  b=(Button)ae.getSource();
  if(b==b1)
  {
   try{
   br=new BufferedReader(new FileReader(t1.getText()));
   ta.setText("");
   while((temp=br.readLine())!=null)
   {
    ta.append(temp);
	ta.append("\n");
   }
   }catch(IOException ioe){ta.setText("File dose not exsist");}
  }
  if(b==b2)
  {
   tokenize();
   c.next(p);
  }
  if(b==b3)
  {
   t1.setText("");
   ta.setText("");
   ta2.setText("Token\t\t\t\tType\n");
   c.next(p);
  }
 }
 public void tokenize()
 {
  String temp2,temp3,temp4;
  temp=null;
  try{
  br=new BufferedReader(new FileReader(t1.getText()));
  while((temp=br.readLine())!=null)
  {
   StringTokenizer st=new StringTokenizer(temp," #<>{}[]()+-/*%;&,=\"");
   //StringTokenizer st1=new StringTokenizer(temp,"#<>{}[]()+-/*%;&,=\"",true);
   while(st.hasMoreTokens())
   {
    temp4=st.nextToken();
	//temp2=st1.nextToken();
	//temp3=temp2.substring(temp2.length()-1);
	//temp2=temp2.substring(0,temp2.length()-1);
	if(key.contains(temp4))
	{
	 ta2.append(temp4+"\t\t\t\tkeyword\n\n\n");
	}
	else
	{
	 ta2.append(temp4+"\t\t\t\tidentifier or constant\n\n\n");
	}
	/*if(hm.get(temp3)!=null)
	{
	 ta2.append(temp3+"\t\t\t\t"+hm.get(temp3)+"\n\n\n");
	}
	else
	{
	 ta2.append(temp3+"\t\t\t\tsymbol\n\n\n");
	}*/
   }
   for(int i=0;i<temp.length();i++)
   {
    temp3=""+temp.charAt(i);
    if(hm.get(temp3)!=null)
	{
	 ta2.append(temp3+"\t\t\t\t"+hm.get(temp3)+"\n\n\n");
	}
   }
  }
  }catch(IOException ioo){}
 }
 public void set()
 {
  try{
  br=new BufferedReader(new FileReader("keyword.txt"));
  while((temp=br.readLine())!=null)
  {
   key.add(temp);
  }
  }catch(IOException e){}
  temp=null;
  hm.put("+","add");
  hm.put("-","substract");
  hm.put("/","divide");
  hm.put("*","multiply,dereferencing");
  hm.put("(","rigth parenthesis");
  hm.put(")","left parenthesis");
  hm.put("[","right square bracket");
  hm.put("]","left square bracket");
  hm.put("{","right flower bracket");
  hm.put("}","left flower bracket");
  hm.put("<","less than");
  hm.put(">","greater than");
  hm.put("=","assignment");
  hm.put("&","referencing");
  hm.put("%","percentage");
  hm.put("\"","starting or ending of string");
  hm.put(",","seperator");
  hm.put(";","semi-colan");
  hm.put("#","used in pre-processor");
 }
}