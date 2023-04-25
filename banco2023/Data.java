public class Data {
    int dia, mes, ano;

    Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
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
