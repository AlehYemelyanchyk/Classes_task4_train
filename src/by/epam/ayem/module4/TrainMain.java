package by.epam.ayem.module4;

/*4. Создайте класс Train, содержащий поля: название пункта назначения, номер поезда, время
отправления. Создайте данные в массиве из пяти элементов типа Train, добавьте возможность
сортировки элементов массива по номерам поездов. Добавьте возможность вывода информации о поезде,
номер которого введен пользователем. Добавьте возможность сортировки массива по пункту назначения,
причем поезда с одинаковыми пунктами назначения должны быть упорядоченны по времени отправления.*/

import java.util.Scanner;

public class TrainMain {

    private Train[] trains = new Train[5];

    public void run() {

        trains[0] = new Train("Berlin", 22786, "10:30");
        trains[1] = new Train("Warsaw", 77886, "06:54");
        trains[2] = new Train("Berlin", 33861, "08:05");
        trains[3] = new Train("Minsk", 33754, "11:30");
        trains[4] = new Train("Berlin", 45268, "12:00");

        printTrains();
        sortByTrainNumber();
        System.out.println("=======================================");
        System.out.println("Sorted by numbers:");
        printTrains();
        sortByDestination();
        System.out.println("=======================================");
        System.out.println("Sorted alphabetically by destination:");
        printTrains();

        printTrainInfo();
    }

    private void printTrainInfo() {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("Enter a train number: ");

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
        System.out.println("The train has not found.");
    }

    private void sortByDestination() {

        boolean quit = false;

        while (!quit) {

            quit = true;

            for (int i = 1; i < trains.length; i++) {
                if (trains[i].getDestination().compareTo(trains[i - 1].getDestination()) < 0) {
                    swap(i);

                    quit = false;
                } else if (trains[i].getDestination().compareTo(trains[i - 1].getDestination()) == 0) {
                    if (sortByDepartureTime(i)) {
                        quit = false;
                    }
                }
            }
        }
    }

    private boolean sortByDepartureTime(int i) {

        String[] time1 = trains[i].getDepartureTime().split(":");
        String[] time2 = trains[i - 1].getDepartureTime().split(":");

        for (int j = 0; j < trains.length; j++) {
            if (Integer.parseInt(time1[j]) < Integer.parseInt(time2[j])) {
                swap(i);

                return true;
            } else if (Integer.parseInt(time1[j]) > Integer.parseInt(time2[j])) {
                return false;
            }
        }
        return false;
    }

    private void sortByTrainNumber() {

        boolean quit = false;

        while (!quit) {

            quit = true;

            for (int i = 1; i < trains.length; i++) {
                if (trains[i].getTrainNumber() < trains[i - 1].getTrainNumber()) {
                    swap(i);

                    quit = false;
                }
            }
        }
    }

    private void swap(int i) {
        Train temp = trains[i];
        trains[i] = trains[i - 1];
        trains[i - 1] = temp;
    }

    private void printTrains(Train train) {

        System.out.println("Train #" + train.getTrainNumber() + " to " +
                train.getDestination() + " departs at " + train.getDepartureTime());
    }

    private void printTrains() {

        for (Train train : trains) {
            System.out.println("Train #" + train.getTrainNumber() + " to " +
                    train.getDestination() + " departs at " + train.getDepartureTime());
        }
    }
}
