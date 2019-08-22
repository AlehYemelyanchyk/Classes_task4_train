/*4. Создайте класс task4train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массиве из пяти элементов типа task4train, добавьте возможность сортировки элементов массива
по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами назначения
должны быть упорядоченны по времени отправления.*/

import java.util.Scanner;

public class TrainMain {

    public static void main(String[] args) {


        Train[] trains = new Train[6];
        trains[0] = new Train("Berlin", 22786, "10:30");
        trains[1] = new Train("Warsaw", 77886, "06:54");
        trains[2] = new Train("Berlin", 33861, "08:05");
        trains[3] = new Train("Minsk", 33754, "11:30");
        trains[4] = new Train("Berlin", 45268, "12:00");
        trains[5] = new Train("Minsk", 22146, "11:25");

        printTrains(trains);
        sortByTrainNumber(trains);
        System.out.println("=======================================");
        System.out.println("Sorted by numbers:");
        printTrains(trains);
        sortByDestination(trains);
        System.out.println("=======================================");
        System.out.println("Sorted alphabetically by destination:");
        printTrains(trains);

        printTrainInfo(trains);

    }

    public static void printTrainInfo(Train[] trains) {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter a task4train number: ");

        while (!sc.hasNextInt()) {
            sc.next();
        }

        int trainNumber = sc.nextInt();
        sc.nextLine();

        for (Train train : trains) {
            if (trainNumber == train.getTrainNumber()) {
                printTrains(train);
                return;
            }

        }

        System.out.println("The task4train has not found.");
    }

    private static void sortByDestination(Train[] trains) {

        boolean quit = false;

        while (!quit) {

            quit = true;

            for (int i = 1; i < trains.length; i++) {
                if (trains[i].getDestination().compareTo(trains[i - 1].getDestination()) < 0) {
                    Train temp = trains[i];
                    trains[i] = trains[i - 1];
                    trains[i - 1] = temp;

                    quit = false;
                } else if (trains[i].getDestination().compareTo(trains[i - 1].getDestination()) == 0) {
                    if (sortByDepartureTime(trains, i)) {
                        quit = false;
                    }
                }
            }
        }
    }

    private static boolean sortByDepartureTime(Train[] trains, int i) {

        String[] time1 = trains[i].getDepartureTime().split(":");
        String[] time2 = trains[i - 1].getDepartureTime().split(":");

        for (int j = 0; j < time1.length; j++) {
            if (Integer.parseInt(time1[j]) < Integer.parseInt(time2[j])) {
                Train temp = trains[i];
                trains[i] = trains[i - 1];
                trains[i - 1] = temp;

                return true;
            } else if (Integer.parseInt(time1[j]) > Integer.parseInt(time2[j])) {
                return false;
            }
        }
        return false;
    }

    private static void sortByTrainNumber(Train[] trains) {

        boolean quit = false;

        while (!quit) {

            quit = true;

            for (int i = 1; i < trains.length; i++) {
                if (trains[i].getTrainNumber() < trains[i - 1].getTrainNumber()) {
                    Train temp = trains[i];
                    trains[i] = trains[i - 1];
                    trains[i - 1] = temp;

                    quit = false;
                }
            }
        }
    }

    private static void printTrains(Train train) {

        System.out.println("task4train #" + train.getTrainNumber() + " to " +
                train.getDestination() + " departs at " + train.getDepartureTime());
    }

    private static void printTrains(Train[] trains) {

        for (Train train : trains) {
            System.out.println("task4train #" + train.getTrainNumber() + " to " +
                    train.getDestination() + " departs at " + train.getDepartureTime());
        }
    }
}
