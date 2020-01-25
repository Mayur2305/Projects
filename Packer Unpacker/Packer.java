package temp;
import java.awt.Color;
import java.awt.Font;
import java.io.*;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;

class Packer
{
	public int Packing(String dirname,String dest) throws Exception
	{
		
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		//System.out.println("Enter directory name");
		//String dirname=br.readLine();
		
		File fdir=new File(dirname);		
		if(!fdir.exists()||!fdir.isDirectory())
		{
			//System.out.println("Invalid directory name");
			return -1;
		}
		
		File files[]=fdir.listFiles();	
		
		//System.out.println("Enter Destination file name");	
		//String dest=br.readLine();
		
		if(dest.lastIndexOf(".")==-1)
		{
			dest=dest+".TXT";
		}
		else 
		{
			dest=dest.substring(0,dest.lastIndexOf("."))+".TXT";
		}
		
		File newfile=new File(dest);		
		if(!newfile.createNewFile())
		{
			return -2;
			//new file note created
		}
		
		FileOutputStream fout=new FileOutputStream(dest);		//write data in file
		FileInputStream fin=null;								//reading data from file
		byte[] str =null;
		String header,ext;
		String[] extention={"c","cpp","java","txt","jar"};
		List<String> extlist=Arrays.asList(extention);
		
		fout.write("Mayur@235".getBytes());						// to check correct file
		for(int i=0;i<files.length;i++)
		{
			ext=files[i].getName();
			if(!extlist.contains((ext.substring(ext.lastIndexOf(".")+1)).toLowerCase()))
			{
				continue;
			}
			if(files[i].isFile())								// check it is file type or not
			{			
				header=files[i].getName()+" "+(files[i].length());
				fout.write(header.getBytes());		//write file name and its size in destination file
				
				for(int j=header.length();j<100;j++)					// header is of first 100 bytes. (other are black space in that 100 bytes after filename ans size in dest)
				{
					fout.write(" ".getBytes());
				}
				
				fin =new FileInputStream(files[i]);				// inputstream for each file of folder
				
				str=new byte[(int) files[i].length()];			// allocate byte array of file length
				
				while (fin.read(str)>0)
				{	
					fout.write(str);
				}
				fout.flush(); 
			}
		}
		fout.close();
		return 1;
	}
	
}