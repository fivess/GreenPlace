package bean;

import javax.faces.bean.ManagedBean;
import model.Delivery;
import dao.DeliveryItemDao;
import javax.faces.context.FacesContext;
import javax.faces.context.ExternalContext;
import java.io.IOException;
import javax.faces.application.FacesMessage;

import java.util.List;

@ManagedBean 
public class DeliveryListBean {
	
	private Delivery delivery = new Delivery();
	private Long buscaId;
	private Delivery busca;
	
	public void adicionar() throws IOException {
		if(isInvalid()) {
			return;
		}
		new DeliveryItemDao().adiciona(this.delivery);
		this.delivery = new Delivery();
		redirectToItems();
	}

	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}
	
	public void setBuscaId(Long id) {
		this.buscaId = id;
	}
	
	public Long getBuscaId() {
		return buscaId;
	}
	
	

	public List<Delivery> getDeliveries() {
		if (busca != null) {
			return List.of(busca);
		}
		return new DeliveryItemDao().busqueTodas();
	}

    public void findDelivery() {
    	if (buscaId == null) {
    		busca = null;
    		return;
    	}
    	
		final var item = new DeliveryItemDao().busca(buscaId);
		if (item.isEmpty() ) {
			throw new IllegalArgumentException("Item not found");
		}
		busca = item.get();
	}
    
    
    public Delivery getBusca() {
    	return busca;
    }
    
    public void redirectToItems() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        externalContext.redirect("search.xhtml");
    }
    
    public Boolean isInvalid() {
    	var failed = false;
    	if (delivery.getRemetente() == null || delivery.getRemetente().isEmpty()) {
    	      FacesContext.getCurrentInstance().addMessage("remetente", new FacesMessage("Remetente é requerido."));
    	      failed = true;
    	}
    	if (delivery.getDestinatario() == null || delivery.getDestinatario().isEmpty()) {
  	      FacesContext.getCurrentInstance().addMessage("destinatario", new FacesMessage("Destinatario é requerido."));
  	      failed = true;
  	}
    	if (delivery.getEndereco() == null || delivery.getEndereco().isEmpty()) {
  	      FacesContext.getCurrentInstance().addMessage("endereco", new FacesMessage("Remetente é requerido."));
  	      failed = true;
  	}
    	return failed;
    }


}