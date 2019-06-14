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
    
    //Calcular a mascara da rede
    public String getMaskRede(){
        return null;
    }
    
    //Calcular o Emdereco da rede
    public String getEndRede(){
        return null;
    }
    
    //Calcular a classe do IP
    public String getClasseIp(){
        return null;
    }
    
    //Calcular o IP da maquina
    public String getIpMac(){
        String resultado = "";
        char[] aux = getIpStandard().toCharArray();
        for (int i = 0; i < aux.length; i++) {
            //Excluir tudo depois da Barra(/)
            if (aux[i] != '/') {
                resultado += aux[i];
            } else {
                break;
            }
        }
        return resultado;
    }
}
