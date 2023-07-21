package lu.its4u.api.domain;

import java.text.SimpleDateFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Time {
	private String time;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private SimpleDateFormat sdf = new SimpleDateFormat("kk:mm:ss");

	public Time() {
		this.time = sdf.format(new java.util.Date());
	}

}