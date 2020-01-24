import java.io.*;
import java.security.MessageDigest;
import java.util.*; 	
import java.io.File;

public class Rm_duplicate
{

   public static byte[] createChecksum(String filename) throws Exception 
   {
		InputStream fis =  new FileInputStream(filename);
		
		byte[] buffer = new byte[100];
		MessageDigest complete = MessageDigest.getInstance("MD5");
		int numRead;

		do 
		{
			numRead = fis.read(buffer);
			if (numRead > 0) 
			{
				complete.update(buffer, 0, numRead);
			}
		} while (numRead != -1);
	
		fis.close();
		return complete.digest();
	}

	public static String getChecksum(String filename) throws Exception 
	{
		byte[] b = createChecksum(filename);
		String result = new String(b);
	
		return result;
	}

	public static void main(String args[])
	{
		int Flag=0;		
// to check duplicate files are available or not
		int t_count=0;		// total count of files
		int d_count=0;		// countof deleted files
		try 
		{
			Scanner sobj=new Scanner(System.in);
	   
			System.out.println("Enter folder path\n");
			String str=sobj.nextLine();
			
			Hashtable <String,String> ht=new Hashtable <String,String>();
			
			File file = new File(str);
                        if(!file.exists())
                        {
                            System.out.println("invalid path.. No folder found");
                            return;
                        }
			File []files = file.listFiles();
			for(File f: files)
			{
				String abs_path=f.getAbsolutePath();
				t_count++;
				ht.put(getChecksum(abs_path),abs_path);
			}
			
			Enumeration<String> it=ht.keys();
		
			while(it.hasMoreElements()) 
			{
				String key = it.nextElement();
				
				files = file.listFiles();
				for(File f: files)
				{
					String abs_path=f.getAbsolutePath();
					
					if(key.equals(getChecksum(abs_path)) && !(ht.get(key).equals(abs_path)))
					{
						File todel=new File(abs_path);			//variable todel for to delete that file
						if(todel.delete())
						{
							d_count++;
							System.out.println("\n"+abs_path+"successfully deleted");
							Flag=1;
						}
					}
				}
			}
         
		}
		catch (Exception e) 
		{}
		
		if(Flag==0)
		{
			System.out.println("No duplicate files found");
		}
		else
			System.out.println("delete Count="+d_count);
	}
}
