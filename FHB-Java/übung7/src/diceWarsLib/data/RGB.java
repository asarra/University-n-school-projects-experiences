package diceWarsLib.data;

/**
 * A thin wrapper around a color spec.
 */
public final class RGB {
    final public int r;
    final public int g;
    final public int b;

    /**
     * Construct a color spec from rgb-values [0, 255]
     * @param r red
     * @param g green
     * @param b blue
     */
    public RGB(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }
}
