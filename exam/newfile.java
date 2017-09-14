import java.io.*;
class newfile
{
 public static void main(String args[])throws Exception
 {
  new File("C:\\dilip\\java\\newjava\\one\\two\\three").mkdirs();
  File f=new File("C:\\dilip\\java\\newjava\\one\\two\\three","L.dil");
  f.createNewFile();
  int roll=17;
  String name="trail";
  FileOutputStream fos=new FileOutputStream(f);
  String ips=String.valueOf(roll)+"\n"+name;
  for(int i=0;i<ips.length();i++)
	fos.write(ips.charAt(i));
  fos.close();
  FileInputStream fis=new FileInputStream(f);
  int i=fis.read();
  while(i!=-1)
  {
   System.out.print((char)i);
   i=fis.read();
  }
  fis.close();
 }
}