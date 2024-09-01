package entity;

import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {
private UUID uuid;
private String login;
private String password;
}
