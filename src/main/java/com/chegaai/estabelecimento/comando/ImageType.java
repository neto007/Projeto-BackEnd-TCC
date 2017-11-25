package com.chegaai.estabelecimento.comando;

import java.io.Serializable;

public class ImageType implements Serializable {
	private static final long serialVersionUID = 1L;

	private String base64;
	private String filename;
	private String filetype;
	private String filesize;

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getFilename() {
		return filename;
	}
	
	public String getFiletype() {
		return filetype;
	}
	
	public String getFilesize() {
		return filesize;
	}
		
	public String getBase64() {
		return base64;
	}
	public void setBase64(String base64) {
		this.base64 = "data:image/png;base64," + base64;
	}
}
