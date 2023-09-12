package org.fatec2023;

public class Conversor {

    /**
     * Converte um número decimal para outra base.
     *
     * @param base   A base para a qual converter o número.
     * @param numero O número a ser convertido.
     * @return A representação do número na base especificada.
     */
    public String decimalParaOutras(int base, String numero) {
        try {
            String resultado = "";
            int num = Integer.parseInt(numero);

            while (num != 0) {
                String aux = Integer.toString(num % base);
                resultado = numeroParaHexadecimal(aux) + resultado;
                num = num / base;
            }

            return resultado;
        } catch (NumberFormatException ex) {
            return "Este valor não é da base decimal: " + numero;
        }
    }

    /**
     * Converte um número de outra base para decimal.
     *
     * @param base   A base do número de entrada.
     * @param numero O número a ser convertido.
     * @return A representação decimal do número de entrada.
     */
    public String outrasParaDecimal(int base, String numero) {
        int n = numero.length();
        int expoente = 0;
        double resultado = 0;

        for (int i = n; i > 0; i--) {
            char aux = numero.charAt(i - 1);
            resultado += hexadecimalParaNumero(aux) * Math.pow(base, expoente);
            expoente++;
        }

        return Integer.toString((int) resultado);
    }
    String numeroParaHexadecimal(String aux) {

        switch (aux) {
            case "10": return "A";
            case "11": return "B";
            case "12": return "C";
            case "13": return "D";
            case "14": return "E";
            case "15": return "F";
            default:   return aux;
        }
    }

    int hexadecimalParaNumero(char c) {

        if (c >= '0' && c <= '9') {
            return c - '0'; // Transforma os caracteres adquiridos da string transformando eles em numeros
        } else if (c >= 'A' && c <= 'F') {
            return c - 'A' + 10; // Caso seja uma letra do alfabeto ele ira transformar em numero acrescentado 10
        }

        // Caso ocorra algum erro ele retornara -1
        return -1;

    }

}
