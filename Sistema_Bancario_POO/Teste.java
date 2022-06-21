import java.util.*;
import javax.swing.*;

public class Teste
{
    private Conta conta = new Conta();
    private Banco banco = new Banco();
    private Random random = new Random();
    private Agencia agencia = new Agencia();
    private List<Conta> contas = new ArrayList<>();
    private List<Agencia> agencias = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();  
      
    public Banco Teste()
    {
          Banco bank = criarBanco();
          bank.setAgencias(criarAgencia(3));
          for(Agencia ag: bank.getAgencias()){
            ag.setContas(criarConta(4));
            ag.setTotal(ag.total());
            ag.renderCP();
            ag.manutencaoCP();
          }
         return bank;
    }
     
    public Banco criarBanco(){
        banco.setNomeFantasia("Banco do Brasil");
        return banco;
    }
    
    public String gerarNumeroAgencia(){
        String numero = "";
        for(int i = 0; i < 4; i++){
            numero += "" + random.nextInt(9);
        }
        return numero;
    }
    
    public String gerarNumeroTipo(String  type){
        if(gerarTipoConta().equals("Conta Corrente PF")){
            return "001";
        }else if(gerarTipoConta().equals("Conta Poupanca PF")){
            return "013";
        }
        return "";
    }
    
    public double gerarQuantia_Alta_Dinheiro(){
        return Math.ceil(20+ (Math.random()*125));
    }
    
    public double gerarQuantia_Baixa_Dinheiro(){
        return Math.ceil(20+ (Math.random()*24));
    }

    public String gerarNumeroConta(){
        String numero = "";
        for(int i = 0; i<10; i++){
            if(i == 8){
             numero += "-";
            }else{
                 numero += random.nextInt(9);
            }
        }
        return numero;
    }
    
     public String gerarData(){
        int dia = (1 + random.nextInt(28));
        int mes = (1 + random.nextInt(11));
        String sDia = "";
        String sMes = "";
        if(dia < 10){
            sDia = "0" + dia;
        }else{
            sDia = "" + dia;
        }
        if(mes < 10){
            sMes = "0"+ mes;
        }else{
             sMes = ""+ mes;
        }
        
        String data = sDia + "/" + sMes + "/" + (2022);
       
        return data;
    }
    
    public List<Conta> criarConta(int qtdConta){
        String tipo = gerarTipoConta();
        for(int i = 0; i < qtdConta; i++){
          Conta c = new Conta();

          c.setCodigo(i);
          c.setTipo(tipo);
          c.setNumeroTipo(gerarNumeroTipo(tipo));
          c.depositar(gerarQuantia_Alta_Dinheiro());
          c.sacar(gerarQuantia_Baixa_Dinheiro());
          c.setLimite(35);
          c.setTaxaManutencao(50);
          c.setRendimento(0.8);
          c.setSaldo(c.getSaldo());
          clientes = criarUsuarios(1);
          c.setCliente(clientes.get(i));
          c.setNumero(gerarNumeroConta());
          c.setData(gerarData());
          contas.add(c);
          if(i > 0){
              c.transferir(contas.get(i-1), gerarQuantia_Baixa_Dinheiro());
          }
       }
      
       return contas;
    }
    
    public String gerarTipoConta(){
        String tipo[] = {"Conta Corrente PF", "Conta Poupanca PF","Conta Simples PF ", "Conta Corrente PJ", "Conta Poupanca PJ"};
        return tipo[random.nextInt(1)];
    }
    
    public List<Agencia> criarAgencia(int qtdAgencia){
        for(int i = 0; i < qtdAgencia; i++){
          Agencia a = new Agencia();
          a.setCodigo(i);
          a.setNumero(gerarNumeroAgencia());
          a.setContas(contas);
          agencias.add(a);
       }
       return agencias;
    }
    
    public String gerarCPF(){
        String cpf= "";
        for(int i =0; i < 14; i++){
            if((i == 3) || (i == 7)){
             cpf += ".";
            }
            else if(i == 11){
             cpf += "-";
            }
            else{
             cpf += (""+random.nextInt(9));
            }
        }
        return cpf;
    }
    
    public String gerarNome(){
        String nome[] = {"Amelia", "Ana", "Suzana","Bianca", "Pedro", "Carlos", "Mateus", "Gabriela", "Marcos", "Vinicius", "Livia", "Maria", "Mario", "Daniel", "Emanoel", "Julia", "Mariana" };
        String sobrenome[] = {"Costa", "Medeiros", "Oliveira", "Araújo", "Lima", "Souza", "Dantas", "Silva", "Barros", "Cunha"};
        String nomeCompleto = nome[random.nextInt(nome.length-1)] + " " + sobrenome[random.nextInt(sobrenome.length-1)];
        return nomeCompleto;
    }
    
    public List<Cliente> criarUsuarios(int qtdUsuarios){
        for(int i = 0; i < qtdUsuarios; i++){
          Cliente cli = new Cliente();
          cli.setNome(gerarNome());
          cli.setCPF(gerarCPF());
          clientes.add(cli);
       }
       return clientes;
    }
        
   
}
