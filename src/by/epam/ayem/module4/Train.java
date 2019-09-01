package by.epam.ayem.module4;
/*4. Создайте класс task4train, содержащий поля: название пункта назначения, номер поезда, время отправления.
Создайте данные в массиве из пяти элементов типа task4train, добавьте возможность сортировки элементов массива
по номерам поездов. Добавьте возможность вывода информации о поезде, номер которого введен пользователем.
Добавьте возможность сортировки массива по пункту назначения, причем поезда с одинаковыми пунктами назначения
должны быть упорядоченны по времени отправления.*/

public class Train {

    private String destination;
    private int trainNumber;
    private String departureTime;

    Train(String destination, int trainNumber, String departureTime) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
    }

    String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    int getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(int trainNumber) {
        this.trainNumber = trainNumber;
    }

    String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}


