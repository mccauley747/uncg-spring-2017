package bofforegister;

import events.BoffoEvent;
import events.BoffoListenerInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joshuabr7
 * Thanks for this groundwork, Quigley.
 */
public class BoffoBaseModule implements BoffoListenerInterface{
    private final List listeners = new ArrayList();

    public synchronized void addBRegisterListener(BoffoListenerInterface listener) {
        listeners.add(listener);
    }

    public synchronized void removeBRegisterListener(BoffoListenerInterface listener) {
        listeners.remove(listener);
    }

    protected synchronized void fireEvent(BoffoEvent event) {
        Object[] temp_list = this.listeners.toArray();
        for (Object temp_list1 : temp_list) {
            BoffoListenerInterface temp_obj = (BoffoListenerInterface) temp_list1;
            temp_obj.messageReceived(event);
        }
    }
    @Override
    public void messageReceived(BoffoEvent event) {
        System.out.println("Boffo Base Module doesn't implement messageReceived.");
    }

}
