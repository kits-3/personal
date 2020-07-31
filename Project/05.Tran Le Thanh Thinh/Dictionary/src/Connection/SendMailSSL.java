package Connection;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendMailSSL {

	public static void main(String[] args) throws EmailException {
		Email email = new SimpleEmail();
		
		email.setHostName(MailConfig.HOST_NAME);
		email.setSmtpPort(MailConfig.SSL_PORT);
		email.setAuthenticator(new DefaultAuthenticator(MailConfig.APP_EMAIL, MailConfig.APP_PASSWORD));
		email.setSSLOnConnect(true);
		
		email.setFrom(MailConfig.APP_EMAIL);
		email.addTo(MailConfig.RECEIVE_EMAIL);
		email.setSubject("Email cua Thinh");
		email.setMsg("Xin chao cac ban");
		email.send();
		System.out.print("gui mail thanh cong");
		
		

	}

}
