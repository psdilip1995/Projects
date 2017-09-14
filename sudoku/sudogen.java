import java.util.*;
class sudogen
{
 int[][] val=new int[9][9];
 int[][][] box=new int[9][3][3];
 ArrayList <Integer>al=new ArrayList<Integer>();
 sudogen()
 {
  fillbox1();
  fillbox2();
  fillbox3();
  fillbox4();
  fillbox5();
  printsuval();
 }
 public static void main(String args[])
 {
  sudogen su=new sudogen();
 }
 public void printsuval()
 {
  System.out.print("\n");
  for(int i=0;i<9;i++)
  {
   for(int j=0;j<3;j++)
   {
    for(int k=0;k<3;k++)
     System.out.print(box[i][j][k]);
    System.out.print("\n");
   }
   System.out.print("\n");
  }
 }
 public void fillbox1()
 {
  for(int i=1;i<10;i++)
   al.add(i);
  Collections.shuffle(al);
  System.out.println(al);
  for(int i=0;i<3;i++)
   box[0][0][i]=al.get(i);
  for(int i=0;i<3;i++)
   box[0][1][i]=al.get(i+3);
  for(int i=0;i<3;i++)
   box[0][2][i]=al.get(i+6);
 }
 public void fillbox2()
 {
  ArrayList <Integer>tal=new ArrayList<Integer>();
  for(int i=3;i<9;i++)
  tal.add(al.get(i));
  Collections.shuffle(tal);
  for(int i=0;i<3;i++)
  box[1][0][i]=tal.get(i);
  //row1 completed
  tal.clear();
  for(int i=0;i<3;i++)
  tal.add(al.get(i));
  for(int i=6;i<9;i++)
  tal.add(al.get(i));
  for(int i=0;i<3;i++)
  {
   int t=tal.indexOf(box[1][0][i]);
   if((t)!=-1)
   tal.remove(t);
  }
  int count=0;
  for(int i=0;i<3;i++)
  {
   int t=tal.indexOf(box[0][2][i]);
   if(t!=-1)
   {
    box[1][1][count++]=tal.get(t);
	tal.remove(t);
   }
  }
  for(int i=count;i<3;i++)
  box[1][1][count++]=tal.get(i);
  //row2 completed
  tal.clear();
  for(int i=1;i<10;i++)
  tal.add(i);
  for(int j=0;j<2;j++)
  for(int i=0;i<3;i++)
  tal.remove(tal.indexOf(box[1][j][i]));
  for(int i=0;i<3;i++)
  box[1][2][i]=tal.get(i);
  //row3 completed
  //System.out.println(tal);
 }
 public void fillbox3()
 {
  ArrayList <Integer>tal=new ArrayList<Integer>();
  for(int k=0;k<3;k++)
  {
  for(int i=1;i<10;i++)
  tal.add(i);
  for(int j=0;j<2;j++)
  for(int i=0;i<3;i++)
  tal.remove(tal.indexOf(box[j][k][i]));
  Collections.shuffle(tal);
  for(int i=0;i<3;i++)
  box[2][k][i]=tal.get(i);
  tal.clear();
  }
 }
 public void fillbox4()
 {
  ArrayList <Integer>tal=new ArrayList<Integer>(al);
  for(int i=0;i<3;i++)
  tal.remove(tal.indexOf(box[0][i][0]));
  Collections.shuffle(tal);
  for(int i=0;i<3;i++)
  box[3][i][0]=tal.get(i);
  //column1 completed
  tal.clear();
  tal.addAll(al);
  for(int i=0;i<3;i++)
  tal.remove(tal.indexOf(box[0][i][1]));
  for(int i=0;i<3;i++)
  {
   int t=tal.indexOf(box[3][i][0]);
   if((t)!=-1)
   tal.remove(t);
  }
  int count=0;
  for(int i=0;i<3;i++)
  {
   int t=tal.indexOf(box[0][i][2]);
   if((t)!=-1)
   {
    box[3][count++][1]=tal.get(t);
    tal.remove(t);
   }
  }
  Collections.shuffle(tal);
  for(int i=count;i<3;i++)
  box[3][count++][1]=tal.get(i);
  //column2 completed
  tal.clear();
  tal.addAll(al);
  for(int j=0;j<2;j++)
  for(int i=0;i<3;i++)
  tal.remove(tal.indexOf(box[3][i][j]));
  Collections.shuffle(tal);
  for(int i=0;i<3;i++)
  box[3][i][2]=tal.get(i);
  //column3 completed
 }
 public void fillbox5()
 {
  ArrayList <Integer>tal=new ArrayList<Integer>(al);
  ArrayList <Integer>tal2=new ArrayList<Integer>();
  ArrayList <Integer>c1=new ArrayList<Integer>();
  ArrayList <Integer>c2=new ArrayList<Integer>();
  ArrayList <Integer>c3=new ArrayList<Integer>();
  for(int i=0;i<3;i++)
  c1.add(box[1][i][0]);
  for(int i=0;i<3;i++)
  c2.add(box[1][i][1]);
  for(int i=0;i<3;i++)
  c3.add(box[1][i][2]);
  System.out.println(c1);
  System.out.println(c2);
  System.out.println(c3);
  for(int i=0;i<3;i++)
  tal.remove(tal.indexOf(box[3][0][i]));
  tal2.addAll(tal);
  tal2.removeAll(c1);
  Collections.shuffle(tal2);
  box[4][0][0]=tal2.get(0);
  tal2.clear();
  tal2.addAll(tal);
  tal2.removeAll(c2);
  int t=tal2.indexOf(box[4][0][1]);
  if(t!=-1)
  tal2.remove(t);
  Collections.shuffle(tal2);
  box[4][0][1]=tal2.get(0);
  tal2.clear();
  tal2.addAll(tal);
  tal2.removeAll(c3);
  t=tal2.indexOf(box[4][0][0]);
  if(t!=-1)
  tal2.remove(t);
  t=tal2.indexOf(box[4][0][1]);
  if(t!=-1)
  tal2.remove(t);
  Collections.shuffle(tal2);
  box[4][0][2]=tal2.get(0);
  //row1 completed
  tal.clear();
  tal2.clear();
  for(int i=0;i<3;i++)
  tal.add(box[3][0][i]);
  for(int i=0;i<3;i++)
  tal.add(box[3][2][i]);
  System.out.println(tal);
  for(int i=0;i<3;i++)
  {
   t=tal.indexOf(box[4][0][i]);
   if(t!=-1)
   tal.remove(t);
  }
  System.out.println(tal);
  for(int i=0;i<3;i++)
  {
   t=tal.indexOf(box[3][2][i]);
   if(t!=-1)
   {
    if((c1.indexOf(box[3][2][i])==-1)&&(box[4][1][0]==0))
	{
	 box[4][1][0]=tal.get(t);
	 tal.remove(t);
	}
	else if((c2.indexOf(box[3][2][i])==-1)&&(box[4][1][1]==0))
	{
	 box[4][1][1]=tal.get(t);
	 tal.remove(t);
	}
	else if((c3.indexOf(box[3][2][i])==-1)&&(box[4][1][2]==0))
	{
	 box[4][1][2]=tal.get(t);
	 tal.remove(t);
	}
   }
  }

  System.out.println(tal);
 }
}