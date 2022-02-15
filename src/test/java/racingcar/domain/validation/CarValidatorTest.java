package racingcar.domain.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.util.Constant;

class CarValidatorTest {

	@DisplayName("자동차 이름 공백 테스트")
	@ParameterizedTest
	@ValueSource(strings = {" "})
	void car_name_empty(String name) {
		assertThatThrownBy(() -> {
			CarValidator.carValid(name);
		}).isInstanceOf(IllegalArgumentException.class).hasMessage(String.format(Constant.CAR_BLANK_ERROR_MESSAGE,"공백"));
	}

	@DisplayName("자동차 이름 null 테스트")
	@Test
	void car_name_null() {
		assertThatThrownBy(() -> {
			CarValidator.carValid(null);
		}).isInstanceOf(NullPointerException.class).hasMessage("자동차 이름은 null 일 수 없습니다.");
	}

	@DisplayName("자동차 이름 길이 테스트")
	@Test
	void car_name_length() {
		assertThatThrownBy(() -> {
			CarValidator.carValid("gooddd");
		}).isInstanceOf(IllegalArgumentException.class).hasMessage("자동차의 이름은 5글자를 초과할 수 없습니다.");
	}
}