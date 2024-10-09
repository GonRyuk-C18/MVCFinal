package Controllers;

import Model.Atracao;
import Repositories.AtracoesRepository;
import Repositories.CustosRepository;
import Repositories.VendasRepository;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AdminController {
    private AtracoesRepository atracoesRepository;
    private CustosRepository custosRepository;
    private VendasRepository vendasRepository;

    public AdminController() throws FileNotFoundException {
        this.atracoesRepository = new AtracoesRepository();
        this.vendasRepository = new VendasRepository();
        this.custosRepository = new CustosRepository();
    }


    /**
     * metodo que retorna o valor total de vendas
     * *@return valor total
     */
    public Double totalVendas() {

        Double valortotal=0.0;//valor total inicia a 0
        for (int linhaVenda=0; linhaVenda < vendasRepository.getVendasArray().size();linhaVenda++){ //corre a totalidade do array de vendas linha a linha
            for (int linhaatracoes=0; linhaatracoes < atracoesRepository.getAtracaoArray().size();linhaatracoes++){ //corre a totalidade do array de atrações linha a linha
                if ((atracoesRepository.getAtracaoArray().get(linhaatracoes).getId()) == (vendasRepository.getVendasArray().get(linhaVenda).getIdAtracao())){ //se o id da Atração na linha atual for igual ao id da posição da linha atual de Vendas
                    if (vendasRepository.getVendasArray().get(linhaVenda).getClienteTipo().equals("adulto")){ //se o tipo de cliente na linha atual do array de vendas for igual a "adulto"
                        valortotal=valortotal+atracoesRepository.getAtracaoArray().get(linhaatracoes).getPrecoAdulto(); //valor total é igual ao valor total anterior mais o preço de bilhete para adulto
                    }else {
                        valortotal=valortotal+atracoesRepository.getAtracaoArray().get(linhaatracoes).getPrecoCrianca(); //valor total é igual ao valor total anterior mais o preço de bilhete para criança
                    }
                }

             }
        }
        return valortotal;
    }

    /**
     * Metodo para calcular o lucro total
     *  * @return lucrototal
     */
    public Double lucroVendas(){
        Double lucrototal=0.0; //lucro total inicia a 0
        ArrayList<String> meses= new ArrayList<>(); //criado Array vazio para armazenar os meses
        for (int linhaVenda=0; linhaVenda < vendasRepository.getVendasArray().size();linhaVenda++){ //corre a totalidade do array de vendas linha a linha
            if (!meses.contains(vendasRepository.getVendasArray().get(linhaVenda).getDataMes())){ //corre a totalidade do array de meses linha a linha e ve se contem o mes atual, se não tiver:
                meses.add(vendasRepository.getVendasArray().get(linhaVenda).getDataMes()); //adiciona o mes a uma nova posição do array de meses.
            }
            for (int linhaatracoes=0; linhaatracoes < atracoesRepository.getAtracaoArray().size();linhaatracoes++){ //corre a totalidade do array de atrações linha a linha
                if ((atracoesRepository.getAtracaoArray().get(linhaatracoes).getId()) == (vendasRepository.getVendasArray().get(linhaVenda).getIdAtracao())){ //se o id da atração da posição atual da linha de vendas for igual ao id da atração da posição atual da linha de atrações
                    if (vendasRepository.getVendasArray().get(linhaVenda).getClienteTipo().equals("adulto")){ //se o tipo de cliente na linha atual do array de vendas for igual a "adulto"
                        lucrototal=lucrototal+atracoesRepository.getAtracaoArray().get(linhaatracoes).getPrecoAdulto(); //lucro total é igual ao lucro total atual mais o preço de bilhete para adulto
                    }else { //se o tipo de cliente na linha atual do array de vendas for igual a "criança"
                        lucrototal=lucrototal+atracoesRepository.getAtracaoArray().get(linhaatracoes).getPrecoCrianca(); //lucro total é igual ao lucro total atual mais o preço de bilhete para adulto
                    }
                    lucrototal=lucrototal-custosRepository.getCustoArray().get(linhaatracoes).getCustoManutencao(); //lucro total é igual ao lucro total atual menos o custo de manutenção da atração
                }
            }
        }
        for (int i=0;i<custosRepository.getCustoArray().size();i++){//corre o array de custos linha a linha
            lucrototal=lucrototal-(custosRepository.getCustoArray().get(i).getCustoFixoMes()*meses.size()); //lucro total é igual ao lucro total anterior - (custo fixo mes da atração da linha atual*numero de meses)
        }

        return lucrototal;
    }

    /**
     * Metodo que devolve o lucro e valor total por mes
     * *@return meslucro[][]
     */
    public Double[][] lucroMes() {
        ArrayList<String> meses = new ArrayList<>();//array de Strings que guarda os meses
        double lucromes;
        double fixomes=0;

        for (int linhaVenda = 0; linhaVenda < vendasRepository.getVendasArray().size(); linhaVenda++) {//corre a totalidade do array de vendas linha a linha
            if (!meses.contains(vendasRepository.getVendasArray().get(linhaVenda).getDataMes())) {//corre a totalidade do array de meses linha a linha e ve se contem o mes atual, se não tiver:
                meses.add(vendasRepository.getVendasArray().get(linhaVenda).getDataMes());////adiciona o mes a uma nova posição do array de meses.
            }
        }
        Double[][] meslucro = new Double[meses.size()][3];//criada matriz para guardar mes/lucromes/totalmes
            for (int m=0;m<custosRepository.getCustoArray().size();m++){//corre a totalidade do array de Custos linha a linha
                fixomes=fixomes+custosRepository.getCustoArray().get(m).getCustoFixoMes();//valor fixo do mes soma todos os valores fixo de manutenção por atração
            }
            for (int i = 0; i < meses.size(); i++) {//corre a totalidade do array de meses linha a linha
                lucromes =0;
                double totalmes =0;
                meslucro[i][0]=(double)i;
                for (int k = 0; k < vendasRepository.getVendasArray().size(); k++) {//corre a totalidade do array de vendas linha a linha
                    if (meses.get(i).equals(vendasRepository.getVendasArray().get(k).getDataMes())) {//se o mes atual do array meses for igual ao mes da posição atual da linha de vendas
                        for (int j = 0; j < atracoesRepository.getAtracaoArray().size(); j++) {//corre a totalidade do array de atraçoes
                            if (vendasRepository.getVendasArray().get(k).getIdAtracao() == atracoesRepository.getAtracaoArray().get(j).getId()) { // se o id da atração fo igual na linha atual de vendas e na linha atual de atrações
                                if (vendasRepository.getVendasArray().get(k).getClienteTipo().equals("adulto")){//e tipo de client fo adulto
                                    lucromes = lucromes +((double)(atracoesRepository.getAtracaoArray().get(j).getPrecoAdulto()-custosRepository.getCustoArray().get(j).getCustoManutencao())) ; //lucro mes = ao lucromes + preço do bilhete adulto da atração atual menos o seu custo de manutenção
                                    totalmes=totalmes+(double)(atracoesRepository.getAtracaoArray().get(j).getPrecoAdulto()); //total = ao total + preço do bilhete adulto da atração atual
                                }
                                else { //se for criança
                                    lucromes = lucromes +((double)(atracoesRepository.getAtracaoArray().get(j).getPrecoCrianca()-custosRepository.getCustoArray().get(j).getCustoManutencao()));//lucro mes = ao lucromes + preço do bilhete criança da atração atual menos o seu custo de manutenção
                                    totalmes=totalmes+(double)(atracoesRepository.getAtracaoArray().get(j).getPrecoCrianca()); //total = ao total + preço do bilhete criança da atração atual

                                }
                            }
                        }
                    }
                }
                lucromes = lucromes -fixomes; // retira ao lucromes total o valor fixo de manutenção total mensal
                meslucro[i][1]= lucromes; // grava para a posição atual do mes o seu lucrototal
                meslucro[i][2]=totalmes;  // grava para a posição atual do mes o seu totalmes
            }
            return meslucro;
    }

    /**
     * Metodo que devolve a atração mais procurada por Adultos
     * *@return MaisProcurada
     */
    public Atracao maisProcuradaAdultos() {
        int count;
        int maiorcount=0;
        Atracao MaisProcurada=null;
        for(int linhaAtracoes=0;linhaAtracoes<this.atracoesRepository.getAtracaoArray().size();linhaAtracoes++){//corre array de atrações linha a linha
            count=0;
            for (int linhaVendas=0;linhaVendas<this.vendasRepository.getVendasArray().size();linhaVendas++){//corre array de vendas linha a linha
                if ((vendasRepository.getVendasArray().get(linhaVendas).getIdAtracao()==atracoesRepository.getAtracaoArray().get(linhaAtracoes).getId()) && (vendasRepository.getVendasArray().get(linhaVendas).getClienteTipo().equals("adulto"))){
                    //se id de atração da linha de vendas igual ao id da atração da linha de atrações && tipo de Cliente na linha atual de vendas igual a "adulto"
                    count++;
                }
            }
            //comparador do maior numero de vendas registado com o numero de vendas atual
            if (maiorcount<count) {
                MaisProcurada = atracoesRepository.getAtracaoArray().get(linhaAtracoes);
                maiorcount = count;
            }
        }
        return MaisProcurada;

    }

    /**
     * Metodo que devolve a atração mais procurada por Adultos
     * *@return MaisProcurada
     */
    public Atracao maisProcuradaCriancas() {
        int count;
        int maiorcount = 0;
        Atracao MaisProcurada = null;
        for (int linhaAtracoes = 0; linhaAtracoes < this.atracoesRepository.getAtracaoArray().size(); linhaAtracoes++) {//corre array de atrações linha a linha
            count = 0;
            for (int linhaVendas = 0; linhaVendas < this.vendasRepository.getVendasArray().size(); linhaVendas++) {//corre array de vendas linha a linha
                if ((vendasRepository.getVendasArray().get(linhaVendas).getIdAtracao() == atracoesRepository.getAtracaoArray().get(linhaAtracoes).getId()) && (vendasRepository.getVendasArray().get(linhaVendas).getClienteTipo().equals("crianca"))) {
                    //se id de atração da linha de vendas igual ao id da atração da linha de atrações && tipo de Cliente na linha atual de vendas igual a "criança"
                    count++;
                }
            }
            //comparador do maior numero de vendas registado com o numero de vendas atual
            if (maiorcount < count) {
                MaisProcurada = atracoesRepository.getAtracaoArray().get(linhaAtracoes);
                maiorcount = count;
            }
        }
        return MaisProcurada;
    }
    }