package lu.its4u.api.basic.domain;

import java.text.SimpleDateFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TimeResponse {
	private String time;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");

	public TimeResponse() {
		this.time = sdf.format(new java.util.Date());
	}

}