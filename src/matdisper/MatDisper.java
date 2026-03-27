/*

 */
package matdisper;

import javax.swing.JOptionPane;

import java.util.Random;

/**
 *
 * @author Me
 */
public class MatDisper {

    public static int Menu() {

        int opc = Integer.parseInt(JOptionPane.showInputDialog(
                "----- MENU MATRIZ DISPERSA -----\n"
                + "1. Insertar\n"
                + "2. Eliminar por coordenada\n"
                + "3. Eliminar por dato\n"
                + "4. Sumar filas\n"
                + "5. Sumar columnas\n"
                + "6. Sumar tripletas\n"
                + "7. Multiplicar tripletas\n"
                + "8. Mostral\n"
                + "0. Salir\n\n"
                + "Seleccione una opcion:"
        ));

        return opc;
    }

    public static int ContarDatos(int Mat[][]) {
        int N = 0;
        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {

                if (Mat[i][j] != 0) {
                    N++;
                }
            }
        }
        return N;
    }

    public static void random(int[][] Mat2, int Tamf, int Tamc) {
        Random random = new Random();

        // Llenar matriz
        for (int i = 0; i < Tamf; i++) {
            for (int j = 0; j < Tamc; j++) {
                int p = random.nextInt(3);
                if (p == 0 || p == 2) {
                    Mat2[i][j] = 0;

                } else {
                    int h = random.nextInt(3);
                    if (h == 0) {
                        Mat2[i][j] = random.nextInt(99) * -1;

                    } else if (h == 1 || h == 2) {
                        Mat2[i][j] = random.nextInt(99);
                    }
                }
            }
        }

        // Imprimir matriz
        String c = "";
        String b;
        for (int i = 0; i < Tamf; i++) {
            for (int j = 0; j < Tamc; j++) {

                b = Mat2[i][j] + " ";
                c = c + b;

            }
            c = c + "\n";
        }
        JOptionPane.showMessageDialog(null, c);
    }

    public static void main(String[] args) {
        int opc = 0;
        int tamFilaa = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamanio de la Fila de la matriz A: "));
        int tamColumna = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamanio de la Columna de la matriz A: "));
        int Mat[][] = new int[tamFilaa][tamColumna];

        random(Mat, tamFilaa, tamColumna);
        int N = ContarDatos(Mat);
        Tripleta T1 = new Tripleta(ContarDatos(Mat) + 1);
        T1.LlenarTripleta(Mat);

        do {

            opc = Menu();

            switch (opc) {

                case 1:

                    int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila"));
                    int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna"));
                    int dato = Integer.parseInt(JOptionPane.showInputDialog("Digite la dato"));

                    T1.Insertar(fila, columna, dato);
                    break;

                    
                case 2:
                    int Efila = Integer.parseInt(JOptionPane.showInputDialog("Digite la fila a eliminar"));
                    int Ecolumna = Integer.parseInt(JOptionPane.showInputDialog("Digite la columna a eliminar"));
                    T1.Eliminarcoordenada(Efila, Ecolumna);
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null, "Tenga en cuenta que se eliminaran todos los datos que coincidan");
                    int Dato = Integer.parseInt(JOptionPane.showInputDialog(T1.Mostrar() + "Digite el dato a eliminar"));
                    T1.Eliminardato(Dato);

                    break;

                case 4:

                     int[] sumas = T1.SumarFilas();
    String resultado = "=== Suma por filas ===\n";
    int f = 0;
    while (f < sumas.length) {
        resultado += "Fila " + f + ": " + sumas[f] + "\n";
        f++;
    }


    JOptionPane.showMessageDialog(null, resultado);
    
    break;

    

                case 5:
                   int[] sumasC = T1.SumarFilas();
    String resultadoC = "=== Suma por filas ===\n";
    int c = 0;
    while (c < sumasC.length) {
        resultadoC += "Columna " + c + ": " + sumasC[c] + "\n";
        c++;
    }


    JOptionPane.showMessageDialog(null, resultadoC);
    break;

                case 6:
                  
    int tamFilaB = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamanio de la Fila de la matriz B: "));
    int tamColumnaB = Integer.parseInt(JOptionPane.showInputDialog("Digite el tamanio de la Columna de la matriz B: "));
    int MatB[][] = new int[tamFilaB][tamColumnaB];
    

    random(MatB, tamFilaB, tamColumnaB);

    Tripleta B = new Tripleta(ContarDatos(MatB) + 1); 
    B.LlenarTripleta(MatB);   
    
    
  JOptionPane.showMessageDialog(null, "Tripleta B:\n" + B.Mostrar());
  JOptionPane.showMessageDialog(null,"Tripleta A:\n" + T1.Mostrar());
  
    

    Tripleta C = T1.suma(B);  

    if (C != null) {
        JOptionPane.showMessageDialog(null, "Resultado de la suma:\n" + C.Mostrar());
    }
    break;
       
            
                    
                case 7: 
                    JOptionPane.showMessageDialog(null, T1.Mostrar());
                    break;

                case 0:
                    System.out.println("Fin del programa");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while (opc != 0);
    }
}
