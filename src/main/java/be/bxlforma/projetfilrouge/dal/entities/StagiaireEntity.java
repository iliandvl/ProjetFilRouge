package be.bxlforma.projetfilrouge.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "Stagiaire")	// Nom de l'entité Spring
@Table(name = "stagiaire")	// Nom de la table en DB
@Getter
@Setter
public class StagiaireEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	@Column(nullable = false)
	private String lastName;
}