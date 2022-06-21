import java.util.*;
import javax.swing.*;

public class Agencia
{
    private int codigo;
    private double total;
    private String numero;
    private List<Conta> contas = new ArrayList<>();
    
    public int getCodigo(){
        return codigo;
    }
    
    public String getNumero(){
        return numero;
    }
    
    public List<Conta> getContas(){
        return contas;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    
    public void setNumero(String numero){
        this.numero = numero;
    }
    
    public void setContas(List<Conta> contas){
        this.contas = contas;
    }
    
    public void setTotal(double total){
        this.total = total;
    }
    
    public double total(){
         return contas.stream().mapToDouble(s->s.getSaldo()).sum();
        
    }
    
    public boolean renderCP(){
        contas.stream().filter(c->c.getTipo().equals("Conta Poupanca PF")).forEach(c->c.rendimento());
        return true;
    }
    
     public boolean manutencaoCP(){
        contas.stream().filter(c->c.getTipo().equals("Conta Poupanca PF")).forEach(c->c.taxaManutencao());
        return true;
    }
    
   
    
  
}
