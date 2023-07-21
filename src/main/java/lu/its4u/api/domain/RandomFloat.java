package lu.its4u.api.domain;

import java.util.Random;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RandomFloat {

	private float value;

	private float generate() {
		Random r = new Random();
		return r.nextFloat() * (Float.MAX_VALUE) * (System.currentTimeMillis() % 2 == 0 ? 1 : -1);

	}

	public RandomFloat() {
		this.value = generate();
		System.out.println(value);
	}
}
