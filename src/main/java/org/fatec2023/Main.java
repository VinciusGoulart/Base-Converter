package org.fatec2023;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Conversor conv = new Conversor();

        int base1, base2,fim = 0;
        String resultado = "",numero = "";


        do {
            try {
                System.out.print("Digite a base do número a ser convertido (2 a 16): ");
                base1 = sc.nextInt();

                if (base1 < 2 || base1 > 16) {
                    System.out.println("Base inválida. Tente novamente.\n");
                    continue;
                }

                System.out.print("Digite o número a ser convertido (na base " + base1 + "): ");
                numero = sc.next().toUpperCase();

                if (!validarNumero(numero, base1)) {
                    System.out.println("Número inválido para a base " + base1 + ". Tente novamente.\n");
                    continue;
                }

                System.out.print("Digite a base desejada (2 a 16): ");
                base2 = sc.nextInt();

                if (base2 < 2 || base2 > 16) {
                    System.out.println("Base inválida. Tente novamente.\n");
                    continue;
                }

                if (base1 == 10) {
                    resultado = conv.decimalParaOutras(base2, numero);

                    System.out.println("\nO número " + numero + " convertido para a base (" + base2 + ") é: " + resultado);
                } else {
                    String aux = conv.outrasParaDecimal(base1, numero);
                    resultado = conv.decimalParaOutras(base2, aux);

                    System.out.println("\nO número " + numero + " convertido para a base (" + base2 + ") é: " + resultado);
                }



                System.out.println("\nDeseja fazer outra conversão?\n 1 - SIM  2 - NÃO");
                fim = sc.nextInt();
            }catch (InputMismatchException exception){
                System.out.println("Erro ao atribuir valor as bases, por favor digite apenas numeros");
                fim = 2;
            }

        } while (fim != 2);
    }

    // Verifica se o número fornecido é válido para a base especificada
    private static boolean validarNumero(String numero, int base) {
        for (char c : numero.toCharArray()) {
            if (!isCaracterValido(c, base)) {
                return false;
            }
        }
        return true;
    }
    // Verifica se um caractere é válido para a base especificada
    private static boolean isCaracterValido(char c, int base) {
        if (base <= 10) {
            return c >= '0' && c < ('0' + base);
        } else {
            return (c >= '0' && c <= '9') || (c >= 'A' && c < ('A' + base - 10));
        }
    }
}