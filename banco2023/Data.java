import java.util.Scanner;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner s = new Scanner(System.in);

        System.out.print("Digite o dia: ");
        setDia(s.nextInt());

        System.out.print("Digite o mês: ");
        this.mes = s.nextInt();

        System.out.print("Digite o ano: ");
        this.ano = s.nextInt();
        
    }

    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAno(){
        return ano;
    }

    public void setDia(int dia){
        this.dia = dia;
    }
    
    /*public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }
    
    public void imprimir (){
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }

    public boolean maior(Data d2) {
        if (this.ano > d2.ano) {
            return true;
        } else if (this.ano == d2.ano && this.mes > d2.mes) {
            return true;
        } else if (this.ano == d2.ano && this.mes == d2.mes && this.dia > d2.dia) {
            return true;
        }
        return false;
    }*/
}