package ohtu.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class WhiteSpaceValidator implements ConstraintValidator<WhiteSpaceless, String> {



    public WhiteSpaceValidator() {
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        return !t.matches(".*\\s.*");
    }

    @Override
    public void initialize(WhiteSpaceless whitespaceless) {
    }
}
