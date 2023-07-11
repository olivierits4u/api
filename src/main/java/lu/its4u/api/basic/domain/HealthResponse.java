package lu.its4u.api.basic.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HealthResponse {
	private String status;
	private final String OK = "ok";

	public HealthResponse() {
		this.status = OK;

	}
}
