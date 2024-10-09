package Views;

import Controllers.AdminController;

import java.io.FileNotFoundException;

public class AdminView {
    private AdminController adminController;

    public AdminView() throws FileNotFoundException {
        this.adminController = new AdminController();
    }



    public void mostrarTotalVendas(){

        System.out.println(" Total de todas as Vendas: "+adminController.totalVendas());
    }

    public void mostrarTotalLucro(){
        System.out.println(" Total de Lucro: " +adminController.lucroVendas());
    }

    public void mostrarLucroMes(){
        Double[][]lucromes= adminController.lucroMes();
        System.out.println("******MES******|*****Lucro*****|**Total_Vendas**");
        for (int i=0; i<lucromes.length;i++){
            System.out.println("*****"+lucromes[i][0]+"*****|*****"+lucromes[i][1]+"*****|*****"+lucromes[i][2]+"*****");
        }
    }

    public void mostrarMProcuradaAdultos(){
        System.out.println("Mais procurada pelos Adultos: "+adminController.maisProcuradaAdultos().getNome());
    }

    public void mostrarMProcuradaCriancas(){
        System.out.println("Mais procurada pelas Crianças: "+adminController.maisProcuradaCriancas().getNome());
    }

}

