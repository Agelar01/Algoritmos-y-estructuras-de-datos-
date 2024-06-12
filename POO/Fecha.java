package aed;

public class Fecha {
    private  int diaFecha;
    private  int mesFecha;
    public Fecha(int dia, int mes) {
        diaFecha = dia;
        mesFecha = mes;
    }

    public Fecha(Fecha fecha) {
        diaFecha = fecha.diaFecha;
        mesFecha = fecha.mesFecha;
    }

    public Integer dia() {
        return diaFecha;
    }

    public Integer mes() {
        return mesFecha;
    }

    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(diaFecha);
        sbuffer.append("/");
        sbuffer.append(mesFecha);
        return sbuffer.toString();
        
    }

    @Override
    public boolean equals(Object otra) {
        boolean oen = (otra == null);
        boolean cd = otra.getClass() != this.getClass(); 

        if (oen || cd) {
            return false;
        }

        Fecha otraFecha = (Fecha) otra; 

        return diaFecha == otraFecha.diaFecha && mesFecha == otraFecha.mesFecha;
    }

    public void incrementarDia() {
        if(diasEnMes(mesFecha) == diaFecha){
            mesFecha++;
            diaFecha = 1;
            if(mesFecha == 13){
                mesFecha = 1; 
            }
        } else{
            diaFecha++;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
