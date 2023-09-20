package be.bxlforma.projetfilrouge.controllers.models;

import be.bxlforma.projetfilrouge.dal.entities.PhotoEntity;

import be.bxlforma.projetfilrouge.dal.entities.TravailEntity;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.Builder;
import lombok.Setter;
import lombok.Getter;

@Builder
@Setter
@Getter
public class Photo {

    private Integer id;

    private String photo;
    private Travail travail;

    public static Photo fromEntity(PhotoEntity entity) {
        Photo.PhotoBuilder builder = new PhotoBuilder()
                .id(entity.getId())
                .photo(entity.getPhoto())
                .travail(Travail.fromEntity(entity.getTravail()));

        return builder.build();
    }

    public PhotoEntity toEntity() {
        PhotoEntity entity = new PhotoEntity();
        entity.setPhoto(getPhoto());
        entity.setTravail(getTravail().toEntity());

        return entity;
    }
}