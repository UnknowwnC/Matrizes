package matdisper;
 
import javax.swing.JOptionPane;
import java.util.Random;
 
public class MatDisper {
 
    public static int Menu(int tipo) {
        String opciones = "===== MENU MATRIZ DISPERSA =====\n\n";
 
        if (tipo == 1) {
            opciones += "TRIPLETA\n"
                      + "  1. Insertar elemento\n"
                      + "  2. Eliminar por coordenada\n"
                      + "  3. Eliminar por dato\n"
                      + "  4. Sumar filas\n"
                      + "  5. Sumar columnas\n"
                      + "  6. Sumar con otra matriz\n"
                      + "  7. Multiplicar con otra matriz\n"
            + "  8. Mostrar elemento\n";
        } else {
            opciones += "[FORMA 2]\n\n";
        }
 
         opciones += "Forma 2"
                      + "  1. Insertar elemento\n"
                      + "  2. Eliminar por coordenada\n"
                      + "  3. Eliminar por dato\n"
                      + "  4. Sumar filas\n"
                      + "  5. Sumar columnas\n"
                      + "  6. Sumar con otra matriz\n"
                      + "  7. Multiplicar con otra matriz\n"
         + "  8. mostrar elemento\n";
        return Integer.parseInt(JOptionPane.showInputDialog(opciones));
    }
 
    public static int ContarDatos(int Mat[][]) {
        int N = 0;
        for (int i = 0; i < Mat.length; i++)
            for (int j = 0; j < Mat[0].length; j++)
                if (Mat[i][j] != 0) N++;
        return N;
    }
 
    public static void random(int[][] Mat2, int Tamf, int Tamc) {
        Random random = new Random();
 
        for (int i = 0; i < Tamf; i++) {
            for (int j = 0; j < Tamc; j++) {
                int p = random.nextInt(3);
                if (p == 0 || p == 2) {
                    Mat2[i][j] = 0;
                } else {
                    int h = random.nextInt(3);
                    if (h == 0)
                        Mat2[i][j] = random.nextInt(99) * -1;
                    else
                        Mat2[i][j] = random.nextInt(99);
                }
            }
        }
 
        String c = "";
        for (int i = 0; i < Tamf; i++) {
            for (int j = 0; j < Tamc; j++)
                c += Mat2[i][j] + "\t";
            c += "\n";
        }
        JOptionPane.showMessageDialog(null, "Matriz generada:\n\n" + c);
    }
 
