package myproject.batalhanaval;

import java.util.Scanner;

public class Jogador {
    private String nome;
    private char[][] meuJogo;
    private char[][] jogoAdversario;
    Scanner c = new Scanner(System.in);
    
    //construtor 
    public Jogador(String nome){
        this.nome = nome;
        this.meuJogo = new char[8][8];
        this.jogoAdversario = new char[8][8];
    }
    
    //getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char[][] getMeuJogo() {
        return meuJogo;
    }

    public void setMeuJogo(char[][] meuJogo) {
        this.meuJogo = meuJogo;
    }

    public char[][] getJogoAdversario() {
        return jogoAdversario;
    }

    public void setJogoAdversario(char[][] jogoAdversario) {
        this.jogoAdversario = jogoAdversario;
    }
    
    //metodos de usabilidades
    public void jogar(Jogador jogadorAdversario){
        taboleiro();
        jogadorAdversario.taboleiro();
        atirar(jogadorAdversario);
    }
    public void atirar(Jogador jogadorAdversario){
        mostrarJogoAdversario();
        System.out.println(nome);
        System.out.println("Informe a linha e a coluna que deseja atirar:");
        for(int i=0;i<2;i++){
            System.out.print("Linha: ");
            int linha  = c.nextInt();
            System.out.print("Coluna: ");
            int coluna = c.nextInt();
            if(jogadorAdversario.verificarSeAcertou(linha, coluna)==false){
                jogadorAdversario.registrarTiro(this, linha, coluna);
                System.out.println("Acertou uma arma");
            }else{
                jogadorAdversario.registrarTiro(this, linha, coluna);
                System.out.println("Acertou a agua");
            }
        }
        mostrarMeuJogo();
        System.out.println("---------------------------------");
        boolean novamente = ganhar(jogadorAdversario);
        if(novamente == true){
            jogadorAdversario.atirar(this);
        }else{
            System.out.println("Ganhador: "+this.nome);
        }
        
    }
    public boolean verificarSeAcertou(int i, int j){
        if(meuJogo[i][j]==' ' || meuJogo[i][j]=='x'){
            return true;
            }else{
              return false;
          }       
    }
    public void registrarTiro(Jogador jogador, int i, int j){
        if(verificarSeAcertou(i,j)==false){
            meuJogo[i][j] = 'x';
            jogador.jogoAdversario[i][j]='o';
        }else{
            meuJogo[i][j] = 'x';
            jogador.jogoAdversario[i][j]='x';
        }
        
    }
    public boolean ganhar(Jogador jogadorAdversario){
        boolean confirmar = false;
        for(int i=0;i<jogadorAdversario.meuJogo.length;i++){
            for(int j=0;j<jogadorAdversario.meuJogo.length;j++){
                if(jogadorAdversario.meuJogo[i][j]!=' ' && jogadorAdversario.meuJogo[i][j]!='x'){
                   confirmar = true;
                }
            }
        }
        return confirmar;
    }
    public void mostrarMeuJogo(){
        System.out.println(nome);
        System.out.println(" 0 I 1 I 2 I 3 I 4 I 5 I 6 I 7");        
        for(int i=0;i<meuJogo.length;i++){
            System.out.print(i);
            for(int j=0;j<meuJogo.length;j++){
                System.out.print(meuJogo[i][j]+" I ");
            }
            System.out.println("\n");
        }
    }
    public void mostrarJogoAdversario(){
        System.out.println(" 0 I 1 I 2 I 3 I 4 I 5 I 6 I 7");        
        for(int l=0;l<jogoAdversario.length;l++){
            System.out.print(l);
            for(int k=0;k<jogoAdversario.length;k++){
                System.out.print(jogoAdversario[l][k]+" I ");
            }
            System.out.println("\n");
        }
    }
    public void taboleiro(){
        for(int i=0;i<meuJogo.length;i++){
            for(int j=0;j<meuJogo.length;j++){
                meuJogo[i][j] = ' ';
                jogoAdversario[i][j] = ' ';
            }
        }
        armas();
    }
    public void armas(){
        System.out.println("Jogador "+this.nome+" está se armando");

        while(true){
        System.out.println("Informe a posicao do Submarino\nlinha: entre 1 e 4");
        System.out.print("Linha: ");
        int numeroUm = c.nextInt();
        if(numeroUm>=1 || numeroUm<=4){
            System.out.print("Coluna: ");
        int numeroDois = c.nextInt();
           if(meuJogo[numeroUm][numeroDois+3]==' '){
            meuJogo[numeroUm][numeroDois]='s';
            meuJogo[numeroUm][numeroDois+1]='s';
            meuJogo[numeroUm][numeroDois+2]='s';
            break;
        } }else{
               System.out.println("Digite uma posicao valida");
           } 
        }
        
        while(true){
        System.out.println("Informe a posicao do Submarino\nlinha: entre 1 e 5");
        System.out.print("Linha: ");
        int numeroUm = c.nextInt();
        if(numeroUm>=1 || numeroUm<=5){
            System.out.print("Coluna: ");
        int numeroDois = c.nextInt();
           if(meuJogo[numeroUm][numeroDois]==' ' && meuJogo[numeroUm][numeroDois+2]==' '){
            meuJogo[numeroUm][numeroDois]='c';
            meuJogo[numeroUm][numeroDois+1]='c';
            break;
        } }else{
               System.out.println("Digite uma posicao valida");
           } 
        }
        while(true){
        System.out.println("Informe a posicao do Porta-avioes");
        System.out.print("Linha: ");
        int numeroUm = c.nextInt();
        if(numeroUm>=1 || numeroUm<=4){
            System.out.print("Coluna: ");
        int numeroDois = c.nextInt();
           if(meuJogo[numeroUm][numeroDois]==' ' && meuJogo[numeroUm][numeroDois+2]==' '){
            meuJogo[numeroUm][numeroDois]='p';
            break;
        } }else{
               System.out.println("Digite uma posicao valida");
           } 
        }
    }
}