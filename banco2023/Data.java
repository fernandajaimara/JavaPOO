public class Data {
    int dia, mes, ano;

    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    void imprimir (){
        System.out.println(this.dia + "/" + this.mes + "/" + this.ano);
    }
}
