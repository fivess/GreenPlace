package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Delivery;

public class DeliveryItemDao {
	
	private static final List<Delivery> DELIVERIES = new ArrayList<>();
	static {
		geraIdeAdiciona(new Delivery("João", "Maria", "Rua 1"));
		geraIdeAdiciona(new Delivery("José", "Joana", "Rua 2"));
		geraIdeAdiciona(new Delivery("Pedro", "Paula", "Rua 3"));
		geraIdeAdiciona(new Delivery("Carlos", "Carla", "Rua 4"));
		geraIdeAdiciona(new Delivery("Antonio", "Ana", "Rua 5"));
	}
	
	public void adiciona(Delivery t) {
		geraIdeAdiciona(t);
	}

	public Optional<Delivery> busca(Long id) {
		return DELIVERIES.stream().filter(t -> t.getId().equals(id)).findFirst();
	}

	
	
	private static void geraIdeAdiciona(Delivery t) {
		Long id = DELIVERIES.size() + 1l;
		t.setId(id);
		DELIVERIES.add(t);		
	}

	public List<Delivery> busqueTodas() {
        return DELIVERIES;
    }
	

	
	
}