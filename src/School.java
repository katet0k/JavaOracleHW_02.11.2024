import java.util.Random;

public class School extends AbstractBuilding {
    public enum AccreditationLevel {
        GENERAL_EDUCATION, GYMNASIUM, LYCEUM
    }

    private AccreditationLevel accreditationLevel;
    private int students;

    public School(String address, AccreditationLevel level) {
        super(address);
        this.accreditationLevel = level;
        this.students = generateStudentCount(level);
    }

    private int generateStudentCount(AccreditationLevel level) {
        Random random = new Random();
        return switch (level) {
            case GENERAL_EDUCATION -> random.nextInt(300) + 200;
            case GYMNASIUM -> random.nextInt(200) + 100;
            case LYCEUM -> random.nextInt(100) + 50;
        };
    }

    @Override
    public void setFieldsFromString(String input) {
        try {
            this.accreditationLevel = AccreditationLevel.valueOf(input.trim().toUpperCase());
            this.students = generateStudentCount(this.accreditationLevel);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: неверный уровень аккредитации.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Школа, Адрес: " + address + ", Уровень аккредитации: " + accreditationLevel + ", Количество учеников: " + students);
    }
}