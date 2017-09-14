package optimal;
import java.util.*;
public class opt
{
 public int[] optimal(int n,int[][] distance)
 {
  int result[]=new int[n+2];
  TreeSet <Integer> al=new TreeSet <Integer>();
  for(int k=1;k<n;k++)
  al.add(k);
  int temp=0,i=1,sum=0,temp2,temp3=0,least,tempdist;
  result[0]=0;
  Iterator itr;
  while(al.size()!=1)
  {
   least=999999;
   itr=al.iterator();
   while(itr.hasNext())
   {
    temp2=(int)itr.next();
    tempdist=distance[temp][temp2];
    if(tempdist>0 && tempdist<least)
    {
     least=tempdist;
     temp3=temp2;
    }
   }
   result[i]=temp3;
   i++;
   al.remove(temp3);
   temp=temp3;
   sum=sum+least;
  }
  itr=al.iterator();
  result[i]=(int)itr.next();
  sum=sum+distance[temp][result[i]]+distance[0][result[i]];
  i++;
  result[i]=0;
  i++;
  result[i]=sum;
  return result;
 }
}