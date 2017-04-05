package bofforegister;

import events.BoffoEvent;
import events.BoffoListenerInterface;

/**
 *
 * @author joshuabr7
 * Thanks for this groundwork, Quigley.
 */
public interface BoffoBaseModule {
    final BoffoListenerInterface listener = null;
    
    //Maybe not have add and remove register.
    void addBRegisterListener(BoffoListenerInterface listener);

    void removeBRegisterListener(BoffoListenerInterface listener);

    void fireEvent(BoffoEvent event);

    public void messageReceived(BoffoEvent event);
}
