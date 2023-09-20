package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.ClientEntity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Client {

    private Integer id;

    @NotBlank
    @Length(max = 100)
    private String name;

    public static Client fromEntity(ClientEntity entity) {
        Client.ClientBuilder builder = new Client.ClientBuilder()
                .id(entity.getId())
                .name(entity.getName());

        return builder.build();
    }

    public ClientEntity toEntity() {
        ClientEntity entity = new ClientEntity();
        entity.setName(getName());
        return entity;
    }
}