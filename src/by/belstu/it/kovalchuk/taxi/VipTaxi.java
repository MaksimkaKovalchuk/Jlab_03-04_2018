package by.belstu.it.kovalchuk.taxi;

import org.apache.log4j.*;
import org.w3c.dom.NamedNodeMap;

public class VipTaxi extends Taxi implements Parser{

    private final static Logger LOG = Logger.getLogger(VipTaxi.class);

    public enum categoryCar
    {
        mercedes, bentley, bmw, audi;
    }

    private categoryCar _categoryCar;

    public VipTaxi() {
        this._uId = this._id++;
        LOG.info("Вызван конструктор VipTaxi (без параметров)");
    }

    public VipTaxi(int _speed, int _gasMileage, int _cost, categoryCar _categoryCar) {
        super(_speed, _gasMileage, _cost);
        this._categoryCar = _categoryCar;
        LOG.info("Вызван констурктор VipTaxi (с параметрами)");
    }

    public categoryCar get_categoryCar() { return _categoryCar; }

    public void set_categoryCar(categoryCar _categoryCar)
    {
        this._categoryCar = _categoryCar;
    }

    @Override
    public Parser ParserXml(NamedNodeMap attributes) { return null; }

    @Override
    public String toString() {
        return "VipTaxi{" +
                "id="+this._uId +
                "_speed=" + _speed +
                ", _cost=" + _cost +
                ", _gasMileage=" + _gasMileage +
                ", _categoryCar=" + _categoryCar +
                '}';
    }
}
