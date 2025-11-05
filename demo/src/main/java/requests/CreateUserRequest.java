package requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import validators.PasswordsMatch;

@PasswordsMatch
public record CreateUserRequest(
    @NotBlank
    @Size(min = 3, max = 20, message = "Nickname must be between 3 and 20 characters")
    String nickname,

    @NotBlank
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters long")
    String password,

    @NotBlank
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters long")
    String passwordConfirmation   
) {}