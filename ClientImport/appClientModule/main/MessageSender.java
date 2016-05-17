package main; 

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.jms.BytesMessage;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;



public class MessageSender {
	
	@Resource(mappedName = "jms/ImportConnFactory")
	private static ConnectionFactory connFact;
	@Resource(mappedName = "jms/ImportQueue")
	private static Queue queue;
	
	private static Scanner sc;
	
	
	public void produceMessage(byte [] mess)
	{
		BytesMessage bm;
		
		try (Connection conn = connFact.createConnection();
			 Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			 MessageProducer mp = session.createProducer(queue);	) 
		{

			
			bm = session.createBytesMessage();
			bm.writeBytes(mess);
			
			//tm.setText("Test Message" + new Date().toString());
			System.out.println("Send Message ---- "+new Date().toString()+bm.getClass());
			String content = new String(mess, StandardCharsets.UTF_8);
			System.out.println(content);
			mp.send(bm);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws JMSException{
		
		
    	Path dir = Paths.get("d:\\Programming\\Java\\ki");
    	sc = new Scanner(System.in);
    	
    	while(true) 
        {
    		try 
    		{
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
	        			
	        			new MessageSender().produceMessage(Files.readAllBytes(entry));
	        		}
	        		
	        	}
	            catch (IOException e) {
	            	e.printStackTrace();
	            }
	        	
	         }
	         if (comand.equals("")) System.exit(0);
        }	
	}
}
