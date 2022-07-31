package t2009m1springboot.entity.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class AccountRegisterDto {
    private long id;
    private String Username;
    private String password;
    private String confirmPassword;
    private int role;
}
