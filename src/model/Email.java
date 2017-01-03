package model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {
	
	public void EnviarEmail(Usuario usuario) throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   //Utilize o hostname do seu provedor de email
		   System.out.println("alterando hostname...");
		   email.setHostName("smtp.gmail.com");
		   //Quando a porta utilizada não é a padrão (gmail = 465)
		   email.setSmtpPort(465);
		   //Adicione os destinatários
		   email.addTo(usuario.getEmail_usuario(), usuario.getNome_usuario());
		   //Configure o seu email do qual enviará
		   email.setFrom("oticamasterapp@gmail.com", "ViewMaster");
		   //Adicione um assunto
		   email.setSubject("Nova Senha!");
		   //Adicione a mensagem do email
		   email.setMsg("Informativo\nCaro usuário "+usuario.getLogin_usuario()+", "
		   		+ "você requisitou uma nova senha no sistema View Master.\nSua nova senha é "
				+usuario.getSenha_usuario()+".\n\nEsse email é enviado de forma automatico, "
				+ "não há nescessidade de respondê-lo.\nContato View Master."
				+ "\nSistema de Gestão Para o Ramo Óptico.");
		   //Para autenticar no servidor é necessário chamar os dois métodos abaixo
		   System.out.println("autenticando...");
		   email.setSSL(true);
		   email.setAuthentication("oticamasterapp@gmail.com", "otica478511master");
		   System.out.println("enviando...");
		   email.send();
		   System.out.println("Email enviado!");
		}
}
