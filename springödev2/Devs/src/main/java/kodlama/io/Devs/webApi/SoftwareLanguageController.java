package kodlama.io.Devs.webApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.SoftwareLanguageService;
import kodlama.io.Devs.business.requests.languagerequests.CreateLanguageRequest;
import kodlama.io.Devs.business.requests.languagerequests.DeleteLanguageRequest;
import kodlama.io.Devs.business.requests.languagerequests.UpdateLanguageRequest;
import kodlama.io.Devs.business.responses.languageresponses.GetAllLanguageResponse;
import kodlama.io.Devs.business.responses.languageresponses.GetByIdLanguageResponse;
import kodlama.io.Devs.entities.concretes.SoftwareLanguage;

@RestController
@RequestMapping("/api/softwarelanguage")

public class SoftwareLanguageController {
	
	
	private SoftwareLanguageService softwareLanguageService;
	
     @Autowired
	public SoftwareLanguageController(SoftwareLanguageService softwareLanguageService) {
	
		this.softwareLanguageService = softwareLanguageService;
	}
	
     @GetMapping("/getall")
      public List<GetAllLanguageResponse> getAll(){
    	 return softwareLanguageService.getAll();
    	  
      }
	
     @GetMapping("/{id}")
	 public GetByIdLanguageResponse getById(int id) {
    	 return softwareLanguageService.getById(id);
		
	}
	
     @PostMapping
	 public void add (CreateLanguageRequest createLanguageRequest) throws Exception {
    	 
    	 this.softwareLanguageService.add(createLanguageRequest);
    	 
     }
	
    @DeleteMapping ("/{id}")
	
    public void deleteById (DeleteLanguageRequest deleteLanguageRequest) {
    	softwareLanguageService.delete(deleteLanguageRequest);
    }
	
    @PutMapping ("/{id}")
    public void updateById (int id, UpdateLanguageRequest updateLanguageRequest) {
    	softwareLanguageService.update(id, updateLanguageRequest);
    }
    
    
    
    
    
    
}
