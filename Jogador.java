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
        System.out.println("Informe a linha e a coluna que deseja atirar:");
        for(int i=0;i<2;i++){
            System.out.print("Linha: ");
            int linha  = c.nextInt();
            System.out.print("Coluna: ");
            int coluna = c.nextInt();
            if(jogadorAdversario.verificarSeAcertou(linha, coluna)==true){
                jogadorAdversario.registrarTiro(this, linha, coluna);
                System.out.println("Acertou uma arma");
            }else{
                jogadorAdversario.registrarTiro(this, linha, coluna);
                System.out.println("Acertou a agua");
            }
        }
        mostrarMeuJogo();
        boolean novamente = ganhar(jogadorAdversario);
        if(novamente == true){
            jogadorAdversario.atirar(this);
        }else{
            System.out.println("Ganhador: "+this.nome);
        } 
    }
    
    public boolean verificarSeAcertou(int i, int j){
        if(meuJogo[i][j]==' ' || meuJogo[i][j]=='x'){
            return false;
            }else{
              return true;
          }       
    }
    
    public void registrarTiro(Jogador jogador, int i, int j){
        if(verificarSeAcertou(i,j)==true){
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
        System.out.println("Jogador: "+nome+"\nTabela do seu jogo");
        System.out.println(" 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7");        
        for(int i=0;i<meuJogo.length;i++){
            System.out.print(i);
            for(int j=0;j<meuJogo.length;j++){
                System.out.print(meuJogo[i][j]+" | ");
            }
            System.out.println("\n---------------------------------");
        }
    }
    
    public void mostrarJogoAdversario(){
        System.out.println("Jogador: "+nome+"\nTabela do adversario");
        System.out.println(" 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7");        
        for(int l=0;l<jogoAdversario.length;l++){
            System.out.print(l);
            for(int k=0;k<jogoAdversario.length;k++){
                System.out.print(jogoAdversario[l][k]+" | ");
            }
            System.out.println("\n---------------------------------");
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
        System.out.println("Informe a posicao do Submarino");
        System.out.print("Linha: ");
        int numeroUm = c.nextInt();
        System.out.print("Coluna: entre 1 e 4\nColuna: ");
        int numeroDois = c.nextInt();
        if(numeroDois>=1 && numeroDois<=4){
            if(meuJogo[numeroUm][numeroDois+3]==' ' && meuJogo[numeroUm][numeroDois-1]==' '){
                meuJogo[numeroUm][numeroDois]='s';
                meuJogo[numeroUm][numeroDois+1]='s';
                meuJogo[numeroUm][numeroDois+2]='s';
                break;
            }  
        }else{
            System.out.println("Digite uma posicao valida");
           }  
        }
        
        while(true){
        System.out.println("Informe a posicao do Cruzador");
        System.out.print("Linha: ");
        int numeroUm = c.nextInt();
        System.out.print("Coluna: entre 1 e 5\nColuna: ");
        int numeroDois = c.nextInt();
        if(numeroDois<=5){
            if(meuJogo[numeroUm][numeroDois]==' ' && meuJogo[numeroUm][numeroDois+2]==' ' && meuJogo[numeroUm][numeroDois-1]==' '){
                meuJogo[numeroUm][numeroDois]='c';
                meuJogo[numeroUm][numeroDois+1]='c';
                break;
                }   
        }else{
            System.out.println("Digite uma posicao valida");
            } 
        }
        
        while(true){
        System.out.println("Informe a posicao do Porta-avioes");
        System.out.print("Linha: ");
        int numeroUm = c.nextInt();
        System.out.print("Coluna: entre 1 e 6\nColuna: ");
        int numeroDois = c.nextInt();
        if(numeroDois<7){
            if(meuJogo[numeroUm][numeroDois]==' ' && meuJogo[numeroUm][numeroDois+1]==' ' && meuJogo[numeroUm][numeroDois-1]==' '){
                meuJogo[numeroUm][numeroDois]='p';
                break;
            }  
        }else{
            System.out.println("Digite uma posicao valida");
           } 
        }
    }
}
