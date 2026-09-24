package br.com.exemplo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.pojo.Categorias;
import br.com.exemplo.pojo.Locais;
public class DAOCategorias extends Conexao implements CRUD<Categorias>{

	@Override
	public String cadastrar(Categorias obj) {
		String msg = "Cadastro Realizado";
			try {
				if(abrir()) {
					String categoriaInsert= "INSERT INTO categorias(nome,descricao)VALUES(?,?)";
					pst = con.prepareStatement(categoriaInsert);
					pst.setString(1, obj.getNome());
					pst.setString(2, obj.getDescricao());
					
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
	public Boolean atualizar(Categorias obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categorias> listar() {
		List<Categorias> lista = new ArrayList<Categorias>();
		try {
			if (abrir()) {
				String sql = "SELECT * FROM categorias";
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
					Categorias ca = new Categorias();
					ca.setId(rs.getInt(1));
					ca.setNome(rs.getString(2));
					ca.setDescricao(rs.getString(3));
					
					lista.add(ca);
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
	public Categorias listarID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
