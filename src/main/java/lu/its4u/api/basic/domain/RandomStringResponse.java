package lu.its4u.api.basic.domain;

import java.util.Random;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RandomStringResponse {

	private String randomString;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	int leftLimit = 65;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	int rightLimit = 122;

	private String generateRandomString(int length) {

		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(length).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

	}

	public RandomStringResponse() {
		this.randomString = generateRandomString(10);
	}

	public RandomStringResponse(int length) {
		this.randomString = generateRandomString(length);
	}

}
