package com.domain.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.domain.model.Kisi;
@Named("bean")
@ConversationScoped
public class KisiMB implements Serializable{
private static final long serialVersionUID=1L;
@Inject
	private Kisi kisi;
@Inject
	private Conversation conversation;
	private List<Kisi>kisiler=new ArrayList<Kisi>();
	
	public String ekle() {
		if (kisiler.isEmpty()) {
			conversation.begin();
		}
		kisiler.add(kisi);
		sil();
		return null;
	}
	public String dur() {
		conversation.end();
		return null;
	}
	private void sil() {
		kisi=new Kisi();
	}
	
	
	
	public Kisi getKisi() {
		return kisi;
	}

	public void setKisi(Kisi kisi) {
		this.kisi = kisi;
	}

	public List<Kisi> getKisiler() {
		return kisiler;
	}

	public void setKisiler(List<Kisi> kisiler) {
		this.kisiler = kisiler;
	}


	


}
