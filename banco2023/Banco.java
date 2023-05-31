public class Banco{

   
    public static void main(String[] args) {
        Sistema s = new Sistema();
        System.out.println("Bem Vindo!");

        int op = s.menuInicial();
        while (op != 0){
            if(op == 1){
                s.menuCadastro();
            }
            if(op == 2){
                s.menuMovimentacoes();
            }
            op = s.menuInicial();
       }
    
       System.out.println("Até mais!");
    }
}
