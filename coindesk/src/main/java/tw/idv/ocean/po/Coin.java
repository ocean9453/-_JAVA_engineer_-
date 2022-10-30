package tw.idv.ocean.po;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Coin {
	@Id
	private String code;
	private String chiName;
}
