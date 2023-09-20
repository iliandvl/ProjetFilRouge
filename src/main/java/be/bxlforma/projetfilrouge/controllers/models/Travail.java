package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.*;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Builder
@Setter
@Getter
public class Travail {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private LocalDate date;
    private Long time;
    private String comment;
    private Stagiaire stagiaire;
    private Chariot chariot;
    private Client client;
    private List<Tache> taches;
    private List<Produit> produitsManquants;

    public static Travail fromEntity(TravailEntity entity) {
        Travail.TravailBuilder builder = new TravailBuilder()
                .id(entity.getId())
                .date(entity.getDate())
                .time(entity.getTime())
                .comment(entity.getComment())
                .stagiaire(Stagiaire.fromEntity(entity.getStagiaire()))
                .chariot(Chariot.fromEntity(entity.getChariot()))
                .client(Client.fromEntity(entity.getClient()))
                .taches(entity.getTaches().stream().map(Tache::fromEntity).toList())
                .produitsManquants(entity.getProduitsManquants().stream().map(Produit::fromEntity).toList());

        return builder.build();
    }

    public TravailEntity toEntity() {
        TravailEntity entity = new TravailEntity();
        entity.setDate(getDate());
        entity.setTime(getTime());
        entity.setComment(getComment());
        entity.setStagiaire(getStagiaire().toEntity());
        entity.setChariot(getChariot().toEntity());
        entity.setClient(getClient().toEntity());
        entity.setTaches(getTaches().stream().map(Tache::toEntity).toList());
        entity.setProduitsManquants(getProduitsManquants().stream().map(Produit::toEntity).toList());

        return entity;
    }
}