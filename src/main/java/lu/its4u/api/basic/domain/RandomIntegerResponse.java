package lu.its4u.api.basic.domain;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RandomIntegerResponse {

	private int value;

	private int generate() {
		Random r = new Random();
		return ((r.nextInt(Integer.MAX_VALUE - 1)) * (System.currentTimeMillis() % 2 == 0 ? 1 : -1));
	}

	public RandomIntegerResponse() {
		this.value = generate();
	}
}
