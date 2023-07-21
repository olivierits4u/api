package lu.its4u.api.domain;

import java.text.SimpleDateFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Date {
	private String date;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public Date() {
		this.date = sdf.format(new java.util.Date());
	}

}
