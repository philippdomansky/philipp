package labam;



import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DataCars {

    public static void main(String[] args) {
        System.out.println("========================Введите информацию про автомобили========================");
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во автомобилей -> ");
        int count = sc.nextInt();
        sc.nextLine();

        InfoCars[] ic = new InfoCars[count];


        for (int i = 0; i < ic.length; i++) {
            ic[i] = new InfoCars();

            System.out.println("Введите модель автомобиля -> ");
            ic[i].model = sc.next();


            System.out.println("Введите регистрационный номер автомобиля -> ");
            ic[i].regNumber = sc.nextInt();


            System.out.println("Введите год выпуска автомобиля -> ");
            ic[i].yearIssue = sc.nextInt();


            System.out.println("Введите пробег автомобиля -> ");
            ic[i].mileage = sc.nextInt();

            System.out.println("Введите стоимость автомобиля -> ");
            ic[i].cost = sc.nextInt();


        }
        infoCars(ic);
        System.out.println("\nМинимальная стоимость автомобиля ");
        minCostCar(ic);
        System.out.println("\nСортировка по убыванию:");
        sortCar(ic);
        System.out.println("\nВведите регистрационный номер автомобиля - ");
        searchInfoRegNumber(ic);
        System.out.println("\nЧто вы хотите изменить ? \n1) - Регистрационный номер\n2) - Модель машины\n3) - Год выпуска");
        changeInfo(ic);

    }
    public static void infoCars(InfoCars[] ic) {
        for (int i = 0; i < ic.length; i++) {
            System.out.println(" " + ic[i].model + "\t" + ic[i].regNumber + "\t" + ic[i].yearIssue + "\t" + ic[i].mileage + "\t" + ic[i].cost);

        }
        return;

    }
    public static void minCostCar(InfoCars[] ic) {

        int nommin = 0;
        double min = ic[nommin].cost;
        for (int i = 0; i < ic.length; i++)
            if (ic[i].cost < min) {
                min = ic[i].cost;
                nommin = i;

            }


        System.out.println("" + ic[nommin].model + "\t" + ic[nommin].cost);

            return;

    }
    public static void sortCar(InfoCars[] ic) {
        Integer[] integerArray = new Integer[ic.length];

        for (int i = 0; i < ic.length; i++) {
            integerArray[i] = ic[i].yearIssue;
        }

        Arrays.sort(integerArray, Collections.reverseOrder());

        for(int i = 0; i < integerArray.length; i++) {
            System.out.println(integerArray[i]);
        }
        return;
    }
    public static void searchInfoRegNumber(InfoCars[] ic) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int nom = -1;

        for (int i = 0; i < ic.length; i++)
            if (name.equalsIgnoreCase(String.valueOf(ic[i].regNumber))) nom = i;

        if (nom != -1) {
            System.out.println("Такой рег. номер существует в списке - " + "\nМодель машины -  " + ic[nom].model + "\nРегистрационный номер - " + ic[nom].regNumber);

        } else {
            System.out.println("Такого рег. номера не существует");
        }
        return;

    }
    public static void changeInfo(InfoCars[] ic) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();

        System.out.println("Введите какой именно массив обьекта хотите изменить(от 0 до ..) - ");
        int nom = sc.nextInt();


        switch (number) {
            case 1:
                System.out.println("Введите новый регистрационный номер - " + ic[nom].regNumber);
                sc.nextLine();
                ic[nom].regNumber = sc.nextInt();

                System.out.println("Название изменено! " + ic[nom].regNumber);
                break;
            case 2:
                System.out.println("Введите новую модель машины - " + ic[nom].model);
                sc.nextLine();
                ic[nom].model = sc.nextLine();
                System.out.println("Новая модель машины изменена на - " + ic[nom].model);
                break;
            case 3:
                System.out.println("Введите новый год выпуска - " + ic[nom].yearIssue);
                sc.nextLine();
                ic[nom].yearIssue = sc.nextInt();
                System.out.println("Новый год выпуска изменён на - " + ic[nom].yearIssue);


        }

    }
}
