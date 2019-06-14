package modelo;

/**
 *
 * @author Felipe
 */
public class Calcular {
    private String ip;

    public Calcular(String ip) {
        this.ip = ip.replaceAll(" ", "");
    }

    public String getIpStandard() {
        return ip;
    }
    
    public String getMaskRede(){
        return null;
    }
    
    public String getEndRede(){
        return null;
    }
    
    public String getClasseIp(){
        return null;
    }
    
    public String getIpMac(){
        return null;
    }
}
