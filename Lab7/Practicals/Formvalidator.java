import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class SignupForm {
    @NotBlank
    String name = "";

    @NotBlank
    @MaxLength(10)
    String username = "verylongusername";

    @MaxLength(15)
    String city = "Ahmedabad";
}

public class Formvalidator {
    public static void main(String[] args) throws Exception {
        SignupForm form = new SignupForm();
        List<String> errors = new ArrayList<>();

        for (Field f : form.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            String value = (String) f.get(form);

            if (f.isAnnotationPresent(NotBlank.class)) {
                if (value == null || value.trim().isEmpty()) {
                    errors.add(f.getName() + " cannot be blank");
                }
            }

            if (f.isAnnotationPresent(MaxLength.class)) {
                int max = f.getAnnotation(MaxLength.class).value();

                if (value != null && value.length() > max) {
                    errors.add(f.getName() + " exceeds " + max + " characters");
                }
            }
        }

        if (errors.isEmpty()) {
            System.out.println("Form is valid");
        } else {
            for (String error : errors) {
                System.out.println(error);
            }
        }
    }
}
