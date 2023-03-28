package fr.iut.montreuil.S4_R02_2023_4.BizQuiz6.joueur_sme.entities.dto;

public enum Langue {
	
	FRANCAIS(1,"FR","Française"),
	ANGLAIS(2,"EN","Anglaise"),
	ALLEMAND(3,"DE","Allemande"),
	ESPANOLE(4,"ES","Espagnole"),
	ITALIEN(5,"IT","Italienne");
	
	Langue(int id, String code, String label) {
		this.id = id;
		this.code=code;
		this.label=label;
		// TODO Auto-generated constructor stub
	}
	private final int id;
	private final String code;
	private final String label;
	
	
	

}