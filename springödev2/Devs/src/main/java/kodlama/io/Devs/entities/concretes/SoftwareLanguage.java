package kodlama.io.Devs.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "softwareLanguage")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity




public class SoftwareLanguage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( name= "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	
	@OneToMany
	private List<Technology> tecnologies;
	
	
	
	
	
	
}
