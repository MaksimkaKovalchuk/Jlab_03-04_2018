package by.belstu.it.kovalchuk.taxi;

import java.lang.Exception;
import org.apache.log4j.*;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;


public class CargoTaxi extends Taxi {
    private static final Logger LOG = Logger.getLogger(CargoTaxi.class);

    private  DeliveryTime _date;

    public CargoTaxi()
    {
        this._uId=this._id++;
        LOG.info("Вызван конструктор CargoTaxi (без параметров)");
    }

    public CargoTaxi(int _speed, int _gasMileage, int _cost, DeliveryTime _date)
    {
        super(_speed, _gasMileage, _cost);
        set_date(_date);
        LOG.info("Вызван конструктор CargoTaxi (с параметрами)");
    }

    public void setData (int hour, int minute, int day, int mouth, int year)
    {
        try
        {
            _date = new DeliveryTime(hour, minute, day, mouth, year);
        } catch (Exception e) {
            e.printStackTrace(); //dodelat'
        }
    }

    public void set_date(DeliveryTime _date) {
        this._date = _date;
    }

    public DeliveryTime get_date() { return _date; }

    @Override
    public String toString()
    {
        return "CargoTaxi{" +
                "id= " + this._uId +
                ", data= " + this._date.toString() +
                ", speed= " + this._speed +
                ", gasMilege= " + this._gasMileage +
                ", cost= " + this._cost +
                '}';
    }

    public static class DeliveryTime {
        private int _hour;
        private int _minute;
        private int _day;
        private int _mouth;
        private int _year;

        public DeliveryTime(int _hour, int _minute, int _day, int _mouth, int _year) throws Exception {
            if (!CheckData(_hour, _minute, _day, _mouth, _year)) {
                throw new Exception("Дата заданна неверно.");
            }
            this._hour = _hour;
            this._minute = _minute;
            this._day = _day;
            this._mouth = _mouth;
            this._year = _year;
        }

        private boolean CheckData(int hour, int minute, int day, int mouth, int year) {
            boolean check;
            check = 0 < hour && hour < 24 ? true : false;
            check = 0 < minute && minute < 60 ? true : false;
            check = 1 < day && day < 31 ? true : false;
            check = 1 < mouth && mouth < 12 ? true : false;
            check = year < 2018 ? true : false;
            return check;
        }

        @Override
        public String toString() {
            return "DeliveryTime{" +
                    "_hour=" + _hour +
                    ", _minute=" + _minute +
                    ", _day=" + _day +
                    ", _mouth=" + _mouth +
                    ", _year=" + _year +
                    '}';
        }
    }
}
