package model;

public class Delivery {
	private Long id;
	private String destinatario;
	private String remetente;
	private String endereco;

    public Delivery(String destinatario, String remetente, String endereco) {
        this.destinatario = destinatario;
        this.remetente = remetente;
        this.endereco = endereco;
    }

    public Delivery() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
