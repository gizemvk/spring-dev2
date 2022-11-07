package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entities.concretes.SoftwareLanguage;

public interface SoftwareLanguageRepository extends JpaRepository<SoftwareLanguage, Integer>{
	
	

}
 