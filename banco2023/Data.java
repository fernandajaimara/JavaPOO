import java.util.Scanner;

public class Data {
    int dia, mes, ano;

    Data() {
        Scanner s = new Scanner(System.in);

        System.out.println("Digite o dia: ");
        this.dia = s.nextInt();

        System.out.println("Digite o mês: ");
        this.mes = s.nextInt();

        System.out.println("Digite o ano: ");
        this.ano = s.nextInt();
    }

    void imprimir (){
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }

    boolean maior(Data d2) {
        if (this.ano > d2.ano) {
            return true;
        } else if (this.ano == d2.ano && this.mes > d2.mes) {
            return true;
        } else if (this.ano == d2.ano && this.mes == d2.mes && this.dia > d2.dia) {
            return true;
        }
        return false;
    }
}
