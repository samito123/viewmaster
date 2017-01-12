package modelos;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email {
	
	public void EnviarEmail(Usuario usuario) throws EmailException {
	    
		   SimpleEmail email = new SimpleEmail();
		   //Utilize o hostname do seu provedor de email
		   System.out.println("alterando hostname...");
		   email.setHostName("smtp.gmail.com");
		   //Quando a porta utilizada n�o � a padr�o (gmail = 465)
		   email.setSmtpPort(465);
		   //Adicione os destinat�rios
		   email.addTo(usuario.getEmail_usuario(), usuario.getNome_usuario());
		   //Configure o seu email do qual enviar�
		   email.setFrom("oticamasterapp@gmail.com", "ViewMaster");
		   //Adicione um assunto
		   email.setSubject("Nova Senha!");
		   //Adicione a mensagem do email
		   email.setMsg("Informativo\nCaro usu�rio "+usuario.getLogin_usuario()+", "
		   		+ "voc� requisitou uma nova senha no sistema View Master.\nSua nova senha � "
				+usuario.getSenha_usuario()+".\n\nEsse email � enviado de forma automatico, "
				+ "n�o h� nescessidade de respond�-lo.\nContato View Master."
				+ "\nSistema de Gest�o Para o Ramo �ptico.");
		   //Para autenticar no servidor � necess�rio chamar os dois m�todos abaixo
		   System.out.println("autenticando...");
		   email.setSSL(true);
		   email.setAuthentication("oticamasterapp@gmail.com", "otica478511master");
		   System.out.println("enviando...");
		   email.send();
		   System.out.println("Email enviado!");
		}
}
