package controle.graficos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Ano;

import com.google.gson.Gson;

import controle.conexao.ControleCodificaUTF8;
import dao.GraficosDAO;

public class ControleGraficoModulos {
	
	static private HttpServletRequest request;
	static private HttpServletResponse response; 
	
	public ControleGraficoModulos(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
	}
	
	public void ConstroiArrayDeAnosParaGraficoDeModulos(Ano ano) throws IOException, SQLException{
		ArrayList<Ano> anos = new ArrayList<>();
		anos.add(ano);
		
	}
	
	Select id_modulo, mes_utilizado, ano_utilizado, sum(quantidade_de_vezes_utilizada) as qtd
	from tb_modulos_mais_utilizados_usuario
	group by id_modulo, mes_utilizado, ano_utilizado
}
