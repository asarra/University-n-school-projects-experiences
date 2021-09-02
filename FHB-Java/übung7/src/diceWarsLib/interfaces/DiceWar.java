package diceWarsLib.interfaces;

/**
 * Data Provider for the display of dice wars on the top left of the board.
 * Purpose of the display is a simulation of dice throws.
 *
 * <p>
 * Concrete specializations of this type must produce a sequence of dice values
 * for each call of {@link #nextAttackerSequence()} and {@link #nextDefenderSequence()}.
 * {@link #getAmountOfSequences()} defines the amount of calls.
 * If this visualization should be suppressed, return 0 as amount.
 * </p>
 */
public abstract class DiceWar {
    private final int attacker;
    private final int defender;

    public DiceWar(int attacker, int defender) {
        this.attacker = attacker;
        this.defender = defender;
    }

    public final int getAttacker() { return attacker; }
    public final int getDefender() { return defender; }

    /**
     * Amount of dices owned by the attacker tile.
     * @return A number greater than or equal 2.
     */
    public abstract int getAttackerDicesCount();

    /**
     * Amount of dices owned by the defending tile.
     * @return 1 or greater.
     */
    public abstract int getDefenderDicesCount();

    /**
     * Accesses the next sequence of {@link #getAttackerDicesCount()} dice values.
     * @return the intermediate dice throw results of the attacker.
     */
    public abstract int[] nextAttackerSequence();

    /**
     * Accesses the next sequence of {@link #getDefenderDicesCount()} dice values.
     * @return the intermediate dice throw results of the defender.
     */
    public abstract int[] nextDefenderSequence();

    /**
     * Defines how often the {@link diceWarsLib.game.DiceWarRound} calls the sequence generating methods.
     * @return a number defining how many intermediate dice values shall be visualized.
     */
    public abstract int getAmountOfSequences();

    /**
     * Access the final result for the attacker.
     * <p>
     * After {@link #getAmountOfSequences()} updates, the final value must have been produced.
     * That value should be the same as final result.
     * </p>
     * @return the attacker result.
     */
    public abstract int getAttackerResult();

    /**
     * Access the final result for the defender.
     * <p>
     * After {@link #getAmountOfSequences()} updates, the final value must have been produced.
     * That value should be the same as final result.
     * </p>
     * @return the defender result.
     */
    public abstract int getDefenderResult();
}
