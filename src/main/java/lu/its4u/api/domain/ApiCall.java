package lu.its4u.api.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiCall {

	private Long id;
	private Date callDate;
	private String source;
	private String target;

}
