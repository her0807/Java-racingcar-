package racingcar.view;

import racingcar.domain.Attempt;
import racingcar.domain.Cars;

import java.util.Scanner;

public class Input {
	private static final String DELIMITER = ",";
	private static final Scanner scan = new Scanner(System.in);

	private Input() {
	}

	public static Cars insertCarName() {
		try {
			Output.showCarName();
			String inputValue = scan.nextLine();
			String[] names = inputValue.split(DELIMITER);
			return new Cars(names);
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return insertCarName();
		}
	}

	public static Attempt insertAttempt() {
		try {
			Output.showAttempt();
			String inputValue = scan.nextLine();
			return new Attempt(inputValue);
		} catch (IllegalArgumentException e) {
			Output.errorMessage(e.getMessage());
			return insertAttempt();
		}
	}
}
