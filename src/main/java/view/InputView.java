package view;

import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class InputView {
    private static final int MINIMUM_PARTICIPANT = 2;
    private static final int LIMIT_NAME_LENGTH = 5;
    private static final String CAR_NAME_SPLIT_REGULAR_EXPRESSION = "\\s*,\\s*";

    private static Scanner scanner = new Scanner(System.in);

    private static String input() {
        return scanner.nextLine();
    }

    public static List<String> inputNames() {
        String[] names;

        do {
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            names = input().trim().split(CAR_NAME_SPLIT_REGULAR_EXPRESSION);
        } while (isInValidNames(names));

        return new ArrayList<>(Arrays.asList(names));
    }

    private static boolean isInValidNames(String[] names) {
        for (String name : names) {
            if (StringUtils.isBlank(name) || isInValidNameLength(name)) {
                return true;
            }
        }

        return isInValidCarNumber(names) || isDuplicatedName(names);
    }

    private static boolean isInValidNameLength(String name) {
        return name.length() > LIMIT_NAME_LENGTH;
    }

    private static boolean isInValidCarNumber(String[] names) {
        return names.length < MINIMUM_PARTICIPANT;
    }

    private static boolean isDuplicatedName(String[] names) {
        Set<String> nonDuplicatedNames = new HashSet<>(Arrays.asList(names));

        return nonDuplicatedNames.size() != names.length;
    }

    public static int inputRound() {
        String round;

        do {
            System.out.println("시도할 회수는 몇회인가요?");
            round = input().trim();
        } while (isInValidRound(round));

        return Integer.parseInt(round);
    }

    private static boolean isInValidRound(String round) {
        boolean isInValid = true;

        if (isInteger(round) && isPositiveNumber(round)) {
            isInValid = false;
        }

        return isInValid;
    }

    private static boolean isInteger(String number) {
        boolean result = true;

        try {
            Integer.parseInt(number);
        } catch (NumberFormatException nfe) {
            result = false;
        }

        return result;
    }

    private static boolean isPositiveNumber(String number) {
        return Integer.parseInt(number) > 0;
    }
}
