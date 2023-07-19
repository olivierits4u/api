package lu.its4u.api.basic.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallResponse {

	private Long id;
	private Date callDate;
	private String source;
	private String target;

}
