package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.languagerequests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languagerequests.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.languagerequests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageresponses.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.languageresponses.GetByIdLanguageResponse;
import kodlama.io.Devs.entities.concretes.SoftwareLanguage;

public interface SoftwareLanguageService {
	
	
	
	List<GetAllLanguageResponse> getAll();
    GetByIdLanguageResponse getById(int id);
    void add (CreateLanguageRequest createLanguageRequest) throws Exception;
    void delete (DeleteLanguageRequest deleteLanguageRequest);
    void update(int id, UpdateLanguageRequest updateLanguageRequest);
	
	

}
