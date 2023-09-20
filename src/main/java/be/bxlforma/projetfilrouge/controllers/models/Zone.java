package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.ClientEntity;
import be.bxlforma.projetfilrouge.dal.entities.ZoneEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Zone {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;
    private Client client;


    public static Zone fromEntity(ZoneEntity entity) {
        Zone.ZoneBuilder builder = new Zone.ZoneBuilder()
                .id(entity.getId())
                .name(entity.getName())
                .client(Client.fromEntity(entity.getClient()));

        return builder.build();
    }

    public ZoneEntity toEntity() {
        ZoneEntity entity = new ZoneEntity();
        entity.setName(getName());
        entity.setClient(getClient().toEntity());
        return entity;
    }
}