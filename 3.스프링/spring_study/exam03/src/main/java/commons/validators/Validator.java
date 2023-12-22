package commons.validators;

public interface Validator<T> {
    void validate(T value);
}
