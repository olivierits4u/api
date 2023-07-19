package lu.its4u.api.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "api_call")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApiCallEntity {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Date callDate;
	private String source;
	private String target;

}
