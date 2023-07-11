package lu.its4u.api.basic.domain;

import java.text.SimpleDateFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DateResponse {
	private String date;
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

	public DateResponse() {
		this.date = sdf.format(new java.util.Date());
	}

}
