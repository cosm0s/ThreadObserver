package cosm0s.observers;

import java.util.Observable;
import java.util.Observer;

public class ObjectSpy implements Observer {
    @Override
    public void update(Observable observable, Object o) {
        System.out.println("This object: " + this + " observable: " + observable +" event -> " + o);
    }
}
