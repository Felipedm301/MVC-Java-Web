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
        //Recebe a quantia de bits definida no IP Standard
        int qBits = quantiaBits(getIpStandard());
        String saida = "";

        int[] t0 = new int[8], t1 = new int[8], t2 = new int[8], t3 = new int[8];
        int j = 0, w = 0, q = 0, e = 0;
        
        //Transformar em binario
        //Dividi o IP em quatro termos de 8 bit cada e ja atribuido ZEROs e UMs
        for (int i = 0; i < 32; i++) {
            if (i < qBits) {
                if ((i >= 0) && (i < 8)) {
                    t0[j] = 1;
                    j++;
                } else if ((i >= 8) && (i < 16)) {
                    t1[w] = 1;
                    w++;
                } else if ((i >= 16) && (i < 24)) {
                    t2[q] = 1;
                    q++;
                } else if ((i >= 24) && (i < 32)) {
                    t3[e] = 1;
                    e++;
                }
            } else {
                if ((i >= 0) && (i < 8)) {
                    t0[j] = 0;
                    j++;
                } else if ((i >= 8) && (i < 16)) {
                    t1[w] = 0;
                    w++;
                } else if ((i >= 16) && (i < 24)) {
                    t2[q] = 0;
                    q++;
                } else if ((i >= 24) && (i < 32)) {
                    t3[e] = 0;
                    e++;
                }
            }
        }

        //Recebei a mascara de rede no formato padrao, em decimal
        saida = converterDecimal(t0) + "." + converterDecimal(t1) + "."
                + converterDecimal(t2) + "." + converterDecimal(t3);

        return saida;
    }
    
    //Recebi o ip Standard e retorna a quantia de bits da rede
    public int quantiaBits(String verifica) {
        char[] arrayChar = verifica.replace(" ", "").toCharArray();
        String primeiroTermo = String.valueOf(arrayChar[arrayChar.length - 2]);
        String segundoTermo = String.valueOf(arrayChar[arrayChar.length - 1]);
        String auxInteiro = primeiroTermo + segundoTermo;
        int convertInt = Integer.parseInt(auxInteiro);
        return convertInt;
    }
    
    //Converte em decimal cada grupo de tres algarismos
    public int converterDecimal(int[] converter) {
        int convertido = 0, aux = 128;
        for (int i = 0; i < converter.length; i++) {
            if (converter[i] == 1) {
                convertido += aux;
                aux /= 2;
            } else {
                aux /= 2;
            }
        }
        return convertido;
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
