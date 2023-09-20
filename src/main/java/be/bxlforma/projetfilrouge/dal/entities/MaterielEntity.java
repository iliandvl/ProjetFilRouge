package be.bxlforma.projetfilrouge.dal.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Materiel")	// Nom de l'entité Spring
@Table(name = "materiel")	// Nom de la table en DB
@Getter
@Setter
public class MaterielEntity {
	@Id		// Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY)	//Auto-Incrémentée
	private Integer id;

	@Column (
		length = 100/*,
		name = "name",	//Permet de spécifier la nom du champ en DB (par def : nom du membre lowercase()-
		unique = true,	//Rend le champs unique en DB (par def: false)
		nullable = true	//Rend le champ nullable en DB (par def: false)
		*/
	)
	private String name;
}