package ohtu.validator;

import java.lang.annotation.Annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import ohtu.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReferenceValidator implements ConstraintValidator<Unique, String> {

    static ReferenceService references;

    @Autowired
    public ReferenceValidator(ReferenceService references) {
        this.references = references;
    }

    public ReferenceValidator() {
    }

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        System.out.println("references asd! " + references);
        return references.findByRefid(t) == null;
    }

    @Override
    public void initialize(Unique unique) {
    }
}
