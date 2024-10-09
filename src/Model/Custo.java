package Model;

public class Custo {
    private int idAtracao;
    private double custoManutencao;
    private int custoFixoMes;

    public Custo(int idAtracao, double custoManutencao, int custoFixoMes) {
        this.idAtracao = idAtracao;
        this.custoManutencao = custoManutencao;
        this.custoFixoMes = custoFixoMes;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public double getCustoManutencao() {
        return custoManutencao;
    }

    public int getCustoFixoMes() {
        return custoFixoMes;
    }
}
