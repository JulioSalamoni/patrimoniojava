package br.com.exemplo.pojo;

import java.sql.Date;

public class Categorias {
	@Override
	public String toString() {
		return nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categorias(Integer id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
	}
	public Categorias() {
	}
	private Integer id;
	private String nome;
	private String descricao;

}
