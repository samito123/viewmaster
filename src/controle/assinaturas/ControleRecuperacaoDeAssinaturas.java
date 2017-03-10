package controle.assinaturas;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Assinatura;

import com.google.gson.Gson;

import controle.servlet.CodificaUTF8;
import controle.servlet.ControleDeRetornoServlet;
import dao.AssinaturasDAO;

public class ControleRecuperacaoDeAssinaturas {

	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleRecuperacaoDeAssinaturas(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeAssinaturas() throws IOException, SQLException{
		ArrayList<Assinatura> assinaturas = new ArrayList<>();
		ConstroiDadosParaArrayDeAssinaturas(assinaturas);
	}
	
	private void ConstroiDadosParaArrayDeAssinaturas(ArrayList<Assinatura> assinaturas) throws SQLException, IOException{
		try {
			AssinaturasDAO dao = new AssinaturasDAO();
			assinaturas = dao.RetornaListaDeAssinaturas(assinaturas);
			RetornaListaDeAssinaturas(assinaturas);
		} catch (Exception e) {
			//new ControleDeRetornoServlet(request, response).RetornaErro();
		}
	}
	
	private void RetornaListaDeAssinaturas(ArrayList<Assinatura> assinaturas) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		for(int contador = 0; contador < assinaturas.size(); contador++){
			assinaturas.set(contador, 
				new CodificaUTF8().CodificaAssinaturaUTF8(assinaturas.get(contador)));
		}
		out.write(gson.toJson(assinaturas));
	}
}
