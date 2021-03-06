
package ohtu.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotNull;
@Documented
@Target({ FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Constraint(validatedBy = { WhiteSpaceValidator.class })
@Retention(RUNTIME)
@ReportAsSingleViolation
@NotNull
public @interface WhiteSpaceless {

    String message() default "Field must not contain whitespaces";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
