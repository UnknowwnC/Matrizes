package matdisper;
import javax.swing.JOptionPane;
 
public class Forma2 {

    private Nodo Punta;
    private int filas;
    private int columnas;

    public Forma2(int f, int c) {
        filas = f;
        columnas = c;

        Punta = new Nodo(0, 0, 0);
        Punta.setLf(Punta);
        Punta.setLc(Punta);
    }

   

    public void llenar(int[][] matriz) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] != 0) {
                    Nodo nuevo = new Nodo(i, j, matriz[i][j]);
                    insertarFila(nuevo);
                    insertarColumna(nuevo);
                }
            }
        }
    }



    private void insertarFila(Nodo nuevo) {
        Nodo p = Punta.getLf();
        Nodo anterior = Punta;

        while (p != Punta && p.getFila() <= nuevo.getFila()) {

            anterior = p;
            p = p.getLf();
        }

        anterior.setLf(nuevo);
        nuevo.setLf(p);
    }

    private void insertarColumna(Nodo nuevo) {
        Nodo p = Punta.getLc();
        Nodo anterior = Punta;

        while (p != Punta && p.getCol() <= nuevo.getCol()) {

            anterior = p;
            p = p.getLc();
        }

        anterior.setLc(nuevo);
        nuevo.setLc(p);
    }


    
    //para mostrar Lf  
    public String Mostrar(int tamFilaa, int taColumna) {
        String salida = "";
        Nodo p = Punta.getLf();
        Nodo anterior = Punta;
        anterior.setFila(tamFilaa);
        anterior.setCol(taColumna);
        salida += "( " + anterior.getFila() + " , " + anterior.getCol() + ") = " + anterior.getDato() + "-->";
        while (p != Punta) {
            salida += "(" + p.getFila() + " , " + p.getCol() + ") = " + p.getDato() + "-->";
            p = p.getLf();
        }
        return salida;
    }

 
    
    // para mostrar Lc  
    public String Mostrar2(int tamFilaa, int taColumna) {
        String salida = "";
        Nodo x = Punta.getLc();
        Nodo anterior = Punta;
        anterior.setFila(tamFilaa);
        anterior.setCol(taColumna);
        salida += "( " + anterior.getFila() + " , " + anterior.getCol() + ") = " + anterior.getDato() + "-->";
        while (x != Punta) {
            salida += "(" + x.getFila() + " , " + x.getCol() + ") = " + x.getDato() + "-->";
            x = x.getLc();
        }
        return salida;
    }

    
   
    public void sumarFilas() {
        String mensaje = "";
        for (int i = 0; i < filas; i++) {
            int sumar = 0;
            Nodo p = Punta.getLf();
            while (p != Punta) {
                if (p.getFila() == i) {
                    sumar += p.getDato();
                }

                p = p.getLf();
            }
            mensaje += "Suma fila " + i + " = " + sumar + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);

    }


    public void sumarColumnas() {
        String mensaje = "";
        for (int i = 0; i < columnas; i++) {
            int sumaC = 0;
            Nodo p = Punta.getLc();
            while (p != Punta) {
                if (p.getCol() == i) {
                    sumaC += p.getDato();
                }
                p = p.getLc();
            }
            mensaje += "Suma columna " + i + " = " + sumaC;
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }

   
    public void insertar(int posfil, int poscol, int num) {
      
        if (posfil < 0 || posfil >= filas || poscol < 0 || poscol >= columnas) {
            JOptionPane.showMessageDialog(null, "Molto Alto mano ");
            return;
        }
        Nodo p = Punta.getLf();
        Nodo x = null;
        boolean existe = false;
        while (p != Punta && existe == false) {

            if (p.getFila() == posfil && p.getCol() == poscol) {
                existe = true;
                x = p;
            }
            p = p.getLf();
        }

        if (existe == false) {
            Nodo l = new Nodo(posfil, poscol, num);
            insertarFila(l);
            insertarColumna(l);

        } else {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("La posicion ya existe\n 1. Sumar\n 2. Reemplazar\n 3. Dejar igual"));

            if (opc == 1) {
                x.setDato(x.getDato() + num);

            } else if (opc == 2) {
                x.setDato(num);

            } else if (opc <= 0 || opc > 3) {
                JOptionPane.showMessageDialog(null, "Juanjose no escojas opciones que no existen ome");
            }
        }
    }
    public void insertar2(int posfil, int poscol, int num) {

    
    if (posfil < 0 || posfil >= filas || poscol < 0 || poscol >= columnas) {
        JOptionPane.showMessageDialog(null, "Posición fuera del rango");
        return;
    }

    Nodo p = Punta.getLf();
    Nodo x = null;
    boolean existe = false;

   
    while (p != Punta && !existe) {

        if (p.getFila() == posfil && p.getCol() == poscol) {
            existe = true;
            x = p;
        }

        p = p.getLf();
    }

    
    if (!existe) {
        Nodo l = new Nodo(posfil, poscol, num);
        insertarFila(l);
        insertarColumna(l);
    }
    
    else {
        x.setDato(x.getDato() + num);
    }
}

  
    
    public void Eliminardato(int Dato) {

        

        Nodo p = Punta.getLf();
        Nodo ant = Punta; // inicia en Punta

        while (p != Punta && p.getDato() != Dato) {
            ant = p;
            p = p.getLf();
        }

        if (p == Punta) {
            JOptionPane.showMessageDialog(null, "No existe ese dato");
            return;
        }

        // solo hay un nodo
        if (p == Punta.getLf() && p.getLf() == Punta) {
            Punta.setLf(Punta);
        } // eliminar el primero 
        else if (p == Punta.getLf()) {
            Punta.setLf(p.getLf());
            ant.setLf(p.getLf()); // el último apunta al nuevo primero
        } else { // este else es para cuando halla q insertar 
            ant.setLf(p.getLf());
        }

        //de aca para abajo es liga columna
        Nodo pc = Punta.getLc();
        Nodo antc = Punta;

        while (pc != Punta && pc != p) {
            antc = pc;
            pc = pc.getLc();
        }

        if (pc != Punta) { // si lo encontró en columnas
            if (pc == Punta.getLc() && pc.getLc() == Punta) {
                Punta.setLc(Punta);
            } else if (pc == Punta.getLc()) {
                Punta.setLc(pc.getLc());
                antc.setLc(pc.getLc());
            } else {
                antc.setLc(pc.getLc());
            }
        }

        JOptionPane.showMessageDialog(null, "Nodo eliminado correctamente");
    }

    
    public void EliminarCoordenada(int Efila,int Ecolumna) {
       

        Nodo p = Punta.getLf();
        Nodo a = Punta;

        // Buscar Nodo en la Lf 
        while (p != Punta && (p.getFila() != Efila || p.getCol() != Ecolumna)) {
            a = p;
            p = p.getLf();
        }

        if (p == Punta) {
            JOptionPane.showMessageDialog(null, "No se encontraron esas coordenadas");
            return;
        }

       //elim de LF
        a.setLf(p.getLf());

       //elim de Lc
        Nodo q = Punta.getLc();
        Nodo aCol = Punta;

        //Buscar el nodo en la liga columna 
        while (q != Punta && q != p) {
            aCol = q;
            q = q.getLc();
        }

        if (q == p) {
            aCol.setLc(q.getLc());
        }

        JOptionPane.showMessageDialog(null, "Nodo eliminado correctamente");
    }

  

