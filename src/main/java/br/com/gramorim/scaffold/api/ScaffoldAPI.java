package br.com.gramorim.scaffold.api;

import br.com.gramorim.scaffold.domain.MasterTemplate;
import br.com.gramorim.scaffold.domain.Template;

public interface ScaffoldAPI {
	
	String getTemplates();
	String getMasterTemplates();
	void criaTemplate(Template template);
	void criaMasterTemplate(MasterTemplate masterTemplate);
	void alteraTemplate(Template template);
	void alterMasterTemplate(MasterTemplate masterTemplate);
	

}
