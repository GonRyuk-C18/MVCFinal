package Model;

public class Atracao {
    private int id;
    private String nome;
    private double precoAdulto;
    private double precoCrianca;
    private int segundos;

    public Atracao(int id, String nome, double precoAdulto, double precoCrianca, int segundos) {
        this.id = id;
        this.nome = nome;
        this.precoAdulto = precoAdulto;
        this.precoCrianca = precoCrianca;
        this.segundos = segundos;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoAdulto() {
        return precoAdulto;
    }

    public double getPrecoCrianca() {
        return precoCrianca;
    }

    public int getSegundos() {
        return segundos;
    }
}
