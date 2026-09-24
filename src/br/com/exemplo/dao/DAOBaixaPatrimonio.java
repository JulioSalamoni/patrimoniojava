package br.com.exemplo.dao;

import java.sql.SQLException;
import java.util.List;

import br.com.exemplo.pojo.BaixaPatrimonio;

public class DAOBaixaPatrimonio extends Conexao implements CRUD<BaixaPatrimonio> {

	@Override
	public String cadastrar(BaixaPatrimonio obj) {
		String msg = "Baixa Realizada";
		try {
			if(abrir()) {
				String baixapatrimonialInsert= "INSERT INTO baixas_patrimoniais(patrimonio_id, usuario_registro_id, tipo_baixa, motivo, valor_recuperado, documento_comprobatorio, data_baixa)VALUES(?,?,?,?,?,?,?)";
				pst = con.prepareStatement(baixapatrimonialInsert);
				
				pst.setInt(1, obj.getPatrimonio_id());
				pst.setInt(2, obj.getUsuario_registro_id());
				pst.setString(3, obj.getTipo_baixa().toString());
				pst.setString(4, obj.getMotivo());
				pst.setDouble(5, obj.getValor_recuperado());
				pst.setString(6, obj.getDocumento_comprobatorio());
				pst.setDate(7, obj.getData_baixa());

				
				int i = pst.executeUpdate();
				if(i < 1) {
					msg = "Não foi possível cadastrar o patrimonio";
				}
			}
			else {
				msg = "Não foi possível abrir o banco";
			}
		}
		catch(SQLException se) {
			msg = "Erro ao tentar cadastrar o patrimonio. Mensagem: "+se.getMessage();
		}
		catch(Exception e) {
			msg = "Erro inesperado. Mensagem: "+e.getMessage();
		}
		
return msg;
	}

	@Override
	public Boolean atualizar(BaixaPatrimonio obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaixaPatrimonio> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaixaPatrimonio listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
