package kw51.lib.interfaces;

/**
 * A Clickable is able to produce events for {@link ButtonClickHandler} and {@link ClickHandler} objects.
 */
public interface Clickable {
    /**
     * Registers a handler to be called for clicks on the button on the bottom right.
     * @param bch is the handler.
     */
    void registerButtonClickHandler(ButtonClickHandler bch);

    /**
     * Registers a handler to be called for clicks on the board.
     * @param ch is the handler.
     */
    void registerClickHandler(ClickHandler ch);

    /**
     * Unregisters a handler previously registered for clicks on the button on the bottom right.
     * @param bch is the handler.
     */
    void unregisterButtonClickHandler(ButtonClickHandler bch);

    /**
     * Unregisters a handler previously registered to be called for clicks on the board.
     * @param ch is the handler.
     */
    void unregisterClickHandler(ClickHandler ch);
}
