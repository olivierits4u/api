package lu.its4u.api.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Health {
	private String status;
	private final String OK = "ok";

	public Health() {
		this.status = OK;

	}
}
