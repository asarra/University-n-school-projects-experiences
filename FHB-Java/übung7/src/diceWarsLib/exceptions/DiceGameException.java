package diceWarsLib.exceptions;

/**
 *  Defines a thin wrapper exception for context specific information.
 */
public class DiceGameException extends IllegalArgumentException {
    public DiceGameException(String errorMessage) {
        super(errorMessage);
    }
}
