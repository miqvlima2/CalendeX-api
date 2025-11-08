package validators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import requests.CreateUserRequest;

public class PasswordsMatchValidator implements ConstraintValidator<PasswordsMatch, CreateUserRequest> {
    
    @Override
    public boolean isValid(CreateUserRequest request, ConstraintValidatorContext context) {
        if (request == null) {
            return true; // validation will be handled by @NotBlank anyway
        }

        boolean matches = request.password().equals(request.passwordConfirmation());

        if (!matches) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Passwords must match")
                   .addPropertyNode("passwordConfirmation")
                   .addConstraintViolation();
        }

        return matches;
    }
}