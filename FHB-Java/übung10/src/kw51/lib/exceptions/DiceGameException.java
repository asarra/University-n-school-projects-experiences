package kw51.lib.exceptions;

/**
 *  Defines a thin wrapper exception for context specific information.
 */
@SuppressWarnings("serial")
public class DiceGameException extends IllegalArgumentException {
    public DiceGameException(String errorMessage) {
        super(errorMessage);
    }
}
