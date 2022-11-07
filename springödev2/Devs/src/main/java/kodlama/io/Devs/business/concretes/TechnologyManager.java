package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.TechnologyService;
import kodlama.io.Devs.business.requests.technologyrequests.CreateTechnologyRequest;
import kodlama.io.Devs.business.requests.technologyrequests.DeleteTechnologyRequest;
import kodlama.io.Devs.business.requests.technologyrequests.UpdateTechnologyRequest;
import kodlama.io.Devs.business.responses.technologyresponses.GetAllTechnologyResponse;
import kodlama.io.Devs.dataAccess.abstracts.SoftwareLanguageRepository;
import kodlama.io.Devs.dataAccess.abstracts.TechnologyRepository;
import kodlama.io.Devs.entities.concretes.SoftwareLanguage;
import kodlama.io.Devs.entities.concretes.Technology;


@Service
public class TechnologyManager implements TechnologyService {
	
	
	private TechnologyRepository technologyRepository;
	private SoftwareLanguageRepository softwareLanguageREpository;

	public TechnologyManager(TechnologyRepository technologyRepository,
			SoftwareLanguageRepository softwareLanguageREpository) {
		super();
		this.technologyRepository = technologyRepository;
		this.softwareLanguageREpository = softwareLanguageREpository;
	}

	@Override
	public List<GetAllTechnologyResponse> getAll() {
		List<Technology> technologies = technologyRepository.findAll();
		List<GetAllTechnologyResponse> responses = new ArrayList<>();
		for ( Technology technology: technologies) {
			
			GetAllTechnologyResponse response = new GetAllTechnologyResponse();
			
			response.setLanguageName(technology.getSoftwareLanguage().getName());
			response.setName(technology.getName());
			
			responses.add(response);
			
		}
	
		return responses;
	}

	@Override
	public void add(CreateTechnologyRequest createTechnologyRequest) {
		 Technology technology = new Technology();
		
		SoftwareLanguage softwareLanguage = softwareLanguageREpository.findById(createTechnologyRequest.getLanguageId()).get();
		technology.setName(createTechnologyRequest.getName());
		technology.setSoftwareLanguage(softwareLanguage);
		technologyRepository.save(technology);
		
		
		
	}

	@Override
	public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
	technologyRepository.deleteById(deleteTechnologyRequest.getId());
		
	}

	@Override
	public void update(int id, UpdateTechnologyRequest updateTechnologyRequest) {
		Technology technology =technologyRepository.findById(id).get();
		SoftwareLanguage softwareLanguage = softwareLanguageREpository.findById(updateTechnologyRequest.getLanguageId()).get();
		technology.setName(updateTechnologyRequest.getName());
		technology.setSoftwareLanguage(softwareLanguage);
		technologyRepository.save(technology);
		
	}

}
