package br.com.ada.adabook.dto.user;

import br.com.ada.adabook.domain.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class UserSaveDTO {
    @NotBlank(message = "First name is a required field")
    private String firstName;
    @NotBlank(message = "Last name is a required field")
    private String lastName;
    @NotBlank(message = "Email is a required field")
    @Email
    @JsonProperty("email")
    private String login;
    @NotBlank(message = "Password is a required field")
    private String password;
    @NotBlank(message = "Code is a required field")
    @Pattern(regexp = "[\\d]{5}-[\\d]{3}", message = "invalid code")
    private String code;
    private String number;
    private String complement;
    private Set<Role> role;
}
