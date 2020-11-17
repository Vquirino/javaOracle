package persistence;

import java.sql.Types;

import entity.Cliente;
import entity.Endereco;

public class ClienteDao extends Dao {
	
	public String create(Cliente c, Endereco e) throws Exception {
		open();
		call = con.prepareCall("{ ? = call inclusao(?,?,?) }");
		call.registerOutParameter(1, Types.VARCHAR);
		call.setString(2, c.getNome());
		call.setString(3, c.getEmail());
		call.setString(4, e.getCidade());
		call.execute();
		
		String resp = call.getString(1);
		close();
		if (resp.equals("1")) {
			return "Dados Gravados";
		}
		else {
			throw new Exception("Erro na gravaçao");
		}
		
	}
	
	public static void main(String[] args) {
		try {
			Cliente cli = new Cliente(null,"faria","faria@gmail.com");
			Endereco ende = new Endereco(null,"Rio de Janeiro",null);
			
			ClienteDao dao = new ClienteDao();
			
			String resp = dao.create(cli, ende);
			
			System.out.println("OK " + resp);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Error: " + ex.getMessage());
		}
	}

}
