package br.com.exemplo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.pojo.Cursos;
import br.com.exemplo.pojo.Locais;
public class DAOLocais extends Conexao implements CRUD<Locais>{

	@Override
	public String cadastrar(Locais obj) {
		String msg = "Cadastro Realizado";
				try {
					if(abrir()) {
						String patrimonioInsert= "INSERT INTO locais(nome,descricao,criado_por)VALUES(?,?,?)";
						pst = con.prepareStatement(patrimonioInsert);
						pst.setString(1, obj.getNome());
						pst.setString(2, obj.getDescricao());
						pst.setInt(3, obj.getCriado_por());
						
						int i = pst.executeUpdate();
						if(i < 1) {
							msg = "Não foi possível cadastrar o curso";
						}
					}
					else {
						msg = "Não foi possível abrir o banco";
					}
				}
				catch(SQLException se) {
					msg = "Erro ao tentar cadastrar o curso. Mensagem: "+se.getMessage();
				}
				catch(Exception e) {
					msg = "Erro inesperado. Mensagem: "+e.getMessage();
				}
				
		return msg;
	}

	@Override
	public Boolean atualizar(Locais obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Locais> listar() {
		List<Locais> lista = new ArrayList<Locais>();
		try {
			if (abrir()) {
				String sql = "SELECT * FROM locais";
				//Preparar a consulta para ser executada
				pst = con.prepareStatement(sql);
				//Executar a consulta com o comando executeQuery, assim teremos
				//o comando Select sendo executado. O resultado da consulta é
				//Guardado em uma variável do tipo ResultSet(rs). Sempre que você
				//tiver uma consulta SELECT o retorno desta consulta deve ficar
				//em um ResultSet
				
				rs = pst.executeQuery();
				//O comando next() faz o cursor se movimentar para adiante
				//dentro da tabela, quando há dados. Se não houver dados
				//o cursor não se movimenta e retorna falso, indicando
				//que os dados da tabela acabaram
				while(rs.next()) {
					//Todas as vezes que o laço while "roda" significa que
					//o comando next() executou e assim foi para a próxima
					//linha e trazendo os dados desta linha.
					//Para organizar e guardar os dados dos usuários, criamos
					//um novo usuário da camada POJO e, passamos todos os dados
					//retornados do rs para cada campo do usuário.
					//Depois adicionamos este usuário a lista de usuários selecionados.
					Locais lo = new Locais();
					lo.setId(rs.getInt(1));
					lo.setNome(rs.getString(2));
					lo.setDescricao(rs.getString(3));
					lo.setCriado_por(rs.getInt(4));
					lo.setCriado_em(rs.getDate(5));
					
					lista.add(lo);
				}
			}
			else {
				System.out.println("Erro ao tentar abrir a conexão");
			}
		}
		catch(SQLException se) {
			System.out.print("Erro ao tentar executar a consulta. Mensagem:"+se.getMessage());
		}
		catch(Exception e) {
			System.out.println("Erro inesperado, Mensagem:"+e.getMessage());
		}
		finally {
			fechar();
		}
		
		return lista;
	}

	@Override
	public Locais listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
