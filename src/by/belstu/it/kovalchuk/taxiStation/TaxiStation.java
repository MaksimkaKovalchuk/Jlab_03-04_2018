package by.belstu.it.kovalchuk.taxiStation;

import by.belstu.it.kovalchuk.taxi.Taxi;

import java.util.ArrayList;

public class TaxiStation {
    private ArrayList<Taxi> _taxiList = new ArrayList<Taxi>();

    public TaxiStation() {
    }

    public TaxiStation(ArrayList<Taxi> _taxiList) {
        this._taxiList = _taxiList;
    }

    public ArrayList<Taxi> get_taxiList() {
        return _taxiList;
    }

    public void set_taxiList(ArrayList<Taxi> _taxiList) {
        this._taxiList = _taxiList;
    }

    public boolean Add(Taxi taxi){
        return _taxiList.add(taxi);
    }

    public  boolean Remove (Taxi taxi){
        return _taxiList.remove(taxi);
    }

    @Override
    public String toString() {
        return "TaxiStation{" +
                "_taxiList=" + _taxiList +
                '}';
    }

}
