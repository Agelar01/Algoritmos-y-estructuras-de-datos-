package aed;

public class Horario {
    private int horaHorario;
    private int minHorario;
    public Horario(int hora, int minutos) {
        horaHorario = hora;
        minHorario = minutos;
    }

    public int hora() {
        return horaHorario;
    }

    public int minutos() {
        return minHorario;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append(horaHorario);
        sbuffer.append(":");
        sbuffer.append(minHorario);
        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {
        boolean oen = (otro == null);
        boolean cd = otro.getClass() != this.getClass(); 

        if (oen || cd) {
            return false;
        }

        Horario otroHorario = (Horario) otro;

        return horaHorario == otroHorario.horaHorario && minHorario == otroHorario.minHorario;
    }

}
