package Main;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import java.awt.event.ActionEvent;
import java.io.File;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 *La clase Main Controller, es el recibe toda la información, y se comunica con las otras clases, gráfica en el FX, crear
 * las listas de los estudiantes, el buscador de CSV, además se que tiene la función "start", la cual es llamada por
 * la "mainApp" para arrancar el código.
 */
public class MainController implements Initializable {

    /**
     *  Seteo de Listas y Variable del CSV
     *
     */
    private ObservableList<Receiver> Estudiantes;
    private File archivo;
    private ArrayList<StudentType_A> estudiA = new ArrayList<>();
    private ArrayList<StudentType_B> estudiB = new ArrayList<>();

    /**
     * Los datos que va a tener cada columna
     *
     */
    @FXML
    private TableView<Receiver> Tabla;
    @FXML
    private TableColumn<Receiver, String> Show_Carnet;
    @FXML
    private TableColumn<Receiver, String> Show_Nom;
    @FXML
    private TableColumn<Receiver, String> Show_Correo;
    @FXML
    private TableColumn<Receiver, String> Show_Tel;
    @FXML
    private TableColumn<Receiver, String> Show_Nick;
    @FXML
    private TableColumn<Receiver, String> Show_Type;
    @FXML
    private TableColumn<Receiver, Integer> Show_Examenes;
    @FXML
    private TableColumn<Receiver, Integer> Show_Quices;
    @FXML
    private TableColumn<Receiver, Integer> Show_Tareas;
    @FXML
    private TableColumn<Receiver, Integer> Show_P1;
    @FXML
    private TableColumn<Receiver, Integer> Show_P2;
    @FXML
    private TableColumn<Receiver, Integer> Show_P3;
    @FXML
    private TableColumn<Receiver, Integer> Show_PromA;
    @FXML
    private TableColumn<Receiver, Integer> Show_PromB;
    @FXML
    private TableColumn<Receiver, Integer> Show_PromF;

    FileChooser seleccionador = new FileChooser();
    /**
     * Función para recibir el CSV y cambiar el CSV
     *
     */
    @FXML
    private void getText(MouseEvent event) {
        archivo = seleccionador.showOpenDialog(new Stage());
    }
    /**
     *  Seteo de la fila, dependiendo la información entrante
     *
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Estudiantes = FXCollections.observableArrayList();
        this.Show_Carnet.setCellValueFactory(new PropertyValueFactory<>("Carne"));
        this.Show_Nom.setCellValueFactory(new PropertyValueFactory<>("NombreCompleto"));
        this.Show_Correo.setCellValueFactory(new PropertyValueFactory<>("Correo"));
        this.Show_Tel.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        this.Show_Nick.setCellValueFactory(new PropertyValueFactory<>("nickname"));
        this.Show_Type.setCellValueFactory(new PropertyValueFactory<>("TipoEstudiante"));
        this.Show_Examenes.setCellValueFactory(new PropertyValueFactory<>("notaPromedio_Examenes"));
        this.Show_Quices.setCellValueFactory(new PropertyValueFactory<>("notaPromedio_Quices"));
        this.Show_Tareas.setCellValueFactory(new PropertyValueFactory<>("notaPormedio_Tareas"));
        this.Show_P1.setCellValueFactory(new PropertyValueFactory<>("nota_Proyecto_1"));
        this.Show_P2.setCellValueFactory(new PropertyValueFactory<>("nota_Poryecto_2"));
        this.Show_P3.setCellValueFactory(new PropertyValueFactory<>("nota_Proyecto_3"));
        this.Show_PromA.setCellValueFactory(new PropertyValueFactory<>("nota_Promedio_A"));
        this.Show_PromB.setCellValueFactory(new PropertyValueFactory<>("nota_Promedio_B"));
        this.Show_PromF.setCellValueFactory(new PropertyValueFactory<>("nota_Final"));

    }
    /**
     * Función que inicia el proceso, envía los datos a las demás clases.
     * Hace la división entre tipo a y b
     */
    @FXML
    private void start() throws Exception{
        int borrar = 1;
        int limitador = 0;
        int n = 0;
        int m = 0;

        List<String> lista_Objetos = new ArrayList<>();
        Scanner lector = new Scanner(new File(String.valueOf(archivo)));
        lector.useDelimiter("[,:\r\n]+");
        while (lector.hasNext()) {
            if (borrar <=1) {
                lector.nextLine();
                borrar++;
            }
            if (limitador == 12) {
                if (Objects.equals(lista_Objetos.get(5), "A")){
                    estudiA.add(new StudentType_A(lista_Objetos.get(0), lista_Objetos.get(1), lista_Objetos.get(2),
                            lista_Objetos.get(3), lista_Objetos.get(4), lista_Objetos.get(5), Integer.parseInt(lista_Objetos.get(6)),
                            Integer.parseInt(lista_Objetos.get(7)), Integer.parseInt(lista_Objetos.get(8)),
                            Integer.parseInt(lista_Objetos.get(9)), Integer.parseInt(lista_Objetos.get(10)),
                            Integer.parseInt(lista_Objetos.get(11))," "," ",0));
                }
                else{
                    estudiB.add(new StudentType_B(lista_Objetos.get(0), lista_Objetos.get(1), lista_Objetos.get(2),
                            lista_Objetos.get(3), lista_Objetos.get(4), lista_Objetos.get(5), Integer.parseInt(lista_Objetos.get(6)),
                            Integer.parseInt(lista_Objetos.get(7)), Integer.parseInt(lista_Objetos.get(8)),
                            Integer.parseInt(lista_Objetos.get(9)), Integer.parseInt(lista_Objetos.get(10)),
                            Integer.parseInt(lista_Objetos.get(11)), " ", " ",0));
                }
                lista_Objetos.clear();
                limitador = 0;
                lector.nextLine();
            } else {
                lista_Objetos.add(lector.next());
                limitador++;
            }
        }
        if (Objects.equals(lista_Objetos.get(5), "A")){
            estudiA.add(new StudentType_A(lista_Objetos.get(0), lista_Objetos.get(1), lista_Objetos.get(2),
                    lista_Objetos.get(3), lista_Objetos.get(4), lista_Objetos.get(5), Integer.parseInt(lista_Objetos.get(6)),
                    Integer.parseInt(lista_Objetos.get(7)), Integer.parseInt(lista_Objetos.get(8)),
                    Integer.parseInt(lista_Objetos.get(9)), Integer.parseInt(lista_Objetos.get(10)),
                    Integer.parseInt(lista_Objetos.get(11))," "," ",0));
        }
        else{estudiB.add(new StudentType_B(lista_Objetos.get(0), lista_Objetos.get(1), lista_Objetos.get(2),
                lista_Objetos.get(3), lista_Objetos.get(4), lista_Objetos.get(5), Integer.parseInt(lista_Objetos.get(6)),
                Integer.parseInt(lista_Objetos.get(7)), Integer.parseInt(lista_Objetos.get(8)),
                Integer.parseInt(lista_Objetos.get(9)), Integer.parseInt(lista_Objetos.get(10)),
                Integer.parseInt(lista_Objetos.get(11))," "," ",0));
        }
        while(n < estudiA.size()){
            estudiA.get(n).notaFinal();
            estudiA.get(n).notaPromedio();
            n++;
        }
        while(m < estudiB.size()) {
            estudiB.get(m).notaFinal();
            estudiB.get(m).notaPromedio();
            m++;
        }
        Estudiantes.addAll(estudiA);
        Estudiantes.addAll(estudiB);
        this.Tabla.setItems(Estudiantes);
        lector.close();
    }
}