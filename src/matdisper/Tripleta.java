/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matdisper;

import javax.swing.JOptionPane;

/**
 *
 * @author andre
 */
public class Tripleta {

    // Atributos
    private int Mtri[][];

    // Metodos
    public Tripleta(int N) {
        Mtri = new int[N + 1][3];
    }

    public int getMtri(int k, int i) {
        return Mtri[k][i];
    }

    public void setMtri(int k, int i, int dato) {
        this.Mtri[k][i] = dato;
    }

    // Tamano de la tripleta = N+1 * 3
    public void LlenarTripleta(int Mat[][]) {
        int k = 1;
        Mtri[0][0] = Mat.length;
        Mtri[0][1] = Mat[0].length;
        Mtri[0][2] = 0;

        for (int i = 0; i < Mat.length; i++) {
            for (int j = 0; j < Mat[0].length; j++) {
                if (Mat[i][j] != 0) {

                    Mtri[k][0] = i;
                    Mtri[k][1] = j;
                    Mtri[k][2] = Mat[i][j];

                    k++;
                    Mtri[0][2]++;
                }
            }
        }
    }

    public String Mostrar() {
        String texto = "";
        for (int k = 0; k <= Mtri[0][2]; k++) { // menor o igua pq si no no muestra la ultima o la primera linea, enm este caso la ultiima linea
            texto += "| " + Mtri[k][0] + " | " + Mtri[k][1] + " | " + Mtri[k][2] + " |\n";
        }

        return texto;
    }

    //para organizar, uso burbuja
    public void Reconstruir() {

        for (int i = 1; i < Mtri[0][2]; i++) {

            for (int j = i + 1; j <= Mtri[0][2]; j++) {

                if (Mtri[i][0] > Mtri[j][0]
                        || (Mtri[i][0] == Mtri[j][0] && Mtri[i][1] > Mtri[j][1])) {

                    int tempFila = Mtri[i][0];
                    int tempCol = Mtri[i][1];
                    int tempDato = Mtri[i][2];

                    Mtri[i][0] = Mtri[j][0];
                    Mtri[i][1] = Mtri[j][1];
                    Mtri[i][2] = Mtri[j][2];

                    Mtri[j][0] = tempFila;
                    Mtri[j][1] = tempCol;
                    Mtri[j][2] = tempDato;
                }
            }
        }
    }

    public void Insertar(int fila, int columna, int dato) {

        int k = 1;

        if (fila >= Mtri[0][0] || columna >= Mtri[0][1]) {
            System.out.println("Lo que quiere ingresar es superior al tamano de la matriz");
            return;
        }

        if (fila < 0 || columna < 0) {
            System.out.println(" -? ");
            return;
        }

        if (dato == 0) {
            System.out.println("??");
            return;
        }
        boolean encontrado = false;
        while (k <= Mtri[0][2]) {

            if (Mtri[k][0] == fila && Mtri[k][1] == columna) {

                JOptionPane.showMessageDialog(null, "La fila y columna que quiere ingresar ya tiene asignado un dato");
                int opc = Integer.parseInt(JOptionPane.showInputDialog("1.sumar 2. Reemplazar 3. Dejar igual"));
                switch (opc) {

                    case 1:
                        Mtri[k][2] += dato;

                        break;

                    case 2:
                        Mtri[k][2] = dato;

                        break;

                    case 3:
                        JOptionPane.showMessageDialog(null, "Se ah dejado igual la matriz");

                        break;
                }

                break;

            }
            k++;
        }
        if (!encontrado) {
            int aux[][] = new int[Mtri.length + 1][3];
            int pos = Mtri[0][2] + 1;

            for (int i = 0; i < Mtri.length; i++) {
                aux[i][0] = Mtri[i][0];
                aux[i][1] = Mtri[i][1];
                aux[i][2] = Mtri[i][2];
            }

            aux[pos][0] = fila;
            aux[pos][1] = columna;
            aux[pos][2] = dato;
            aux[0][2] = pos;

            Mtri = aux;

            Reconstruir();

        }

    }

