package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Modulo;

import com.google.gson.Gson;

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
			SomaTotalDeVezesModuloUtilizado(modulos);
		} catch (Exception e) {
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}
	}
	
	private void SomaTotalDeVezesModuloUtilizado(ArrayList<Modulo> modulos) throws SQLException, IOException{
		try{
			int total = 0;
			for(int modulo = 0; modulo <= 6; modulo++){
				total = 0;
				for(int mes = 0; mes <= 11; mes++){
					total += modulos.get(modulo).getAno().getMeses_do_ano().get(mes).getValor();
				}
				modulos.get(modulo).getAno().setValor(total);
			}
			RetornaDadosParaGraficoDeModulosGeral(modulos);
		}catch(Exception e){
			new ControleDeRetornoServidor(request, response).RetornaErro();
		}	
	}
	
	private void RetornaDadosParaGraficoDeModulosGeral(ArrayList<Modulo> modulos) throws IOException{
		Gson gson = new Gson();
		PrintWriter out = response.getWriter();
		out.write(gson.toJson(modulos));
	}
	
}
