package Main;


import javafx.application.Application;

import java.util.Objects;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * Super clase y abstracta. Tiene como función heredale los metodos constructores a las subclases
 * También los métodos de nota promedio y final son abstractos, para las subclases
 *
 */
public abstract class Receiver {

    private String carne;
    private String NombreCompleto;
    private String Correo;
    private String Nickname;
    private String Telefono;
    private String TipoEstudiante;
    private Integer NotaPromedio_Examenes;
    private Integer NotaPromedio_Quices;
    private Integer NotaPormedio_Tareas;
    private Integer Nota_Proyecto_1;
    private Integer Nota_Poryecto_2;
    private Integer Nota_Proyecto_3;

    private String nota_Promedio_A;

    private String nota_Promedio_B;

    private Integer nota_Final;

    public String getCarne() {
        return carne;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public String getCorreo() {
        return Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public String getNickname() {
        return Nickname;
    }

    public String getTipoEstudiante() {
        return TipoEstudiante;
    }

    public Integer getNotaPromedio_Examenes() {
        return NotaPromedio_Examenes;
    }

    public Integer getNotaPromedio_Quices() {
        return NotaPromedio_Quices;
    }

    public Integer getNotaPormedio_Tareas() {
        return NotaPormedio_Tareas;
    }

    public Integer getNota_Proyecto_1() {
        return Nota_Proyecto_1;
    }

    public Integer getNota_Poryecto_2() {
        return Nota_Poryecto_2;
    }

    public Integer getNota_Proyecto_3() {
        return Nota_Proyecto_3;
    }
    public String getNota_Promedio_B() {
        return nota_Promedio_B;
    }

    public void setNota_Promedio_B(String nota_Promedio_B) {
        this.nota_Promedio_B = nota_Promedio_B;
    }

    public String getNota_Promedio_A() {
        return nota_Promedio_A;
    }

    public void setNota_Promedio_A(String nota_Promedio_A) {
        this.nota_Promedio_A = nota_Promedio_A;
    }

    public Integer getNota_Final() {
        return nota_Final;
    }

    public void setNota_Final(Integer nota_Final) {
        this.nota_Final = nota_Final;
    }

    /**
     * Método constructor
     *
     */
    public Receiver(String carne, String nombreCompleto, String correo, String Telefono, String nickname,
                    String tipoEstudiante, Integer notaPromedio_Examenes, Integer notaPromedio_Quices,
                    Integer notaPormedio_Tareas, Integer nota_Proyecto_1, Integer nota_Poryecto_2,
                    Integer nota_Proyecto_3, String nota_Promedio_A, String nota_Promedio_B, Integer nota_Final) {

        this.carne = carne;
        this.NombreCompleto = nombreCompleto;
        this.Correo = correo;
        this.Telefono = Telefono;
        this.Nickname = nickname;
        this.TipoEstudiante = tipoEstudiante;
        this.NotaPromedio_Examenes = notaPromedio_Examenes;
        this.NotaPromedio_Quices = notaPromedio_Quices;
        this.NotaPormedio_Tareas = notaPormedio_Tareas;
        this.Nota_Proyecto_1 = nota_Proyecto_1;
        this.Nota_Poryecto_2 = nota_Poryecto_2;
        this.Nota_Proyecto_3 = nota_Proyecto_3;
        this.nota_Promedio_A = nota_Promedio_A;
        this.nota_Promedio_B = nota_Promedio_B;
        this.nota_Final = nota_Final;
    }
    /**
     * Metodos abstractos, para las subclases
     *
     */
    public abstract String notaPromedio();

    public abstract Integer notaFinal();

}