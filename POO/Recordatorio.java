package aed;

public class Recordatorio {
    private String recordatorioMes;
    private Horario recordatorioHorario;
    private  Fecha  recordatorioFecha;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        recordatorioMes = mensaje;
        recordatorioFecha = new Fecha(fecha); 
        recordatorioHorario = horario;
    }

    public Horario horario() {
        return recordatorioHorario;
    }

    public Fecha fecha() {
        return new Fecha(recordatorioFecha);
    }

    public String mensaje() {
        return recordatorioMes;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(recordatorioMes);
        sbuffer.append(" ");
        sbuffer.append("@");
        sbuffer.append(" ");
        sbuffer.append(recordatorioFecha);
        sbuffer.append(" ");
        sbuffer.append(recordatorioHorario);
        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        if (this == otro) return true;
        if (otro == null || getClass() != otro.getClass()) return false;

        Recordatorio that = (Recordatorio) otro;
        return recordatorioMes.equals(that.recordatorioMes) &&
               recordatorioFecha.equals(that.recordatorioFecha) &&
               recordatorioHorario.equals(that.recordatorioHorario);
    }

}
