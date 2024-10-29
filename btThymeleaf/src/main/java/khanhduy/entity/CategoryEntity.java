package khanhduy.entity;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.mapping.PersistentEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class CategoryEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long categoryID;
	@Column(name = "category_name", length = 200, columnDefinition = "nvarchar(200) not null")
	private String name;
	
	@SuppressWarnings("rawtypes")
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private Set<PersistentEntity> products;
	

}
