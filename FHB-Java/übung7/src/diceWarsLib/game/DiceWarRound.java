package diceWarsLib.game;

import diceWarsLib.interfaces.DiceWar;

import java.util.function.BiConsumer;
import java.util.stream.IntStream;

public class DiceWarRound implements Runnable {
    private final DiceWar diceWar;
    private final Runnable onDoneHandler;
    private final BiConsumer<int[], int[]> onNewSequences;

    DiceWarRound(DiceWar source, Runnable onDone, BiConsumer<int[], int[]> onNewSequences) {
        this.diceWar = source;
        this.onDoneHandler = onDone;
        this.onNewSequences = onNewSequences;
    }

    @Override
    public void run() {
        System.out.println("DiceWar started");
        int sequences = diceWar.getAmountOfSequences();
        if (sequences > 0) {
            final int maxDelayMs = 350;
            final int minDelayMs = 20;
            final int step = (maxDelayMs - minDelayMs) / sequences;
            int[] delays = IntStream.range(0, sequences).map(i -> minDelayMs + step * i).toArray();
            for (int i = 0; i < sequences; i++) {
                int[] attackerSequence = diceWar.nextAttackerSequence();
                int[] defenderSequence = diceWar.nextDefenderSequence();
                onNewSequences.accept(attackerSequence, defenderSequence);
                try {
                    Thread.sleep(delays[i]);
                } catch (InterruptedException e) {
                    // Not handling this error
                    e.printStackTrace();
                }
            }
        }
        onDoneHandler.run();
    }
}
