package diceWarsLib.interfaces;

/**
 * Interface responsible for delegation of button click events.
 *
 * @author {@literal gysar.flegel@fh-bielefeld.de}
 * @author {@literal anestis-pere.lalidis_mateo@fh-bielefeld.de}
 * @author {@literal pkroos@fh-bielefeld.de}
 */
public interface ButtonClickHandler {

	/**
	 * For registered handlers, this method is called on each click on the button on the bottom right.
	 */
	void onButtonClick();
}
