package lk.bitwolfsolution.lms.mapper;

import lk.bitwolfsolution.lms.dto.BaseDTO;
import lk.bitwolfsolution.lms.model.BaseModel;

public abstract class GenericMapper <DOMAIN extends BaseModel, DTO extends BaseDTO>{
	
	public abstract DOMAIN dtoToDomain(DTO dto);
	
	public abstract DTO domainToDto(DOMAIN dto);
}
