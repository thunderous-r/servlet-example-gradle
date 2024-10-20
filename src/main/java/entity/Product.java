package entity;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Product {
    @Generated
    private Integer id;
    private String name;
    private String imgSrc;
    private UUID ownerId;
}
