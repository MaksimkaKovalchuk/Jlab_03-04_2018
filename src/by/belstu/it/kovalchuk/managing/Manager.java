package by.belstu.it.kovalchuk.managing;

import by.belstu.it.kovalchuk.taxi.Taxi;
import by.belstu.it.kovalchuk.taxi.CargoTaxi;
import by.belstu.it.kovalchuk.taxi.CheapTaxi;
import by.belstu.it.kovalchuk.taxi.VipTaxi;
import by.belstu.it.kovalchuk.taxiStation.TaxiStation;
import org.apache.log4j.Category;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Manager {
    private final static Logger LOG = Logger.getLogger(Manager.class);

    private static Manager instance;
    private TaxiStation _taxiStation;

    public static Manager getInstance()
    {
        if (instance == null)
            instance = new Manager();
        return instance;
    }

    public TaxiStation generateTaxiStation(TaxiStation taxiStation, int maxCargoTaxi, int maxCheapTaxi, int maxVipTaxi)
    {
        _taxiStation = taxiStation;
        Random rnd = new Random(System.currentTimeMillis());
        for (int i = 0; i < maxCargoTaxi; i++)
            try
            {
                _taxiStation.Add(new CargoTaxi(rnd.nextInt(100), rnd.nextInt(100), rnd.nextInt(150),
                        new CargoTaxi.DeliveryTime(rnd.nextInt(24), rnd.nextInt(60), rnd.nextInt(31),
                                rnd.nextInt(12), rnd.nextInt(2018))));
            } catch (Exception e) {
                LOG.trace(e);
            }

        for (int i = 0; i < maxCheapTaxi; i++)
            _taxiStation.Add(new CheapTaxi(rnd.nextInt(200), rnd.nextInt(50), rnd.nextInt(100),
                    rnd.nextInt(4)));

        for (int i = 0; i < maxVipTaxi; i++)
            _taxiStation.Add(new VipTaxi(rnd.nextInt(300), rnd.nextInt(100),
                    rnd.nextInt(200), VipTaxi.categoryCar.audi));


        return _taxiStation;
    }


    public int CostTaxiStation() {
        int cost = 0;
        for (Taxi taxi :
                _taxiStation.get_taxiList()) {
            cost += taxi.get_cost();
        }
        return cost;
    }

    public void SortTaxiStation() {
        LOG.info("Выполняем сортировку...");
        Collections.sort(_taxiStation.get_taxiList(), new Comparator<Taxi>() {
            @Override
            public int compare(Taxi o1, Taxi o2) {
                int o1Gas = o1.get_gasMileage();
                int o2Gas = o2.get_gasMileage();
                if (o1Gas > o2Gas) return 1;
                else if (o1Gas < o2Gas) return -1;
                else return 0;
            }
        });
    }

    public void ShowSpeedTaxi(int speed1, int speed2) {
        LOG.info("Вывести машины в диапозоне скорости (200-400):");
        for (Taxi taxi :
                _taxiStation.get_taxiList()) {
            if (speed1 < taxi.get_speed() && taxi.get_speed() < speed2)
                LOG.info(taxi.toString());
        }
    }

    public void ShowStation(){
        LOG.info("Вывести весь парк на экране: ");
        for (Taxi taxi:
                _taxiStation.get_taxiList()) {
            LOG.info(taxi.toString());
        }
    }

}
