package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {
    private Recordatorio[] array;
    private int tamaño;

    public ArregloRedimensionableDeRecordatorios() {
        tamaño = 0;
        array = new Recordatorio[1];
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        tamaño = vector.tamaño;
        array = new Recordatorio[vector.array.length];
        int i = 0;
        while (i < vector.array.length){
            array[i] = vector.array[i];
            i++;
        }
        
    }

    public int longitud() {
        return tamaño;
    }

    public void agregarAtras(Recordatorio i) {
        if(tamaño == 0) {
            array[0] = i;
        } else  {
            if(tamaño == array.length){
                Recordatorio[] arrayNuevo = new Recordatorio[tamaño*2];
                int j = 0;
                while (j < tamaño){
                    arrayNuevo[j] = array[j];
                    j++;
                }
            
                arrayNuevo[tamaño] = i;
                array = arrayNuevo;
            } else {
                array[tamaño] = i;
            }
        }
        tamaño++;
    }

    public Recordatorio obtener(int i) {
        return array [i];
    }

    public void quitarAtras() {
        Recordatorio[] arrayNuevo2 = new Recordatorio[tamaño - 1];
        int i = 0;
        while (i < tamaño -1){
            arrayNuevo2[i] = array[i];
            i++;
        }
        

        tamaño--;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        array[indice] = valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
       Recordatorio[] copiaDelArray = new Recordatorio[tamaño];
        for(int i = 0; i < tamaño; i++){
            copiaDelArray[i] = array[i];
        }
        ArregloRedimensionableDeRecordatorios copiaArray = new ArregloRedimensionableDeRecordatorios();
        copiaArray.tamaño = copiaDelArray.length;
        copiaArray.array = copiaDelArray;
        return copiaArray;
    }

}
