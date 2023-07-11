package lu.its4u.api.basic.domain;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RandomFloatResponse {

	private float value;

	private float generate() {
		Random r = new Random();
		return r.nextFloat() * (Float.MAX_VALUE) * (System.currentTimeMillis() % 2 == 0 ? 1 : -1);

	}

	public RandomFloatResponse() {
		this.value = generate();
		System.out.println(value);
	}
}
