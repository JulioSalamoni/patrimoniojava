package br.com.exemplo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.exemplo.pojo.Cursos;
import br.com.exemplo.pojo.Usuarios;

public class DAOCurso extends Conexao implements CRUD<Cursos>{

	@Override
	public String cadastrar(Cursos obj) {
		String msg = "Cadastro Realizado";
		try {
			if(abrir()) {
				String cursoInsert= "INSERT INTO cursos(nome,sigla,criado_por)VALUES(?,?,?)";
				pst = con.prepareStatement(cursoInsert);
				
				pst.setString(1, obj.getNome());
				pst.setString(2, obj.getSigla());
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
	public Boolean atualizar(Cursos obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deletar(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cursos> listar() {
		List<Cursos> lista = new ArrayList<Cursos>();
		try {
			if (abrir()) {
				String sql = "SELECT * FROM cursos";
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
					Cursos cu = new Cursos();
					cu.setId(rs.getInt(1));
					cu.setNome(rs.getString(2));
					cu.setSigla(rs.getString(3));
					cu.setCriado_por(rs.getInt(4));
					cu.setCriado_em(rs.getDate(5));
					
					lista.add(cu);
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
	public Cursos listarID(Integer id) {
		Cursos lista = new Cursos();
		try {
			if (abrir()) {
				String sql = "SELECT * FROM cursos WHERE id="+id;
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
					Cursos cu = new Cursos();
					cu.setId(rs.getInt(1));
					cu.setNome(rs.getString(2));
					cu.setSigla(rs.getString(3));
					cu.setCriado_por(rs.getInt(4));
					cu.setCriado_em(rs.getDate(5));
					
					lista = cu;
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
	
	
}
