package aed;

import java.util.Vector;

public class Agenda {

    private Fecha fechaAgenda;
    private Vector<Recordatorio> recordatorioAgenda;  

    public Agenda(Fecha fechaActual) {
        Vector<Recordatorio> IniciaVector = new Vector<Recordatorio>(1);
        recordatorioAgenda = IniciaVector;
        fechaAgenda = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
    recordatorioAgenda.add(recordatorio);

    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(fechaAgenda);
        sbuffer.append("\n");
        sbuffer.append("=====");
        sbuffer.append("\n");
        int i = 0;
        while (i < recordatorioAgenda.size()){
            if(fechaAgenda.dia() == recordatorioAgenda.get(i).fecha().dia() && fechaAgenda.mes() == recordatorioAgenda.get(i).fecha().mes() ){
                sbuffer.append(recordatorioAgenda.get(i));
                sbuffer.append("\n");
                
            }
            i++;
        }
        return sbuffer.toString();
    }

    public void incrementarDia() {
        fechaAgenda.incrementarDia();

    }

    public Fecha fechaActual() {
        return fechaAgenda;
    }

}
