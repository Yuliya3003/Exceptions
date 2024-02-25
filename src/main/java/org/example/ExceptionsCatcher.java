package org.example;

public class ExceptionsCatcher {

    public ExceptionsCatcher() {
    }

    public void checkDataQuantity(String str, String validator) throws DataQuantityMismatchException {
        switch (validator) {
            case "fio":
                String[] elemOfFio = str.split(" ");
                if (elemOfFio.length != 3) {
                    throw new DataQuantityMismatchException("Неверное количество слов в ФИО");
                }
                break;
            case "birthday":
                String[] date = str.split("\\.");
                if (date[0].length() != 2 || date[1].length() != 2 || date[2].length() != 4) {
                    throw new DataQuantityMismatchException("Неверное количество цифр в дате");
                }
                break;
            case "number":
                if (str.length() != 11) {
                    throw new DataQuantityMismatchException("Неверное количество цифр в номере телефона");
                }
                break;
            case "sex":
                if (str.length() != 1) {
                    throw new DataQuantityMismatchException("Пол нужно обозначить одним символом");
                }
                break;
            default:
                System.out.println("Неверный валидатор");
                break;
        }
    }

    public void checkDataQuality(String str, String validator) throws DataQualityException {
        switch (validator) {
            case "fio":
                if (!str.matches("[a-zA-Zа-яА-Я\\s]+")) {
                    throw new DataQualityException("В ФИО не может быть ничего кроме букв");
                }
                break;
            case "birthday":
                if (!(str.matches("[0-9.]+"))) {
                    throw new DataQualityException("Дата не может содержать ничего кроме цифр и .");
                } else {
                    String[] elem = str.split("\\.");
                    if (Integer.parseInt(elem[0]) > 31 || Integer.parseInt(elem[0]) < 1) {
                        throw new DataQualityException("Неверно введен день месяца");
                    }
                    if (Integer.parseInt(elem[1]) < 1 && Integer.parseInt(elem[1]) > 12) {
                        throw new DataQualityException("Неверно введен месяц");
                    }
                    if (Integer.parseInt(elem[2]) > 2024) {
                        throw new DataQualityException("Неверно введен год рождения");
                    }
                }
                break;
            case "number":
                if (!(str.matches("[0-9]+"))) {
                    throw new DataQualityException("Номер не может содержать ничего кроме цифр");
                }
                break;
            case "sex":
                if (!str.equals("f") && !str.equals("m")) {
                    throw new DataQualityException("Пол можно задать только символами f и m");
                }
                break;
            default:
                System.out.println("Неверный валидатор");
                break;
        }
    }

}
