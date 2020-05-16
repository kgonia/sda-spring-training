package pl.sda.sdaspringtraining.api.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class DriverLicenseValidator implements ConstraintValidator<ValidDriverLicense, String> {
    @Override
    public void initialize(ValidDriverLicense constraintAnnotation) {

    }

    @Override
    public boolean isValid(String number, ConstraintValidatorContext constraintValidatorContext) {
        if (number == null || number.isEmpty()) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Driver license number cannot be empty");
            return false;
        }
        if (number.length() != 10) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Driver license number length must equal 10");
            return false;
        }
        if (!is3FirstChars(number)) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Driver license number starts with 3 letters");
            return false;
        }

        if (!validChecksum(number)) {
            constraintValidatorContext.buildConstraintViolationWithTemplate("Driver license number must have right checksum");
            return false;
        }

        return false;
    }

    private boolean validChecksum(String number) {
        String numbersPart = number.substring(3);
        String[] numbers = numbersPart.split("");
        boolean allAreNumbers = Arrays.stream(numbers).allMatch(sn -> Character.isDigit(sn.toCharArray()[0]));
        if (!allAreNumbers) {
            return false;
        }
        int sum = Arrays.stream(numbers).mapToInt(Integer::valueOf).sum();
        return sum % 3 == 0;
    }

    private boolean is3FirstChars(String number) {
        String maybeChars = number.substring(0, 3);
        for (char maybeChar: maybeChars.toCharArray()) {
            if (!Character.isLetter(maybeChar)) {
                return false;
            }
        }
        return true;
    }
}
