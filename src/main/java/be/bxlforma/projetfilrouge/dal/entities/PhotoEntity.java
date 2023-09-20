package be.bxlforma.projetfilrouge.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Photo")	// Nom de l'entité Spring
@Table(name = "photo")	// Nom de la table en DB
@Getter
@Setter
public class PhotoEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;
	private String photo;
	@ManyToOne
	private TravailEntity travail;

}