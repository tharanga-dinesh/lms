package lk.bitwolfsolution.lms.model.admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lk.bitwolfsolution.lms.model.BaseModel;

@Entity
@Table(name = "tbl_user_credential")
public class UserCredential extends BaseModel {

	private static final long serialVersionUID = -6785180180068422534L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "tbl_user_credential_s") 
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(name = "password")
	private String password;
}
