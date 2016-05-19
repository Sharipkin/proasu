package kz.railways.mq;

import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

import kz.railaws.workstation.PodhodBeanLocal;



@MessageDriven(mappedName = "jms/ImportQueue")
public class MessageReceiver implements MessageListener {
	
	@EJB
	PodhodBeanLocal pb;

    public void onMessage(Message message) {
        
    	BytesMessage bm = (BytesMessage) message;

    	try {
    		System.out.println("������� ��������� ��������� -------------------------------------");
    		byte[] data = new byte[(int) bm.getBodyLength()];
    		bm.readBytes(data);
    		String content = new String(data);
			System.out.println(content);
			System.out.println(pb.test());
			System.out.println(" -------------------------END-----------------------------");
		} catch (JMSException e) {
			e.printStackTrace();
		}  
    }
}
