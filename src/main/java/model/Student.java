package model;

public class Student {
	private int id;
	private String nome;
	private String cognome;
	private String indirizzo;
	private String matricola;
	private String dataDiNascita;
	private String idDipartimento;

	public Student(int id, String nome, String cognome, String indirizzo, String matricola, String dataDiNascita,
			String idDipartimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.matricola = matricola;
		this.dataDiNascita = dataDiNascita;
		this.idDipartimento = idDipartimento;
	}

	public Student(String nome, String cognome, String indirizzo, String matricola, String dataDiNascita,
			String idDipartimento) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.indirizzo = indirizzo;
		this.matricola = matricola;
		this.dataDiNascita = dataDiNascita;
		this.idDipartimento = idDipartimento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(String dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getIdDipartimento() {
		return idDipartimento;
	}

	public void setIdDipartimento(String idDipartimento) {
		this.idDipartimento = idDipartimento;
	}

}
