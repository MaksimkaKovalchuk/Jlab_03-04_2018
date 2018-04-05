package by.belstu.it.kovalchuk.main;

import by.belstu.it.kovalchuk.taxi.CargoTaxi;
import by.belstu.it.kovalchuk.managing.Manager;
import by.belstu.it.kovalchuk.taxiStation.TaxiStation;


import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) throws ParserConfigurationException,
            IOException, SAXException, Exception {
        CargoTaxi cargoTaxi = new CargoTaxi(1, 2, 3,
                new CargoTaxi.DeliveryTime(12, 12, 12, 12, 1212));
        LOG.info(cargoTaxi.toString());
        try {
            LOG.info("\n\nStarting program_____________________________");
            Menu();
            LOG.info("End program__________________________________");
        } catch (Exception ex) {
            LOG.error(ex);
        }

    }


    public static void Menu() throws Exception {
        TaxiStation taxiStation = null;
        Manager manager = null;
        Scanner in = new Scanner(System.in);
        int i = 0, vipCount = 0, cargoCount = 0, cheapCount = 0;
        while (i != 7) {
            System.out.println("Меню");
            System.out.println("1. Создать станцию");
            System.out.println("2. Создать менеджера");
            System.out.println("3. Рандомно заполнить станцию");
            System.out.println("4. Общая стоимость");
            System.out.println("5. Сортировка");
            System.out.println("6. Вывести машины в диапозоне скорости");
            System.out.println("7. Вывести весь парк на экран");
            System.out.println("8. Выход");
            i = in.nextInt();
            switch (i) {
                case 1:
                    taxiStation = new TaxiStation();
                    break;
                case 2:
                    manager = Manager.getInstance();
                    break;
                case 3:
                    if (manager == null && taxiStation == null)
                        throw new Exception("Переменные не инициализированны");
                    try {
                        System.out.println("Введите колличество Vip такси: ");
                        vipCount = in.nextInt();
                        System.out.println("Введите колличество обычных такси: ");
                        cargoCount = in.nextInt();
                        System.out.println("Введите колличество грузовых такси: ");
                        cheapCount = in.nextInt();
                        manager.generateTaxiStation(taxiStation, cargoCount, cheapCount, vipCount);
                    } catch (Exception e) {
                        LOG.error(e);
                        System.out.println(e.getMessage());
                    }

                    break;
                case 4:
                    if (manager == null || taxiStation == null)
                        throw new Exception("Переменные не инициализированны");
                    LOG.info("Общая стоимость: " + manager.CostTaxiStation());
                    break;
                case 5:
                    if (manager == null || taxiStation == null)
                        throw new Exception("Переменные не инициализированны");
                    manager.SortTaxiStation();
                    break;
                case 6:
                    if (manager == null || taxiStation == null)
                        throw new Exception("Переменные не инициализированны");
                    manager.ShowSpeedTaxi(200, 400);
                    break;
                case 7:
                    if (manager == null || taxiStation == null)
                        throw new Exception("Переменные не инициализированны");
                    manager.ShowStation();
                    break;
                case 8:
                    LOG.info("______________________Ending");
                    System.exit(0);
            }
        }

    }

}
