package com.chegaai.voucherUsuario;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.chegaai.authentication.AuthenticationContext;
import com.chegaai.commons.DefaultEntity;
import com.chegaai.user.User;
import com.chegaai.voucher.Voucher;

@Entity
public class VoucherUsuario implements DefaultEntity {
	
	@Id
	private String id;	
	
	@OneToOne
	private Voucher voucher;
	
	@OneToOne
	private User usuario;
	
	private String indUtilizado;
		
	private VoucherUsuario() {
		id = UUID.randomUUID().toString();
		this.usuario = AuthenticationContext.getCurrentUser();
		this.indUtilizado = "N";
	}

	public VoucherUsuario(Voucher voucher) {
		this();		
		this.voucher = voucher;
	}
	
	public String getId() {
		return id;
	}
		
	public Voucher getVoucher() {
		return voucher;
	}
	
	public User getUsuario() {
		return usuario;
	}
	
	public String getIndUtilizado() {
		return indUtilizado;
	}
	
	public void setIndUtilizado(String indUtilizado) {
		this.indUtilizado = indUtilizado;
	}
		
}
