package br.com.loja.web;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class hometMB  {
	
	public hometMB() {
		System.out.println("chegou pelo menos");
	}
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
		
	}
	
	public void save() {
		System.out.println("aa" + test);
	}
}
