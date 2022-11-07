package kodlama.io.Devs.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="technologies")
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor


public class Technology {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="technologyId")
	private int id;
	
	@Column(name="name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "software_language_id")
	private SoftwareLanguage softwareLanguage;
	
	
	
	
	
	
	
	
	
	
}
