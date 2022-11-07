package kodlama.io.Devs.business.requests.technologyrequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateTechnologyRequest {
	
	private String name;
	private int languageId;

}
