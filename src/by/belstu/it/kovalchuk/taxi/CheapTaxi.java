package by.belstu.it.kovalchuk.taxi;

import org.apache.log4j.Logger;
import org.w3c.dom.NamedNodeMap;

public class CheapTaxi extends Taxi implements Parser {

    private final static Logger LOG = Logger.getLogger(CheapTaxi.class);

    private int _door;

    public CheapTaxi() {
        this._uId = this._id++;
        LOG.info("Вызван конструктор CheapTaxi (без параметров)");
    }

    public CheapTaxi(int _speed, int _gasMileage, int _cost, int _door) {
        super(_speed, _gasMileage, _cost);
        this._door = _door;
        LOG.info("Вызван конструктор CheapTaxi (с параметрами)");
    }

    public int get_door() { return _door; }

    public void set_door(int _door)
    {
        this._door = _door;
    }

    @Override
    public Parser ParserXml(NamedNodeMap attributes) {
       int [] array = GetAtributeArray(attributes);
       return new CheapTaxi(array[0], array[1], array[2], array[3]);
    }

    @Override
    public String toString() {
        return "CheapTaxi{" +
                "id="+this._uId +
                "_speed=" + _speed +
                ", _cost=" + _cost +
                ", _gasMileage=" + _gasMileage +
                ", _door=" + _door +
                '}';
    }
}
