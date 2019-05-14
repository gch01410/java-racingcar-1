import domain.GameProgressService;
import domain.GameResult;
import domain.RandomNumberStrategy;
import domain.WinnerCars;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        List<String> names = InputView.inputNames();
        int gameRound = InputView.inputRound();

        GameProgressService gameProgressService = new GameProgressService(new RandomNumberStrategy(), names);
        GameResult gameResult = null;

        System.out.println("실행 결과");

        for (int i = 1; i <= gameRound; i++) {
            gameResult = gameProgressService.raceByRound(gameResult);
            OutputView.printPosition(gameResult);
            System.out.println();
        }

        WinnerCars winnerCars = new WinnerCars(gameResult.getWinners());
        OutputView.printWinners(winnerCars);
    }
}
