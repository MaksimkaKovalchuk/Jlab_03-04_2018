package by.belstu.it.kovalchuk.taxi;

import org.apache.log4j.*;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

public abstract class Taxi {

    private  static final Logger LOG = Logger.getLogger(Taxi.class);

    protected static int _id;
    protected int _uId;
    protected int _speed;
    protected int _cost;
    protected int _gasMileage;


    public Taxi()
    {
        this._id++;
        LOG.info("Вызван конструктор Taxi (без параметров)");
    }

    public Taxi (int _speed, int _gasMileage, int _cost)
    {
        this._uId = this._id;
        this._id++;
        this._speed = _speed;
        this._gasMileage = _gasMileage;
        this._cost = _cost;
        LOG.info("Вызван конструктор Taxi (c параметрами)");
    }

    public int get_speed() { return _speed; }

    public void set_speed(int _speed)
    {
        this._speed = _speed;
    }

    public int get_gasMileage() { return _gasMileage; }

    public void set_gasMileage(int _gasMileage)
    {
        this._gasMileage = _gasMileage;
    }

    public int get_cost() { return _cost; }

    public void set_cost(int _cost)
    {
        this._cost = _cost;
    }

    public int[] GetAtributeArray(NamedNodeMap attributes) {
        int[] array = new int[3];
        for (int i = 0; i < array.length; i++) {
            Node attribute = attributes.item(i);
            array[i] = Integer.parseInt(attribute.getNodeValue());
        }
        return array;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "id="+this._uId +
                "_speed=" + _speed +
                ", _cost=" + _cost +
                ", _gasMileage=" + _gasMileage +
                '}';
    }

}
