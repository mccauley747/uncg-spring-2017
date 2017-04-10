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
public interface BoffoBaseModule {
    final List boffoListener = new ArrayList();
    public void addBRegisterListener(BoffoListenerInterface _event);
    public void removeBRegisterListener(BoffoListenerInterface _event);
    public void fireEvent(BoffoEvent _event);
}
