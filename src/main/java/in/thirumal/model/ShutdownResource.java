package in.thirumal.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @author Thirumal
 */
@Getter@Setter
@NoArgsConstructor@AllArgsConstructor
@Builder@ToString
public class ShutdownResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1264097390414814176L;
	
	private String message;
}
