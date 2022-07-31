package t2009m1springboot.entity.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AccountLoginDto {
    private long id;
    private String username;
    private String password;
    private String confirmPassword;
    private int role;
}
