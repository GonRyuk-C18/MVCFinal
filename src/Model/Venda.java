package Model;

public class Venda {
    private int idAtracao;
    private String dataMes;
    private String clienteTipo;


    public Venda(int idAtracao, String dataMes, String clienteTipo) {
        this.idAtracao = idAtracao;
        this.dataMes = dataMes;
        this.clienteTipo = clienteTipo;
    }

    public int getIdAtracao() {
        return idAtracao;
    }

    public String getDataMes() {
        return dataMes;
    }

    public String getClienteTipo() {
        return clienteTipo;
    }
}