public Forma2 sumar(Forma2 B) {

    if (this.filas != B.filas || this.columnas != B.columnas) {
        JOptionPane.showMessageDialog(null, "No se pueden sumar");
        return null;
    }

    Nodo qb = B.Punta.getLf();

    // recorrer B
    while (qb != B.Punta) {

        Nodo pa = this.Punta.getLf();
        boolean existe = false;

        // buscar misma posicion en A
        while (pa != this.Punta) {

            if (pa.getFila() == qb.getFila() &&
                pa.getCol() == qb.getCol()) {

                pa.setDato(pa.getDato() + qb.getDato());
                existe = true;
                break;
            }

            pa = pa.getLf();
        }

        // si no existe en A entonces se insertar en A
        if (!existe) {
            this.insertar2(qb.getFila(), qb.getCol(), qb.getDato());
        }

        qb = qb.getLf();
    }

    return this;   
}
    
    public Forma2 multiplicar(Forma2 B) {

        if (this.columnas != B.filas) {
            JOptionPane.showMessageDialog(null, "No se pueden Multiplicar");
            return null;
        }

        Forma2 C = new Forma2(this.filas, B.columnas);

        Nodo p = this.Punta.getLf();

        while (p != this.Punta) {
            Nodo q = B.Punta.getLf();

            while (q != B.Punta) {
                if (p.getCol() == q.getFila()) {

                    int i = p.getFila();
                    int j = q.getCol();
                    int valor = p.getDato() * q.getDato();

                    C.insertar2(i, j, valor);
                }

                q = q.getLf();
            }

            p = p.getLf();
        }

        return C;
    }
    

}

        
        
    
    

    
    

