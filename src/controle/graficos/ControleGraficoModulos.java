package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelos.Ano;
import modelos.Modulo;
import controle.conexao.ControleCodificaUTF8;
import controle.conexao.ControleDeRetornoServidor;
import dao.GraficosDAO;

public class ControleGraficoModulos {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleGraficoModulos(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeModulosParaGraficoDeModulos() throws IOException, SQLException{
		ArrayList<Modulo> modulos = new ArrayList<>();
		ConstroiDadosParaGraficoDeModulos(modulos);
	}
	
	private void ConstroiDadosParaGraficoDeModulos(ArrayList<Modulo> modulos) throws SQLException, IOException{
		try {
			GraficosDAO dao = new GraficosDAO();
			modulos = dao.ConstroiDadosParaGraficoDeModulosGeralAno();
			RetornaDadosParaGraficoDeModulosGeral(modulos);
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void RetornaDadosParaGraficoDeModulosGeral(ArrayList<Modulo> modulos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(modulos));
	}
	
}
