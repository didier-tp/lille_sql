package com.m2i.tp.entity;

public class Departement {
    private String numero;
    private String nom;
    private String prefecture;
    private Integer population;//null possible
    private Integer superficie;
    //+get/set
    //constructeur(s)
    //toString()
    
    
    public Departement() {
	}
    
	@Override
	public String toString() {
		return "Departement [numero=" + numero + ", nom=" + nom + ", prefecture=" + prefecture + ", population="
				+ population + ", superficie=" + superficie + "]";
	}

	public Departement(String numero, String nom, String prefecture, Integer population, Integer superficie) {
		super();
		this.numero = numero;
		this.nom = nom;
		this.prefecture = prefecture;
		this.population = population;
		this.superficie = superficie;
	}

	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrefecture() {
		return prefecture;
	}
	public void setPrefecture(String prefecture) {
		this.prefecture = prefecture;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getSuperficie() {
		return superficie;
	}
	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}
    
    
}
