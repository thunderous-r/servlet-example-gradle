package entity;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class Product {
    private UUID id;
    private String name;
    private String imgSrc;
    private UUID ownerId;
}
