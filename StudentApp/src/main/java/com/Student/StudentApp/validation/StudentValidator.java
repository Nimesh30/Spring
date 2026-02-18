package com.Student.StudentApp.validation;

import com.Student.StudentApp.entities.Student;
import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Validator class for Student entity
 * Validates all required fields, age constraints, and email format
 */
public class StudentValidator {

    // Email regex pattern for validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final int MIN_AGE = 18;
    private static final String DATE_FORMAT = "dd/MM/yyyy";

    /**
     * Validates a Student object
     * @param student Student object to validate
     * @return ValidationResult containing validation status and error messages
     */
    public static ValidationResult validate(Student student) {
        List<String> errors = new ArrayList<>();

        if (student == null) {
            errors.add("Student object cannot be null");
            return new ValidationResult(false, errors);
        }

        // Validate required fields
        if (student.getFirstName() == null || student.getFirstName().trim().isEmpty()) {
            errors.add("First name is required");
        }

        if (student.getLastName() == null || student.getLastName().trim().isEmpty()) {
            errors.add("Last name is required");
        }

        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            errors.add("Email is required");
        } else if (!isValidEmail(student.getEmail())) {
            errors.add("Email format is invalid");
        }

        if (student.getDob() == null || student.getDob().trim().isEmpty()) {
            errors.add("Date of birth is required");
        } else if (!isValidAge(student.getDob())) {
            errors.add("Age must be 18 or greater than 18");
        }

        if (student.getGender() == null || student.getGender().trim().isEmpty()) {
            errors.add("Gender is required");
        }

        if (student.getAdmissionDate() == null) {
            errors.add("Admission date is required");
        }

        if (student.getClassName() == null || student.getClassName().trim().isEmpty()) {
            errors.add("Class name is required");
        }

        if (student.getCity() == null || student.getCity().trim().isEmpty()) {
            errors.add("City is required");
        }

        if (student.getStateCode() == null || student.getStateCode().trim().isEmpty()) {
            errors.add("State code is required");
        }

        if (student.getCountry() == null || student.getCountry().trim().isEmpty()) {
            errors.add("Country is required");
        }

        return new ValidationResult(errors.isEmpty(), errors);
    }

    /**
     * Validates email format
     * @param email Email to validate
     * @return true if email format is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return EMAIL_PATTERN.matcher(email).matches();
    }

    /**
     * Validates age based on date of birth
     * @param dob Date of birth in format dd/MM/yyyy
     * @return true if age is 18 or greater, false otherwise
     */
    public static boolean isValidAge(String dob) {
        if (dob == null || dob.trim().isEmpty()) {
            return false;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            LocalDate today = LocalDate.now();
            int age = today.getYear() - birthDate.getYear();

            // Adjust age if birthday hasn't occurred this year
            if (today.getMonthValue() < birthDate.getMonthValue() ||
                (today.getMonthValue() == birthDate.getMonthValue() && today.getDayOfMonth() < birthDate.getDayOfMonth())) {
                age--;
            }

            return age >= MIN_AGE;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * Inner class to hold validation results
     */
    @Getter
    public static class ValidationResult {
        private final List<String> errors;

        public ValidationResult(boolean isValid, List<String> errors) {
            this.errors = errors;
        }

        public String getErrorMessage() {
            return String.join(", ", errors);
        }
    }
}

