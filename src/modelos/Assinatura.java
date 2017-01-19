package modelos;


public class Assinatura {
	
	private Long id_assinatura;
	private String tipo_assinatura;
	private String data_inicial_assinatura;
	private String data_final_assinatura;
	private String data_bloqueio_assinatura;
	
	public Long getId_assinatura() {
		return id_assinatura;
	}
	public void setId_assinatura(Long id_assinatura) {
		this.id_assinatura = id_assinatura;
	}
	public String getTipo_assinatura() {
		return tipo_assinatura;
	}
	public void setTipo_assinatura(String tipo_assinatura) {
		this.tipo_assinatura = tipo_assinatura;
	}
	public String getData_inicial_assinatura() {
		return data_inicial_assinatura;
	}
	public void setData_inicial_assinatura(String data_inicial_assinatura) {
		this.data_inicial_assinatura = data_inicial_assinatura;
	}
	public String getData_final_assinatura() {
		return data_final_assinatura;
	}
	public void setData_final_assinatura(String data_final_assinatura) {
		this.data_final_assinatura = data_final_assinatura;
	}
	public String getData_bloqueio_assinatura() {
		return data_bloqueio_assinatura;
	}
	public void setData_bloqueio_assinatura(String data_bloqueio_assinatura) {
		this.data_bloqueio_assinatura = data_bloqueio_assinatura;
	}
	
	
}
