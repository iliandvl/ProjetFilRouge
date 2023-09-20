package be.bxlforma.projetfilrouge.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "Travail")	// Nom de l'entité Spring
@Table(name = "travail")	// Nom de la table en DB
@Getter
@Setter
public class TravailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private int id;
	private LocalDate date;
	private Long time;
	private String comment;
	@ManyToOne
	private StagiaireEntity stagiaire;
	@ManyToOne
	private ChariotEntity chariot;
	@ManyToOne
	private ClientEntity client;
	@ManyToMany
	private List<TacheEntity> taches;
	@ManyToMany
	private List<ProduitEntity> produitsManquants;

}