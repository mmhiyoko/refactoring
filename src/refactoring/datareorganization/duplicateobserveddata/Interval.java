package refactoring.datareorganization.duplicateobserveddata;

import java.util.Observable;

class Interval extends Observable {
    String getEnd() {
        return _end;
    }

    void setEnd(String arg) {
        _end = arg;
        setChanged();
        notifyObservers();
    }

    private String _end = "0";
}
