package ar.edu.unsl.fmn.entities;

import ar.edu.unsl.fmn.events.Arrival;
import ar.edu.unsl.fmn.events.EndOfService;

import java.util.ArrayList;

public class Aircraft extends Entity {

    private double cambiarnombreefectoODesgasteComoPinteEnIngles;

    public Aircraft() {
        super();
    }setear la var

    public Aircraft(int id) {
        super(id);
    } setear la var

    public Aircraft(int id, Arrival arrival) {
        super(id,arrival);
    } setear la var

    falta un metodo creo, traerlo
            el applyeffect del server hace:
    server.modoificarDurabilidad(this.getdesgaste())
    @Override
    public String toString() {
        return "type: aircraft - id: " + this.getId();
    }

}
