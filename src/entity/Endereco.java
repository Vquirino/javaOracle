package entity;

import java.io.Serializable;

public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer idEndereco;
	private String cidade;
	private Integer idClientefk;
	
	// Has One Endereco
	private Cliente cliente;
	
	public Endereco() {
		// TODO Auto-generated constructor stub
	}
	
	public Endereco(Integer idEndereco, String cidade, Integer idClientefk) {
		super();
		this.idEndereco = idEndereco;
		this.cidade = cidade;
		this.idClientefk = idClientefk;
	}

	public Endereco(Integer idEndereco, String cidade, Integer idClientefk, Cliente cliente) {
		this.idEndereco = idEndereco;
		this.cidade = cidade;
		this.idClientefk = idClientefk;
		this.cliente = cliente;
	}
	
	
	@Override
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", cidade=" + cidade + ", idClientefk=" + idClientefk
				+ ", cliente=" + cliente + "]";
	}

	
	public Integer getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public Integer getIdClientefk() {
		return idClientefk;
	}
	public void setIdClientefk(Integer idClientefk) {
		this.idClientefk = idClientefk;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	

}
