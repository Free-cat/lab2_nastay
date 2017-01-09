package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите размерность матриц A и B: ");
        int raz = sc.nextInt();

        System.out.println("Заполните матрицу A");
        Matrix A = new Matrix(vvod(raz), raz);
        System.out.println("Определитель матрицы A = " + A.getDet());

        System.out.println("Заполните матрицу B");
        Matrix B = new Matrix(vvod(raz), raz);
        System.out.println("Определитель матрицы B = " + B.getDet());

        double[][] summa = summa(A.getG(),B.getG(), A.getRaz());
        System.out.println("Сумма Матриц");
        vivod(summa, raz);

        double[][] raznos = raz(A.getG(),B.getG(), 3);
        System.out.println("Разность Матриц");
        vivod(raznos, raz);

        double[][] umnog = umnog(A.getG(),B.getG(), A.getRaz());
        System.out.println("Умножение Матриц");
        vivod(umnog, raz);

        System.out.println("Введите на что умножить матрицу А: ");
        int Aum = sc.nextInt();
        double[][] umnogna = umnogna(A.getG(), A.getRaz(), Aum);
        System.out.println("Умножение на число Матрицы A");
        vivod(umnogna, raz);

        System.out.println("Введите на что умножить матрицу B: ");
        int Bum = sc.nextInt();
        double[][] umnognb = umnogna(B.getG(), B.getRaz(), Bum);
        System.out.println("Умножение на число Матрицы B");
        vivod(umnognb, raz);

        double[][] C = umnog((umnogna(raznos, A.getRaz(), 2)),(summa((umnog(A.getG(),A.getG(), A.getRaz())),B.getG(), A.getRaz())), A.getRaz());
        System.out.println("Результат расчета C");
        vivod(C, raz);
    }

    public static void vivod(double[][] G, int n){
        for (int i=0; i<n; i++){
            for (int k=0; k<n; k++){
                System.out.print(G[i][k] + "  ");
            }
            System.out.print("\n");
        }
    }

    public static double[][] vvod(int n){
        Scanner sc = new Scanner(System.in);
        double G[][] = new double[n][n];
        for (int i=0; i<n; i++){
            for (int k=0; k<n; k++){
                System.out.println("Введите элемент [" + i + "][" + k + "]");
                G[i][k] = sc.nextDouble();
            }
        }
        return G;
    }

    public static double[][] summa(double[][] A, double[][] B, int n){
        double[][] C = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static double[][] raz(double[][] A, double[][] B, int n){
        double[][] C = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }

    public static double[][] umnog(double[][] A, double[][] B, int n){
        double[][] C = new double[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }

    public static double[][] umnogna(double[][] A, int n, int b){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                A[i][j] = A[i][j] * b;
            }
        }
        return A;
    }
}
