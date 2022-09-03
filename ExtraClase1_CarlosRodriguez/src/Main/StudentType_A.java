package Main;

import java.util.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
/**
 * Clase de estudiante A
 * Junto con su Método contructor de esta
 */
public class StudentType_A extends Receiver{

    public StudentType_A(String carne, String nombreCompleto, String correo, String Telefono, String nickname,
                         String tipoEstudiante, Integer notaPromedio_Examenes, Integer notaPromedio_Quices,
                         Integer notaPormedio_Tareas, Integer nota_Proyecto_1, Integer nota_Poryecto_2,
                         Integer nota_Proyecto_3, String nota_Promedio_A, String nota_Promedio_B, Integer nota_Final){
        super (carne, nombreCompleto, correo, Telefono, nickname,tipoEstudiante,notaPromedio_Examenes,
                notaPromedio_Quices,notaPormedio_Tareas, nota_Proyecto_1, nota_Poryecto_2, nota_Proyecto_3,
                nota_Promedio_A, nota_Promedio_B, nota_Final);
    }
    /**
     * Variante A de la abstracción
     *
     */
    @Override
    public String notaPromedio(){
        Integer prom_ETQ = 0;
        if (Objects.equals(getTipoEstudiante(), "A")){
            prom_ETQ = ((getNotaPormedio_Tareas() + getNotaPromedio_Examenes() + getNotaPromedio_Quices())/3);
            setNota_Promedio_A(Integer.toString(prom_ETQ));
        }
        return Integer.toString(prom_ETQ);
    }
    public Integer notaFinal(){
        Integer nota_final = 0;
        nota_final = (getNota_Proyecto_1() + getNota_Poryecto_2() + getNota_Proyecto_3() + getNotaPormedio_Tareas() +
                getNotaPromedio_Examenes() + getNotaPromedio_Quices())/6;
        setNota_Final(nota_final);
        return nota_final;
    }
}