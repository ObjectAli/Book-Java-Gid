package org.api.bank.validation;

import java.util.ArrayList;
import java.util.List;

/**
 * Данный класс написан в соответствии с шаблоном "уведомления" для решения задачи коллекционирования ошибок
 */
public class Notification {

    List<String> errors = new ArrayList<>();

    public void addError(final String message) {
        errors.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public String errorMessage() {
        return errors.toString();
    }

    public List<String> getErrors() {
        return this.errors;
    }
}