    public void Eliminarcoordenada(int Efila, int Ecolumna) {

        if (Efila < 0 || Ecolumna < 0) {
            JOptionPane.showMessageDialog(null, "Índices negativos no válidos");
            return;
        }
        if (Efila > Mtri[0][0] || Ecolumna > Mtri[0][1]) {
            JOptionPane.showMessageDialog(null, "Fuera del tamaño de la matriz");
            return;
        }

        boolean encontrado = false;
        int posEliminar = -1;

        for (int k = 1; k <= Mtri[0][2]; k++) {
            if (Mtri[k][0] == Efila && Mtri[k][1] == Ecolumna) {
                encontrado = true;
                posEliminar = k;
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No existe un dato en esa posición");
            return;
        }

        int[][] aux = new int[Mtri.length - 1][3];

        int auxK = 0;
        for (int i = 0; i < Mtri.length; i++) {
            if (i == posEliminar) {
                continue;
            }
            aux[auxK][0] = Mtri[i][0];
            aux[auxK][1] = Mtri[i][1];
            aux[auxK][2] = Mtri[i][2];
            auxK++;
        }

        aux[0][2] = Mtri[0][2] - 1;

        Mtri = aux;
        Reconstruir();
        JOptionPane.showMessageDialog(null, "Dato eliminado correctamente");
    }

    public void Eliminardato(int Dato) {
        if (Dato == 0) {
            JOptionPane.showMessageDialog(null, "Bruh");
            return;

        }

        int contador = 0;

        for (int k = 1; k <= Mtri[0][2]; k++) {
            if (Mtri[k][2] == Dato) {
                contador += 1;

            }
        }
        if (contador == 0) {
            JOptionPane.showMessageDialog(null, "Bro, faltan unas gafitas");
            return;
        }

        int[][] aux = new int[Mtri.length - contador][3];
        aux[0][0] = Mtri[0][0];
        aux[0][1] = Mtri[0][1];
        aux[0][2] = Mtri[0][2] - contador;
        int auxK = 1;
        for (int i = 1; i < Mtri.length; i++) {
            if (Mtri[i][2] != Dato) {
                aux[auxK][0] = Mtri[i][0];
                aux[auxK][1] = Mtri[i][1];
                aux[auxK][2] = Mtri[i][2];
                auxK++;

            }
        }

        Mtri = aux;
        Reconstruir();
        JOptionPane.showMessageDialog(null, "Dato eliminado correctamente");

    }

    public int[] SumarFilas() {
    int totalFilas = Mtri[0][0]; // número de filas 
    int[] sumasPorFila = new int[totalFilas + 1];

    for (int i = 1; i <= Mtri[0][2]; i++) {
        int fila = Mtri[i][0];
        sumasPorFila[fila] += Mtri[i][2];
    }

    return sumasPorFila;
}

    public int[] SumarColumnas() {
    int totalColumnas = Mtri[0][1]; // número de filas 
    int[] sumasPorColumna = new int[totalColumnas + 1];

    for (int i = 1; i <= Mtri[0][2]; i++) {
        int columnas = Mtri[i][1];
        sumasPorColumna[columnas] += Mtri[i][2];
    }

    return sumasPorColumna;
}

    public Tripleta suma(Tripleta B) {
        if(Mtri[0][0] != B.getMtri(0, 0) || Mtri[0][1] != B.getMtri(0, 1)){
            JOptionPane.showMessageDialog(null, "Bro?");
            return null ;
        }
        int Max = Mtri[0][2] + B.getMtri(0, 2);
        Tripleta C = new Tripleta(Max + 1);
        C.setMtri(0, 0, Mtri[0][0]); // filas
    C.setMtri(0, 1, Mtri[0][1]); // columnas
    C.setMtri(0, 2, 0);
    
    int i = 1, j = 1  ,k =1;
  while (i <= Mtri[0][2] && j <= B.getMtri(0, 2)) {

    if (Mtri[i][0] == B.getMtri(j, 0) && Mtri[i][1] == B.getMtri(j, 1)) {
        int dato = Mtri[i][2] + B.getMtri(j, 2);
        if (dato != 0) {
            C.setMtri(k, 0, Mtri[i][0]);
            C.setMtri(k, 1, Mtri[i][1]);
            C.setMtri(k, 2, dato);
            k++;
        }
        i++; j++;

    } else if (Mtri[i][0] < B.getMtri(j, 0) || (Mtri[i][0] == B.getMtri(j, 0) && Mtri[i][1] < B.getMtri(j, 1))) {
        C.setMtri(k, 0, Mtri[i][0]);
        C.setMtri(k, 1, Mtri[i][1]);
        C.setMtri(k, 2, Mtri[i][2]);
        i++; k++;

    } else  {
        C.setMtri(k, 0, B.getMtri(j, 0));
        C.setMtri(k, 1, B.getMtri(j, 1));
        C.setMtri(k, 2, B.getMtri(j, 2));
        j++; k++;
    }
}
   while(i <= Mtri[0][2]){
        C.setMtri(k, 0, Mtri[i][0]); //Fila
C.setMtri(k, 1, Mtri[i][1]); // Columna
C.setMtri(k, 2, Mtri[i][2]); // Dato
       i++; k++;
   
   }
    while(j <= B.getMtri(0, 2)){
        C.setMtri(k, 0,B.getMtri(j, 0)); //Fila
            C.setMtri(k, 1,B.getMtri(j, 1)); //Fila
             C.setMtri(k, 2,B.getMtri(j, 2)); //Fila
   k++; j++;
   }
C.setMtri(0, 2, k - 1);
        return C;

    }

}
