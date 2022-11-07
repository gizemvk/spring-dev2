package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import kodlama.io.Devs.business.requests.languagerequests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languagerequests.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.languagerequests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageresponses.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.languageresponses.GetByIdLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.SoftwareLanguageRepository;
import kodlama.io.Devs.entities.concretes.SoftwareLanguage;

@Service
public class SoftwareLanguageManager implements SoftwareLanguageService {
	
	
	private SoftwareLanguageRepository softwareLanguageRepository;
	
    @Autowired
	public SoftwareLanguageManager(SoftwareLanguageRepository softwareLanguageRepository) {
	
		this.softwareLanguageRepository = softwareLanguageRepository;
	}

	
	@Override
	
	public List<GetAllLanguageResponse> getAll (){	
		
		List <SoftwareLanguage> softwareLanguages = softwareLanguageRepository.findAll();
		  List<GetAllLanguageResponse> LanguageResponses = new ArrayList<>();

	        for(SoftwareLanguage softwareLanguage : softwareLanguages){
	            GetAllLanguageResponse response = new GetAllLanguageResponse();
	            response.setName(softwareLanguage.getName());

	            LanguageResponses.add(response);
	        }

	        return LanguageResponses;
	
		
	}


	@Override
	public GetByIdLanguageResponse getById(int id) {
		SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(id).get();
		GetByIdLanguageResponse response = new GetByIdLanguageResponse() ;
		response.setName(softwareLanguage.getName());
		return response;
	}


	@Override
	public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
		
		SoftwareLanguage softwareLanguage = new SoftwareLanguage();
		
		 if(createLanguageRequest.getName().isBlank()){
			 
	            throw new Exception ("Lütfen bir isim giriniz.");
		 }
	            
	            else {
	            	for (SoftwareLanguage languages: softwareLanguageRepository.findAll()) {
	            		
	            		
	            		if ( languages.getName().equalsIgnoreCase(createLanguageRequest.getName())){
	            			
	            			throw new Exception ("Bu isim zaten mevcut.");
	            			
	            			
	            		}
	            		else {
	            			softwareLanguage.setName(createLanguageRequest.getName());
	            		}
	            	}
	            	
	            	
	            softwareLanguageRepository.save(softwareLanguage);

	            
	        }
		
	}


	@Override
	public void delete(DeleteLanguageRequest deleteLanguageRequest) {
	softwareLanguageRepository.deleteById(deleteLanguageRequest.getId());
		
	}


	@Override
	public void update(int id, UpdateLanguageRequest updateLanguageRequest) {
		if(!updateLanguageRequest.getName().isEmpty()) {
			SoftwareLanguage softwareLanguage = softwareLanguageRepository.findById(id).get();
			softwareLanguage.setName(updateLanguageRequest.getName());
			softwareLanguageRepository.save(softwareLanguage);
		}
		
	}
	


}
