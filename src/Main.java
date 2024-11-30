import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Street street = new Street("Примерная улица");

        // Добавляем здания
        street.addBuilding(new ResidentialHouse("Дом 1", 50));
        street.addBuilding(new Shop("Магазин 1", List.of("Продукты", "Электроника")));
        street.addBuilding(new School("Школа 1", School.AccreditationLevel.LYCEUM));

        // Меню
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Показать информацию по улице");
            System.out.println("2. Добавить здание");
            System.out.println("3. Удалить здание");
            System.out.println("4. Найти магазины рядом с домом");
            System.out.println("0. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Сброс буфера

            switch (choice) {
                case 1 -> street.displayStreetInfo();
                case 2 -> {
                    System.out.print("Введите адрес: ");
                    String address = scanner.nextLine();
                    street.addBuilding(new ResidentialHouse(address, 30)); // Пример добавления дома
                }
                case 3 -> {
                    System.out.print("Введите адрес для удаления: ");
                    String address = scanner.nextLine();
                    street.removeBuilding(address);
                }
                case 4 -> {
                    System.out.print("Введите адрес жилого дома: ");
                    String houseAddress = scanner.nextLine();
                    System.out.print("Введите тип отдела: ");
                    String departmentType = scanner.nextLine();
                    street.findShopsNearHouse(houseAddress, departmentType, 1);
                }
                case 0 -> {
                    System.out.println("Выход.");
                    return;
                }
                default -> System.out.println("Неверный выбор.");
            }
        }
    }
}