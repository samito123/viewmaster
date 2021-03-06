package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelos.Ano;
import modelos.Mes;
import modelos.Modulo;
import modelos.TipoDeProduto;
import controle.conexao.ControleFabricaDeConexao;
import controle.modelos.ControleTratamentoModulo;


public class GraficosDAO {
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ArrayList<Mes> ConstroiDadosParaGraficoDeSessaoDoUsuarioAno(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? "
					+ "and ano_sessao = ?";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, ano.getId_de_busca()); 
			ps.setString(2, ano.getNumero_do_ano()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes_sessao") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("quantidade_sessoes"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}
	
	public ArrayList<Mes> ConstroiDadosParaGraficoDeSessaoDoUsuarioPorcentagem(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select * from tb_sessoes_usuario where id_usuario = ? ";
			ps = conn.prepareStatement(sql);
			ps.setLong(1, ano.getId_de_busca()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes_sessao") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("quantidade_sessoes"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}
	
	public ArrayList<Modulo> ConstroiDadosParaGraficoDeModulosGeralAno() throws SQLException{
		
		ArrayList<Modulo> modulos = new ControleTratamentoModulo().ConstroiArrayDeModulos();
		Modulo modulo;
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select id_modulo, mes_utilizado, "
					+ "sum(quantidade_de_vezes_utilizada) as qtd "
					+ "from tb_modulos_mais_utilizados_usuario "
					+ "group by id_modulo, mes_utilizado";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				modulo = new Modulo();			
				int id_modulo = rs.getInt("id_modulo") - 1;
				int mes_ano = rs.getInt("mes_utilizado") - 1;
				
				modulos.get(id_modulo).getAno().getMeses_do_ano().get(mes_ano).setValor(rs.getInt("qtd"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return modulos;
	}
	
	public ArrayList<Mes> ConstroiDadosParaGraficoDeClientesAno(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select substring(data_hora_cadastro_cliente, 7, 4) as ano, "
					+ "substring(data_hora_cadastro_cliente, 4, 2) as mes, "
					+ "count(nome_cliente) as qtd "
					+ "from tb_clientes "
					+ "where substring(data_hora_cadastro_cliente, 7, 4) = ? "
					+ "group by ano, mes";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ano.getNumero_do_ano()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("qtd"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}
	
public ArrayList<Mes> ConstroiDadosParaGraficoDeClientesPorcentagem(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select substring(data_hora_cadastro_cliente, 7, 4) as ano,"
					+ "substring(data_hora_cadastro_cliente, 4, 2) as mes, "
					+ "count(nome_cliente) as qtd "
					+ "from tb_clientes "
					+ "group by ano, mes";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("qtd"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}

	public ArrayList<Mes> ConstroiDadosParaGraficoDeReceitasAno(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select substring(data_hora_cadastro_receita, 7, 4) as ano, "
					+ "substring(data_hora_cadastro_receita, 4, 2) as mes, "
					+ "count(id_receita) as qtd "
					+ "from tb_receitas "
					+ "where substring(data_hora_cadastro_receita, 7, 4) = ? "
					+ "group by ano, mes";
			ps = conn.prepareStatement(sql);
			ps.setString(1, ano.getNumero_do_ano()); 
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("qtd"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}

	public ArrayList<Mes> ConstroiDadosParaGraficoDeReceitasPorcentagem(Ano ano) throws SQLException{
		
		ArrayList<Mes> mesesDoAno = ano.getMeses_do_ano();
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select substring(data_hora_cadastro_receita, 7, 4) as ano,"
					+ "substring(data_hora_cadastro_receita, 4, 2) as mes, "
					+ "count(id_receita) as qtd "
					+ "from tb_receitas "
					+ "group by ano, mes";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				int mes = rs.getInt("mes") - 1;
				mesesDoAno.get(mes).setValor(mesesDoAno.get(mes).getValor() + rs.getInt("qtd"));
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return mesesDoAno;
	}
	
	public ArrayList<TipoDeProduto> ConstroiDadosParaGraficoDeTiposDeProdutosMaisVendidos
		(ArrayList<TipoDeProduto> tiposDeProdutos) throws SQLException{
		
		TipoDeProduto tipoDeProduto;
		
		try {	
			conn = new ControleFabricaDeConexao().getConnection();
			String sql = "select tp.tipo_produto, coalesce(sum(ve.quantidade_produto_venda), 0) as qtd "
					+ "from tb_produtos as pr "
					+ "left outer join tb_tipo_produto as tp on pr.fk_tipo_produto = tp.id_tipo_produto "
					+ "left outer join tb_vendas as ve on pr.id_produto = ve.fk_produto "
					+ "group by tp.tipo_produto "
					+ "order by tp.id_tipo_produto asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(); 
			while (rs.next()) { 
				tipoDeProduto = new TipoDeProduto();
				tipoDeProduto.setTipo_produto(rs.getString("tp.tipo_produto"));
				tipoDeProduto.setValor(rs.getString("qtd"));
				tiposDeProdutos.add(tipoDeProduto);
			}	
		}catch (Exception e) {
			System.out.print(e);
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return tiposDeProdutos;
	}

}
