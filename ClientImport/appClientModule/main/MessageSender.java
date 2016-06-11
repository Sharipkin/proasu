package main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
//import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Scanner;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.Session;
import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;

public class MessageSender {

	// @Resource(mappedName = "jms/ImportConnFactory")
	// private static ConnectionFactory connFact;
	// @Resource(mappedName = "jms/ImportQueue")
	// private static Queue queue;

	private static Scanner sc;

	/*
	 * public void produceMessage(byte [] mess) { BytesMessage bm;
	 * 
	 * try (Connection conn = connFact.createConnection(); Session session =
	 * conn.createSession(false, Session.AUTO_ACKNOWLEDGE); MessageProducer mp =
	 * session.createProducer(queue); ) {
	 * 
	 * 
	 * bm = session.createBytesMessage(); bm.writeBytes(mess);
	 * 
	 * //tm.setText("Test Message" + new Date().toString()); System.out.println(
	 * "Send Message ---- "+new Date().toString()+bm.getClass()); String content
	 * = new String(mess, StandardCharsets.UTF_8); System.out.println(content);
	 * mp.send(bm);
	 * 
	 * } catch (JMSException e) { e.printStackTrace(); } }
	 */

	public void produceMessage(byte[] mess, String adress) {
		BytesMessage bm;

		Session session = null;
		ConnectionFactory factory = null;
		QueueConnection connection = null;

		try {
			// Properties props = new Properties();

			// props.put(Context.INITIAL_CONTEXT_FACTORY,
			// "com.sun.enterprise.naming.SerialInitContextFactory");
			// props.setProperty("org.omg.CORBA.ORBInitialHost", "10.64.3.80");
			// props.setProperty("org.omg.CORBA.ORBInitialPort", "3700");

			// Context jndiContext = new InitialContext(props);
			// Look up the factory and the queue
			// factory = (ConnectionFactory)
			// jndiContext.lookup("jms/ImportConnFactory");

			factory = new com.sun.messaging.ConnectionFactory();
			factory.setProperty(ConnectionConfiguration.imqAddressList, "mq://" + adress + ",mq://" + adress + "");
			// factory.setProperty(ConnectionConfiguration.imqAddressList,
			// "mq://10.64.3.80:7676,mq://10.64.3.80:7676");
			connection = factory.createQueueConnection();

			connection.start();

			session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
			Queue ioQueue = session.createQueue("ImportQueue");
			MessageProducer queueSender = session.createProducer(ioQueue);

			bm = session.createBytesMessage();
			bm.writeBytes(mess);

			// tm.setText("Test Message" + new Date().toString());
			System.out.println("Send Message ---- " + new Date().toString() + bm.getClass());
			String content = null;
			try {
				content = new String(mess, "cp866");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(content);

			queueSender.send(bm);
			queueSender.close();

		} catch (JMSException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			try {
				session.close();
				connection.close();
			} catch (Exception e) {
				System.out.println("Can’t close JMS connection/session " + e.getMessage());
			}
		}
	}

	public static void main(String[] args) throws JMSException {

		String adress;

		/*
		 * System.setProperty("org.omg.CORBA.ORBInitialHost", "10.64.3.80");
		 * System.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
		 */

		Path dir = Paths.get(args[0]);

		adress = args[1];

		sc = new Scanner(System.in);
		String comand;

		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			System.out.println("Enter command check to continue");
			comand = sc.nextLine();
			if (comand.equals("check")) {
				try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
					for (Path entry : stream) {
						System.out.println(entry.getFileName());
						// new
						// MessageSender().produceMessage(Files.readAllBytes(entry));
						new MessageSender().produceMessage(Files.readAllBytes(entry), adress);
					}

				} catch (IOException e) {
					e.printStackTrace();
				}

			}
			if (comand.equals(""))
				System.exit(0);
		}
	}
}
