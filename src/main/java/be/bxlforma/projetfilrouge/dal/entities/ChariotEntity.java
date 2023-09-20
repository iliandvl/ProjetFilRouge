package be.bxlforma.projetfilrouge.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "Chariot")	// Nom de l'entité Spring
@Table(name = "chariot")	// Nom de la table en DB
@Getter
@Setter
public class ChariotEntity {
	@Id		// Primary Key
	private Integer number;
	@ManyToMany
	private List<MaterielEntity> materiels;
	@ManyToMany
	private List<ProduitEntity> produits;

}