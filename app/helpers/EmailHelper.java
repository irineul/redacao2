package helpers;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import play.libs.Mail;

public class EmailHelper {
	
	private static final String EMAIL_FROM = "contato@redacao.com.br";

	private static EmailHelper self;
	
	private EmailHelper(){}
	
	public static EmailHelper getInstance(){
		if (self == null) {
			self = new EmailHelper();
		}
		return self;
	}
	
	public void sendEmail(String to, String subject, String msg){
		SimpleEmail email = new SimpleEmail();
    	try {
			email.setFrom(EMAIL_FROM);
			email.addTo(to);
	    	email.setSubject(subject);
	    	email.setMsg(msg);
	    	Mail.send(email);
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

}