    public static void main(String[] args) {
 
        int opc = 0;
 
        int tipo = Integer.parseInt(JOptionPane.showInputDialog(
                "Seleccione la estructura a usar:\n\n"
                + "  1. Tripleta\n"
                + "  2. Forma 2"));
 
        int tamFilaa = Integer.parseInt(JOptionPane.showInputDialog("Filas de la matriz A:"));
        int tamColumna = Integer.parseInt(JOptionPane.showInputDialog("Columnas de la matriz A:"));
 
        int Mat[][] = new int[tamFilaa][tamColumna];
        random(Mat, tamFilaa, tamColumna);
 
        Tripleta T1 = null;
        Forma2 F2 = null;
 
        if (tipo == 1) {
            T1 = new Tripleta(ContarDatos(Mat) + 1);
            T1.LlenarTripleta(Mat);
        } else {
            F2 = new Forma2(tamFilaa, tamColumna);
            F2.llenar(Mat);
        }
 
        do {
            opc = Menu(tipo);
 
            switch (opc) {
 
                case 1: // Insertar
                    if (tipo == 1) {
                          JOptionPane.showMessageDialog(null, T1.Mostrar());
                        
                        int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila:"));
                        int columna = Integer.parseInt(JOptionPane.showInputDialog("Columna:"));
                        int dato = Integer.parseInt(JOptionPane.showInputDialog("Dato:"));
                        T1.Insertar(fila, columna, dato);
                    } else {
                          JOptionPane.showMessageDialog(null, F2.Mostrar(tamFilaa, tamColumna));
                        int fila = Integer.parseInt(JOptionPane.showInputDialog("Fila:"));
                        int columna = Integer.parseInt(JOptionPane.showInputDialog("Columna:"));
                        int dato = Integer.parseInt(JOptionPane.showInputDialog("Dato:"));
                       F2.insertar(fila, columna, dato);
                 
                    }
                    break;
 
                case 2: // Eliminar por coordenada
                    if (tipo == 1) {
                          JOptionPane.showMessageDialog(null, T1.Mostrar());
                        int Efila = Integer.parseInt(JOptionPane.showInputDialog("Fila a eliminar:"));
                        int Ecolumna = Integer.parseInt(JOptionPane.showInputDialog("Columna a eliminar:"));
                        T1.Eliminarcoordenada(Efila, Ecolumna);
                    } else {
                        JOptionPane.showMessageDialog(null, F2.Mostrar(tamFilaa, tamColumna));
                        int Efila = Integer.parseInt(JOptionPane.showInputDialog("Fila a eliminar:"));
                        int Ecolumna = Integer.parseInt(JOptionPane.showInputDialog("Columna a eliminar:"));
                     F2.EliminarCoordenada(Efila,Ecolumna);
                    }
                    break;
 
                case 3: // Eliminar por dato
                    if (tipo == 1) {
                         
                        int Dato = Integer.parseInt(JOptionPane.showInputDialog("Dato a eliminar:"+"\n" + T1.Mostrar()));
                        T1.Eliminardato(Dato);
                    } else {
                        int Dato = Integer.parseInt(JOptionPane.showInputDialog("Dato a eliminar:" + "\n" + F2.Mostrar(tamFilaa, tamColumna)));
                      F2.Eliminardato(Dato);
                    }
                    break;
 
                case 4: // Sumar filas
                    if (tipo == 1) {
                          JOptionPane.showMessageDialog(null, T1.Mostrar());
                       T1.SumarFilas();
                    } else {
                         JOptionPane.showMessageDialog(null, F2.Mostrar(tamFilaa, tamColumna));
                        
                       F2.sumarFilas();
                    }
                    break;
 
                case 5: // Sumar columnas
                    if (tipo == 1) {
                          JOptionPane.showMessageDialog(null, T1.Mostrar());
                      T1.SumarColumnas();
                    } else {
                       JOptionPane.showMessageDialog(null, F2.Mostrar(tamFilaa, tamColumna));
                        F2.sumarColumnas();
                    }
                    break;
 
                case 6: // Sumar matrices
                    if (tipo == 1) {
                        int tamFilaB = Integer.parseInt(JOptionPane.showInputDialog("Filas de la matriz B:"));
                        int tamColumnaB = Integer.parseInt(JOptionPane.showInputDialog("Columnas de la matriz B:"));
                        int MatB[][] = new int[tamFilaB][tamColumnaB];
                        random(MatB, tamFilaB, tamColumnaB);
                        Tripleta B = new Tripleta(ContarDatos(MatB) + 1);
                        B.LlenarTripleta(MatB);
                        JOptionPane.showMessageDialog(null, "Tripleta A:\n\n" + T1.Mostrar());
                        JOptionPane.showMessageDialog(null, "Tripleta B:\n\n" + B.Mostrar());
                        Tripleta C = T1.suma(B);
                        if (C != null)
                            JOptionPane.showMessageDialog(null, "Resultado A + B:\n\n" + C.Mostrar());
                    } else {
                        int tamFilaB = Integer.parseInt(JOptionPane.showInputDialog("Filas de la matriz B:"));
                        int tamColumnaB = Integer.parseInt(JOptionPane.showInputDialog("Columnas de la matriz B:"));
                        int MatB[][] = new int[tamFilaB][tamColumnaB];
                        random(MatB, tamFilaB, tamColumnaB);
                        Forma2 FB = new Forma2(tamFilaB, tamColumnaB);
                        FB.llenar(MatB);
                        JOptionPane.showMessageDialog(null, "Forma2 A:\n\n" + F2.Mostrar(tamFilaa,tamColumna));
                        JOptionPane.showMessageDialog(null, "Forma2 B:\n\n" + FB.Mostrar(tamFilaB,tamColumnaB));
                        Forma2 FC = F2.sumar(FB);
                        if (FC != null)
                            JOptionPane.showMessageDialog(null, "Resultado A + B:\n\n" + FC.Mostrar(tamFilaa, tamColumna));
                    }
                    break;
 
                case 7: // Multiplicar matrices
                    if (tipo == 1) {
                        int fB = Integer.parseInt(JOptionPane.showInputDialog("Filas de la matriz B:"));
                        int cB = Integer.parseInt(JOptionPane.showInputDialog("Columnas de la matriz B:"));
                        int[][] mAuxB = new int[fB][cB];
                        random(mAuxB, fB, cB);
                        Tripleta triB = new Tripleta(ContarDatos(mAuxB) + 1);
                        triB.LlenarTripleta(mAuxB);
                        JOptionPane.showMessageDialog(null, "Matriz A:\n\n" + T1.Mostrar());
                        JOptionPane.showMessageDialog(null, "Matriz B:\n\n" + triB.Mostrar());
                        Tripleta triRes = T1.MultiplicarTripletas(triB);
                        if (triRes != null)
                            JOptionPane.showMessageDialog(null, "Resultado A x B:\n\n" + triRes.Mostrar());
                    } else {
                       
                    }
                    break;
 
                case 8: // Mostrar
                    if (tipo == 1)
                        JOptionPane.showMessageDialog(null, "Tripleta A:\n\n" + T1.Mostrar());
                    else
                        JOptionPane.showMessageDialog(null, "Forma 2:\n\n" + F2.Mostrar(tamFilaa,tamColumna));
                    break;
 
                case 0:
                    JOptionPane.showMessageDialog(null, "Fin del programa.");
                    break;
 
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida. Intente de nuevo.");
            }
 
        } while (opc != 0);
    }
}
