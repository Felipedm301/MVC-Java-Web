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
        //Ip standard vira um array de char
        char[] x = getIpStandard().toCharArray();
        //auxiliar que recebera apenas os tres primeiros digitos do ip standard
        char[] aux = new char[3];
        for (int i = 0; i < x.length; i++) {
            if (x[i] != '.') {
                aux[i] = x[i];
            } else {
                break;
            }
        }
        //passando o aux para uma variavel inteira
        int intIP = Integer.parseInt(String.valueOf(aux));
        String resultado = "";
        //classificando o ip
        if ((intIP >= 0) && (intIP <= 127)) {
            resultado = "A";
        } else if ((intIP >= 128) && (intIP <= 191)) {
            resultado = "B";
        } else if ((intIP >= 192) && (intIP <= 223)) {
            resultado = "C";
        } else if ((intIP >= 224) && (intIP <= 239)) {
            resultado = "D";
        } else if ((intIP >= 240) && (intIP <= 255)) {
            resultado = "E";
        }
        return resultado;
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
