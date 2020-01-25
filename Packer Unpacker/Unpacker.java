package temp;
import java.io.*;
public class Unpacker 
{
	String[] extention={"c","cpp","java","txt"};
	public int Unpacking(String fname) throws Exception
	{
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		FileInputStream fin = null;
		FileOutputStream fout = null;
		
		//System.out.println("Enter Packed file name");
		//String fname=br.readLine();
		File file=new File(fname);
		
		
		String ext=fname.substring(fname.lastIndexOf(".")+1);			// ext=>extension of file
		
		if(!ext.toUpperCase().equals("TXT"))							// check correct extension of file
		{
			//System.out.println(" Wrong destination file");
			return -1;
		}
		
		if(!file.exists())
		{
			//System.out.println("invalid file name");
			return -2;
		}
		
		fin = new FileInputStream(file);
		byte check[]=new byte[9];
		
		fin.read(check);
		String str=new String(check);
		
		if(!"Mayur@235".equals(str))
		{
			//System.out.println("invalid packed file");
			fin.close();
			return -3;
		}
        byte Head[] = new byte[100];
        
       
        while(fin.read(Head,0,100)>0)							// Reads up to certain bytes of data from this input stream into an array of bytes.
        {
        	str= new String(Head);						//create string from byte array instream.read(header,0,100)

        	String header[]=str.split("\\s");					//split string
        	
        	File newFile=new File(header[0]);					// file name at 0th index of splitted string
        	
        	//System.out.println(newFile);
        	newFile.createNewFile();						//create file of that name  ?? extension must be .txt/java/c/cpp/jar/
        	
        	byte Content[] = new byte[Integer.parseInt(header[1])];		// allocate memory for data of size=> header[1]
      
        	fin.read(Content,0,Integer.parseInt(header[1]));							// read data in byte array i.e content[]
        	
        	fout=new FileOutputStream(newFile);							
        	fout.write(Content,0,Content.length);						// write data into separate file i.e. upacked data
        	
        }
        fout.close();
        fin.close();
        
        return 1; //successfull
	}

	
	
}