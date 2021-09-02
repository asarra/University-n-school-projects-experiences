package diceWarsLib.interfaces;

/**
 * Definition of the methods used to set/unset the single event handler of the game.
 */
public interface EventProducer {
    /**
     * Register the argument as event handler. This replaces previously registered handlers.
     * @param eh is the new event handler.
     */
    void setEventHandler(EventHandler eh);

    /**
     * Unregister a registered event handler.
     */
    void unSetEventHandler();
}
