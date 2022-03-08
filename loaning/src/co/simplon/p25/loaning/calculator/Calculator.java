/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * Exposes a single calculate method.
 */
public interface Calculator {

    /**
     * The calculate method to be implemented with specific schedule calculation.
     *
     * @return a schedule; never null
     */
    Schedule calculate();
}
