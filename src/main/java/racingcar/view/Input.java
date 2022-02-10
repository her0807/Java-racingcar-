package racingcar.view;

import java.util.Scanner;

import static racingcar.view.Output.*;

/**
 * - [ ] [ 예외 ] : `공백` - *(입력받은 문자열의 앞 뒤를 제거해준다.)*
 * - [ ] [ 예외 ] : 자동차가 `2대 미만`
 * - [ ] [ 예외 ] : 이름이 `중복`
 * - [ ] [ 예외 ] : `5글자 초과`
 */
public class Input {
    Scanner scan = new Scanner(System.in);

    private Input() {
    }

    public String carName() {
        try {
            Output.getCarName();
            String inputValue = scan.nextLine();
            if (inputValue.isBlank()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            String[] names = inputValue.split(",");
            if (names.length < 2) {
                throw new IllegalArgumentException("자동차를 두 개 이상 입력해주세요.");
            }
        } catch (IllegalArgumentException e) {
            return carName();
        }
    }
}
