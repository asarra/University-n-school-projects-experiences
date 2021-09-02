package kw51.lib.game;

import kw51.lib.data.Tile;
import kw51.lib.exceptions.DiceGameException;

/**
 * This is the base for random field generators.
 * Implementing classes must respect the constants defined in this class.
 */
public abstract class FieldGenerator {
    /**
     * Minimum allowed amount of players.
     */
    public static final int MIN_PLAYERS = 2;

    /**
     * Maximum allowed amount of players.
     */
    public static final int MAX_PLAYERS = 4;

    /**
     * Minimum allowed amount of fields per player.
     */
    public static final int MIN_FIELDS_PER_PLAYER = 3;

    /**
     * Maximum allowed amount of fields per player.
     */
    public static final int MAX_FIELDS_PER_PLAYER = 6;

    /**
     * Minimum allowed average amount of dices per field.
     */
    public static final int MIN_AVG_DICES = 3;

    /**
     * Minimum allowed average amount of dices per field.
     */
    public static final int MAX_AVG_DICES = 5;

    protected final int players;
    protected final int fieldsPerPlayer;
    protected final int dicesPerPlayer;

    private boolean inRange(int value, int min, int max) {
        return value >= min && value < max;
    }

    /**
     * Constructs a board generator.
     * Upon construction, the passed values are validated according to the constants of this class.
     * @param players is the amount of players.
     * @param fieldsPerPlayer is the amount of fields each player shall occupy.
     * @param dicesPerPlayer is the amount of dices each player shall have.
     */
    protected FieldGenerator(int players, int fieldsPerPlayer, int dicesPerPlayer) {
        this.players = players;
        this.fieldsPerPlayer = fieldsPerPlayer;
        this.dicesPerPlayer = dicesPerPlayer;
        this.validate();
    }

    private final void validate() {
        boolean playersOk = inRange(players, MIN_PLAYERS, MAX_PLAYERS+1);
        boolean fieldsOk = inRange(fieldsPerPlayer, MIN_FIELDS_PER_PLAYER, MAX_FIELDS_PER_PLAYER+1);
        int avgDices = dicesPerPlayer / fieldsPerPlayer;
        boolean dicesOk = inRange(avgDices, MIN_AVG_DICES, MAX_AVG_DICES+1);
        
        if (!(playersOk && fieldsOk && dicesOk)) {
            var error = String.format("Generating Board not possible with args [%d, %d]",
                    players, fieldsPerPlayer);
            throw new DiceGameException(error);
        }
    }

    Tile[][] generateAndValidate() {
        Tile[][] board = generate();
        int[] playerFields = new int[players];
        int[] playerDices = new int[players];
        for (Tile[] row: board) {
            for (Tile tile: row) {
                if (tile.getPlayer() == -1) continue;

                if (tile.getDices() < 1) {
                    throw new DiceGameException("Tile without dices is not allowed.");
                }
                if (tile.getPlayer() >= players) {
                    throw new DiceGameException("Tile player out of range.");
                }

                playerFields[tile.getPlayer()]++;
                playerDices[tile.getPlayer()] += tile.getDices();
            }
        }
        int fieldsPlayerZero = playerFields[0];
        int dicesPlayerZero = playerDices[0];
        for (int fields: playerFields) {
            if (fields != fieldsPlayerZero) {
                throw new DiceGameException("Players must have an equal amount of tiles.");
            }
        }
        for (int dices: playerDices) {
            if (dices != dicesPlayerZero) {
                throw new DiceGameException("Players must have an equal amount of dices.");
            }
        }
        return board;
    }

    /**
     * Generates a random field setup.
     * <p>
     *     The board must satisfy the requirements defined by the constants in this class.
     *     E.g., at least two but at most 4 players may be defined.<br>
     *     Additionally, each player must have the same amount of tiles.<br>
     *     To achieve that, you may leave tiles unoccupied by setting the player attribute to -1.<br>
     *     Also, each player must have the same amount of total dices, distributed over the board
     *     in an arbitrary way.
     * </p>
     * <p>
     *     The first index of the generated board is interpreted as y, or row. I.e. if a generated
     *     board specifies a tile for player 3 with 4 dices in the third row, second column, this tile
     *     would be accessed as follows:<br>
     *         <code>Tile[][] board = generator.generate();</code><br>
     *         <code>Tile tile = board[2][3];</code>
     * </p>
     * @return a board
     */
    protected abstract Tile[][] generate();
}
