package Main;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Clase de estudiante B
 * Junto con su Método contructor de esta
 */
public class StudentType_B extends Receiver {
    public StudentType_B(String carne, String nombreCompleto, String correo, String Telefono, String nickname,
                         String tipoEstudiante, Integer notaPromedio_Examenes, Integer notaPromedio_Quices,
                         Integer notaPormedio_Tareas, Integer nota_Proyecto_1, Integer nota_Poryecto_2,
                         Integer nota_Proyecto_3,String nota_Promedio_A, String nota_Promedio_B, Integer nota_Final){
        super (carne, nombreCompleto, correo, Telefono, nickname,tipoEstudiante,notaPromedio_Examenes,
                notaPromedio_Quices,notaPormedio_Tareas, nota_Proyecto_1, nota_Poryecto_2, nota_Proyecto_3,
                nota_Promedio_A, nota_Promedio_B, nota_Final);
    }

    /**
     * Variante B de la abstracción
     *
     */
    @Override
    public String notaPromedio(){
        Integer prom_proyectos = 0;
        if (Objects.equals(getTipoEstudiante(), "B")){
            prom_proyectos = ((getNota_Proyecto_1() + getNota_Poryecto_2() + getNota_Proyecto_3())/3);
            setNota_Promedio_B(Integer.toString(prom_proyectos));

        }
        return Integer.toString(prom_proyectos);
    }
    public Integer notaFinal(){
        Integer nota_final = 0;
        nota_final = (getNota_Proyecto_1() + getNota_Poryecto_2() + getNota_Proyecto_3() + getNotaPromedio_Examenes() +
                getNotaPromedio_Examenes() + getNotaPromedio_Quices() + getNotaPromedio_Examenes())/6;
        setNota_Final(nota_final);
        return nota_final;
    }
}