package game.of.life;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Layout extends Stage{
    
    final private static String TITLE = "Game of Life"; 
    final private static int SPACING = 20;
    final private static int PADDING_VALUE = 20;
    final private static Insets PADDING = new Insets(PADDING_VALUE);
    
    private Scene root;
    private BorderPane layout;
    private Grid petri;
    private VBox controls;
    private HBox actions, typeOfGrid;
    private Button start, stop, step, clear;
    private ToggleGroup typeGroup;
    private ToggleButton finite, infinite;
    private Text title;
    
    private int TYPE=1;
    
    public Layout(int n, boolean fullscreen) {
        setGrid(n);
        setButtons();
        setLayout();
        root = new Scene(layout);
        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent t) {
                if (t.getCode() == KeyCode.ESCAPE) {
                    close();
                }
            }
        });
        
        setScene(root);
        if (fullscreen) {
            setFullScreen(true);
        }
        setTitle(TITLE);
        show();
    }
    
    public Layout(Scene s) {
        setScene(s);
        setTitle(TITLE);
        show();
    }
    
    private void setLayout() {
        
        layout = new BorderPane();
        controls = new VBox();
        typeOfGrid = new HBox();
        actions = new HBox();
        title = new Text(TITLE);
        
        title.setFont(new Font("VERDANA", 20));
        
        typeOfGrid.getChildren().addAll(finite, infinite);
        typeOfGrid.setSpacing(SPACING);
        typeOfGrid.setAlignment(Pos.CENTER); 
        
        actions.getChildren().addAll(start, stop, step, clear);
        actions.setSpacing(SPACING);
        actions.setPadding(PADDING);
        actions.setAlignment(Pos.CENTER);
        
        controls.getChildren().addAll(typeOfGrid, actions);
        controls.setSpacing(SPACING);
        controls.setPadding(PADDING);
        actions.setAlignment(Pos.CENTER);
        
        BorderPane.setAlignment(title, Pos.BOTTOM_CENTER);
        
        layout.setTop(title);
        layout.setCenter(petri.getGrid());
        layout.setBottom(controls);
        
    }
    
    private void setButtons(){
        start = new Button("Start");
        stop = new Button("Stop");
        step = new Button("Step");
        clear = new Button("Clear Grid");
        
        ButtonListener startL = new ButtonListener(petri.getCellGrid(), step, this);
        ButtonListener stepL = new ButtonListener(petri.getCellGrid(),this);
        
        step.setId("step");
        step.addEventHandler(ActionEvent.ACTION, stepL);
        start.setId("start");
        start.addEventHandler(MouseEvent.MOUSE_CLICKED, startL);
        stop.setId("stop");
        stop.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonListener(petri.getCellGrid(), startL,this));
        clear.setId("clear");
        clear.addEventHandler(MouseEvent.MOUSE_CLICKED, new ButtonListener(petri.getCellGrid(), petri,this));
        
        typeGroup = new ToggleGroup();
        finite = new ToggleButton("Finite Grid"); finite.setToggleGroup(typeGroup);
        infinite = new ToggleButton("Toroid Grid"); infinite.setToggleGroup(typeGroup);
        
        finite.setId("1");
        finite.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
              TYPE = 1; 
            }
        });
        infinite.setId("2");
        infinite.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
              TYPE = 2; 
            }
        });
    }
    
    private void setGrid(int n) {
        petri = new Grid(n);
    }
    
    public int getType() {
        return TYPE;
    }
    
    
}