import java.util.*;


public class Banco
{
    private String nomeFantasia;
    private List<Agencia> agencias = new ArrayList<>();
    
    public String getNomeFantasia(){
        return nomeFantasia;
    }
    
    public List<Agencia> getAgencias(){
        return agencias;
    }
    
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }
    
    public void setAgencias(List<Agencia> agencias){
        this.agencias = agencias;
    }
    
    public double total(){
        return agencias.stream().mapToDouble(s->s.total()).sum();
        
    }
    
     public boolean renderCP(){
        agencias.stream().forEach(ag->ag.renderCP());
        return true;
    }
    
    
    
}
