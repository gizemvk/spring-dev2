package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.technologyrequests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technologyrequests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technologyrequests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.technologyresponses.GetAllTechnologyResponse;

public interface TechnologyService {
	
	List<GetAllTechnologyResponse> getAll();
	void add (CreateTechnologyRequest createTechnologyRequest);
	void delete (DeleteTechnologyRequest deleteTechnologyRequest);
	void update (int id, UpdateTechnologyRequest updateTechnologyRequest);
	
	

}
