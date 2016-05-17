package main;

import java.io.IOException;
//import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.List;
import java.util.Scanner;

public class DirAccept {
    
    private static Scanner sc;

	public static void main(String[] args) {
    	Path dir = Paths.get("d:\\Programming\\Java\\ki");
    	//List<String> rows = null;
    	sc = new Scanner(System.in);
    	
    	while(true) 
        {
    		try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
        System.out.println("Enter command check to continue");
        String comand = sc.nextLine();
        if (comand.equals("check"))
                {
        	try(DirectoryStream<Path> stream = Files.newDirectoryStream(dir))
        	{
        		for (Path entry: stream)
        		{
        			System.out.println(entry.getFileName());
        			
        			/*rows = Files.readAllLines(entry, StandardCharsets.UTF_8);
        			
        			try (Scanner sc2 = new Scanner(entry);) 
        			{
	        			while (sc2.hasNext())
	        			{
	        				if (sc2.next().equals("(:902"))
	        				{
	        					System.out.println(rows.toString());
	                			System.out.println("===================================");
	        					
	        					Files.delete(entry); 
	        		            System.out.println("File deleted successfully");
	        				}
	        			}
        			}*/

        			//byte[] data = Files.readAllBytes(entry);
        			 
        			//String content = new String(data, StandardCharsets.UTF_8);
        			
        			
        			
          		}
        		
        	} catch (IOException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}     
                }
            if (comand.equals("")) System.exit(0);
        }
      
            
        }
    	
    	    
}
