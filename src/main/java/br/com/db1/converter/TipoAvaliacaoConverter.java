package br.com.db1.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.db1.model.TipoAvaliacao;

@FacesConverter(forClass = TipoAvaliacao.class)
public class TipoAvaliacaoConverter implements Converter {
	
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		if (value != null && !value.isEmpty()) {
			return (TipoAvaliacao) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		if (value instanceof TipoAvaliacao) {
			TipoAvaliacao entity = (TipoAvaliacao) value;
			if (entity != null && entity instanceof TipoAvaliacao && entity.getId() != null) {
				uiComponent.getAttributes().put(entity.getId().toString(), entity);
				return entity.getId().toString();
			}
		}
		return "";
	}
	
}
