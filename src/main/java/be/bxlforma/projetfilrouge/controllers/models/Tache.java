package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.TacheEntity;

import be.bxlforma.projetfilrouge.dal.entities.ZoneEntity;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Builder
@Setter
@Getter
public class Tache {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;
    private LocalDate lastRealisation;
    private Integer interval;
    private Zone zone;

    public static Tache fromEntity(TacheEntity entity) {
        Tache.TacheBuilder builder = new Tache.TacheBuilder()
                .id(entity.getId())
                .name(entity.getName())
                .lastRealisation(entity.getLastRealisation())
                .interval(entity.getInterval())
                .zone(Zone.fromEntity(entity.getZone()));

        return builder.build();
    }

    public TacheEntity toEntity() {
        TacheEntity entity = new TacheEntity();
        entity.setName(getName());
        entity.setLastRealisation(getLastRealisation());
        entity.setInterval(getInterval());
        entity.setZone(getZone().toEntity());
        return entity;
    }
}