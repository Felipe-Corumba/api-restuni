package com.api.biblio.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//import para join tables
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;




@Entity
@Table(name="TB_LIVRO")
public class CadLivro implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String titulo;	
	private String autor;	
	private String editora;	
	private String assunto;	
	private String isbn;
	private String resumo;
	


	private int status; //0 - Emprestado | 1 - Disponível (Pela soma avaliar disponibilidade)
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy" )
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	//private Long registromatricula;

	@ManyToOne
	@JoinColumn(name = "registromatricula")
	private CadUsuario registromatricula;

	@ManyToMany
	@JoinTable(
	name = "quati_rm",
	joinColumns = @JoinColumn(
	name = "registromatricula", referencedColumnName = "registromatricula"))
	
	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate getDataDevolucao) {
		this.dataDevolucao = getDataDevolucao; // ver como trabalhar na string
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		if(autor.matches("[a-zA-Z]")) {
			this.autor = autor;
		}else {
			System.out.println("Parâmetros inválidos para registro. Utilize apenas letras");
		}
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	
}
