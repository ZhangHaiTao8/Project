package com.shisizu.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * @author 袁红
 * @create 2020-04-06-14:44
 */
@Data
public class User {
    private Integer uid;
	private String uname;
	private String upassword;
	private String usex;
	private String uphone;
	private String uhead;
	private String uemail;
	public User(Integer uid, String uname, String upassword, String usex, String uphone, String uhead, String uemail) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upassword = upassword;
		this.usex = usex;
		this.uphone = uphone;
		this.uhead = uhead;
		this.uemail = uemail;
	}
    
}
