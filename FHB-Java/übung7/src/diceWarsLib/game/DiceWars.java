package diceWarsLib.game;

import diceWarsLib.data.RGB;
import diceWarsLib.data.Tile;
import diceWarsLib.interfaces.*;
import diceWarsLib.painting.DiceWarsPanel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Main class of the program.
 *     For more information, consult the documentation of the public methods and
 *     <ul>
 *        <li>
 *            the following abstract classes:
 *            <ul>
 *                <li>
 *                    {@link DiceWar} for a display of dice attacks on the top left of the screen
 *                </li>
 *                <li>
 *                    {@link FieldGenerator} which is the base class if you want to provide random fields
 *                </li>
 *           </ul>
 *        </li>
 *        <li>
 *            the following data classes:
 *            <ul>
 *                <li>
 *                    {@link diceWarsLib.data.Coordinate} holding screen coordinates
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.data.Position} holding indices
 *                </li>
 *                <li>
 *                     {@link diceWarsLib.data.Tile} representing a single field on the board
 *                </li>
 *                <li>
 *                     {@link diceWarsLib.data.RGB} being a color definition
 *                </li>
 *            </ul>
 *        </li>
 *        <li>
 *            the following interfaces (read/write access):
 *            <ul>
 *                <li>
 *                    {@link diceWarsLib.interfaces.BoardManager}
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.interfaces.TileManager}
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.interfaces.Clickable}
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.interfaces.EventProducer}
 *                </li>
 *            </ul>
 *        </li>
 *        <li>
 *            the following interfaces (need to be implemented):
 *            <ul>
 *                <li>
 *                    {@link diceWarsLib.interfaces.ButtonClickHandler}
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.interfaces.ClickHandler}
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.interfaces.EventHandler}
 *                </li>
 *                <li>
 *                    {@link diceWarsLib.interfaces.MenuHandler}
 *                </li>
 *            </ul>
 *        </li>
 *     </ul>
 *
 * Usage summary:
 * <ol>
 *     <li>Construct a game by instantiating this class</li>
 *     <li>Instantiate and register handlers for the different events (see above)</li>
 *     <li>Either, pass a field generator to {@link #reset(FieldGenerator, RGB[])}, or</li>
 *     <li>pass a custom created board to {@link #reset(Tile[][], RGB[])}, or</li>
 *     <li>generate an empty app with {@link #reset()}, then respond to menu clicks.</li>
 *     <li>Once a valid board has been generated, you may interact with the running app.</li>
 * </ol>
 * <b>Interaction:</b> on click, each registered {@link ClickHandler} is called.
 * To identify which tile was clicked on, consult the {@link TileManager} available via {@link #getTileManager()}.
 * <br>
 * There is also a button drawn on the board, which may be configured using the {@link BoardManager} available
 * via {@link #getBoardManager()}. Upon click, registered {@link ButtonClickHandler} objects are notified.
 * <br>
 * This and all other classes in the diceWarsLib package know nothing about game state or game logic.
 * It's entirely up to you to implement that. Most useful for visualization of game steps is {@link TileManager}.
 *
 * @author {@literal gysar.flegel@fh-bielefeld.de}
 * @author {@literal anestis-pere.lalidis_mateo@fh-bielefeld.de}
 * @author {@literal pkroos@fh-bielefeld.de}
 */
public final class DiceWars implements Clickable, EventProducer {

    private int fieldDimensions;
    private EventHandler eventHandler;

    private final ArrayList<ButtonClickHandler> buttonHandlers;
    private final ArrayList<ClickHandler> clickHandlers;

    private final BoardManager boardManager;
    private AtomicBoolean isLocked = new AtomicBoolean(true);

    /*
     * The gui instance used to draw the diceWarsLib.game
     */
    private DiceWarsPanel gui;

    /**
     * Resets the game board from the provided generator generate() method.
     * <p>
     *  The amount of entries in the colors array must be consistent with the
     *  specifications in the board generator.
     * </p>
     * @see FieldGenerator
     * @param boardGenerator is a provider of a computed (random) board.
     * @param colors is a list with a color spec for each player.
     */
    public void reset(FieldGenerator boardGenerator, RGB[] colors) {
        Tile[][] board = boardGenerator.generateAndValidate();
        reset(board, colors);
    }

    /**
     * Resets the game board as specified in the arguments.
     * <p>
     *  The amount of entries in the colors array must be consistent with the
     *  specifications in the board.
     * </p>
     * @param board is a custom computed board.
     * @param colors is a list with a color spec for each player.
     */
    public void reset(Tile[][] board, RGB[] colors) {
        isLocked.set(true);
        fieldDimensions = board.length;
        if (eventHandler != null) {
            eventHandler.onInit(board);
        }
        gui.initialize(board, colors, () -> enableInteractionsInMs(2000));
    }

    /**
     * Resets the game with an empty board.
     */
    public void reset() {
        reset(new Tile[][]{}, new RGB[]{});
    }

    /**
     * Creates a new instance of the game.
     */
    public DiceWars() {
        buttonHandlers = new ArrayList<>();
        clickHandlers = new ArrayList<>();
        gui = new DiceWarsPanel();

        // register wrappers, delegating a minimum of information to registered handlers
        gui.registerButtonListener(e -> notifyButtonHandlers());
        gui.registerMouseListener(new MouseListenerTemplate(this::notifyClickHandlers));

        boardManager = new BoardManager() {
            @Override
            public int getBoardDimensions() {
                return fieldDimensions;
            }

            @Override
            public void setButtonText(String text) {
                gui.changeButtonLabel(text);
            }

            @Override
            public void setInfoText(String text) {
                gui.setInfoText(text);
            }

            @Override
            public void setInfoTextColor(RGB color) {
                gui.setInfoTextColor(color);
            }

            @Override
            public void clearInfoText() {
                gui.setInfoText("");
            }

            @Override
            public void initializeDiceWar(DiceWar diceWar) {
                startDiceWar(diceWar);
            }
        };
    }

    /**
     * Register a handler for menu clicks.
     * @param menuHandler is the handler for load, save and new board events.
     */
    public void setMenuHandler(MenuHandler menuHandler) {
        gui.setMenuListener(menuHandler);
    }

    /**
     * Access the board manager of this class.
     * <p>
     *     Take caution when attempting to store values from the manager:
     *     the board manager instance itself not changed during calls to {@link #reset},
     *     but the values it produces might be.
     * </p>
     * @return the board manager of this class.
     */
    public BoardManager getBoardManager() {
        return boardManager;
    }

    /**
     * Access the board manager of this class.
     * <p>
     *     Take caution when attempting to store values from the manager:
     *     the board manager instance itself not changed during calls to {@link #reset},
     *     but the values it produces might be.
     * </p>
     * @return the board manager of this class.
     */
    public TileManager getTileManager() {
        return gui;
    }

    // begin of interface implementations

    @Override
    public void registerButtonClickHandler(ButtonClickHandler bch) {
        if (buttonHandlers.contains(bch)) return;
        buttonHandlers.add(bch);
    }

    @Override
    public void registerClickHandler(ClickHandler ch) {
        if (clickHandlers.contains(ch)) return;
        clickHandlers.add(ch);
    }

    @Override
    public void unregisterButtonClickHandler(ButtonClickHandler bch) {
        buttonHandlers.remove(bch);
    }

    @Override
    public void unregisterClickHandler(ClickHandler ch) {
        clickHandlers.remove(ch);
    }

    @Override
    public void setEventHandler(EventHandler eh) {
        if (eventHandler != null && eventHandler.equals(eh)) return;
        eventHandler = eh;
    }

    @Override
    public void unSetEventHandler() {
        eventHandler = null;
    }

    // rest is private implementation

    private void startDiceWar(DiceWar diceWar) {
        if (eventHandler != null) {
            eventHandler.onDiceWarBegin(diceWar);
        }
        this.isLocked.set(true);
        gui.enableDiceWarDisplay(diceWar.getAttacker(), diceWar.getDefender(), diceWar.getAttackerDicesCount(), diceWar.getDefenderDicesCount());
        new Thread(new DiceWarRound(diceWar, () -> this.endDiceWar(diceWar), this::updateDiceWar)).start();
    }

    private void endDiceWar(DiceWar diceWar) {
        this.isLocked.set(false);
        new Thread(() -> hideDiceWarDisplayInMs(2500)).start();
        if (eventHandler != null) {
            this.eventHandler.onDiceWarDone(diceWar, gui);
        }
    }

    private void hideDiceWarDisplayInMs(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Ignoring this error
            e.printStackTrace();
        }
        finally {
            gui.disableDiceWarDisplay();
        }
    }

    private void updateDiceWar(int[] attacker, int[] defender) {
        System.out.println("Attacker: " + Arrays.toString(attacker));
        System.out.println("Defender: " + Arrays.toString(defender));
        gui.updateDiceWarDisplay(attacker, defender);
    }

    private void notifyButtonHandlers() {
        if (isLocked.get()) return;
        buttonHandlers.forEach(ButtonClickHandler::onButtonClick);
    }

    private void notifyClickHandlers(int x, int y) {
        if (isLocked.get()) return;
        clickHandlers.forEach(h -> h.onClick(x, y));
    }

    private void enableInteractionsInMs(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // Ignoring this on purpose
            e.printStackTrace();
        }
        this.isLocked.set(false);
        if (eventHandler != null) {
            eventHandler.onStart(boardManager);
        }
    }
}
