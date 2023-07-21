package lu.its4u.api.domain;

import java.text.SimpleDateFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DateTime {
	private String dateTime;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy kk:mm:ss");

	public DateTime() {
		this.dateTime = sdf.format(new java.util.Date());
	}

}