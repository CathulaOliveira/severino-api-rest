package com.br.antbridge.core.email;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {

	public void sendEmail(String email, String senha, Integer porta, String host, String titulo, String mensagem, String emaildestino) throws EmailException {

		String mensagemFinal = this.head()+this.body(mensagem)+this.footer();
		
		SimpleEmail envioemail = new SimpleEmail();
		envioemail.setHostName(host);
		envioemail.setSmtpPort(porta);
		envioemail.setAuthenticator(new DefaultAuthenticator(email, ""+senha));
		envioemail.setSSLOnConnect(true);
		envioemail.setFrom(email);
		envioemail.setSubject(titulo);
		envioemail.setContent(mensagemFinal, "text/html");
		envioemail.addTo(emaildestino);
		envioemail.send();
		
	}
	
	private String head() {
		
		String header = 
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + 
				" <head>\n" + 
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" + 
				"  <title>Demystifying Email Design</title>\n" + 
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\n" + 
				" </head>\n" + 
				"\n" + 
				"<font face=\"Ballada\" style=\"text-align: center\"> \n" + 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\" style=\"border-collapse: collapse;\">\n" + 
				" <tr>\n" + 
				"	<td align=\"center\" bgcolor=\"#70bbd9\">\n" + 
				"	 <p>Severino</p>\n" + 
				"	 <img src=\"https://raw.githubusercontent.com/wiki/Antbridge/severino-docs/imagens/projeto/severino.png\" alt=\"Severino\" width=\"100\" height=\"100\" style=\"display: block;\" />\n" + 
				"	 <p>Project</p>\n" + 
				"	</td>\n" + 
				"	<td align=\"center\" bgcolor=\"#70bbd9\">\n" + 
				"		<br>\n" + 
				"		<a target=\"_blank\" href=\"https://github.com/Antbridge/severino-docs/wiki/Sobre\">Conheça nossa História</a>\n" + 
				"		<br>\n" + 
				"		<br>\n" + 
				"		<a target=\"_blank\" href=\"https://github.com/Antbridge/severino-docs/wiki\">Sugestões</a>\n" + 
				"	</td>\n" + 
				"	<td align=\"center\" bgcolor=\"#70bbd9\">\n" + 
				"	 <p>AntBridge</p>\n" + 
				"	 <img src=\"https://raw.githubusercontent.com/wiki/Antbridge/severino-docs/imagens/projeto/antbridge.jpg\" alt=\"AntBridge\" width=\"100\" height=\"100\" style=\"display: block;\" />\n" + 
				"	 <p>Organization</p>\n" + 
				"	</td>\n" + 
				" </tr>\n" + 
				"</table>";
		
		return header;
		
	}
	
	private String body(String mensagem) {
		
		String body = 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\" style=\"border-collapse: collapse;\">\n" + 
				"<td bgcolor=\"#F8F8FF\" style=\"padding: 5px 30px 5px 30px;\">\n" + 
				" <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\">\n" + 
				"<br>";
		
		body += mensagem;
		
		body += "<br>"
				+"</table>\n" + 
				"</td>\n" + 
				"</table>";
		
		return  body;
		
	}
	
	private String footer() {
		String footer = 
				"<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"500\" style=\"border-collapse: collapse;\">\n" + 
				"<td bgcolor=\"#E0FFFF\" style=\"padding: 5px 30px 5px 30px;\">\n" + 
				"		<h5>E-mail enviado automaticamente pelo Severino</h5>\n" + 
				"</td>\n" + 
				"</table>\n" + 
				"\n" + 
				"</font>\n" + 
				"</html>";
		
		
		return footer;
	}
	
}
