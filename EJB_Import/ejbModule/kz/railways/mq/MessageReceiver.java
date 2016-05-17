package kz.railways.mq;

import javax.ejb.MessageDriven;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;



@MessageDriven(mappedName = "jms/ImportQueue")
public class MessageReceiver implements MessageListener {

    public void onMessage(Message message) {
        
    	BytesMessage bm = (BytesMessage) message;

    	try {
    		System.out.println("Принято следуюшее сообщение -------------------------------------");
    		byte[] data = new byte[(int) bm.getBodyLength()];
    		bm.readBytes(data);
    		String content = new String(data);
			System.out.println(content);
			System.out.println(" -------------------------END-----------------------------");
		} catch (JMSException e) {
			e.printStackTrace();
		}  
    }
}
