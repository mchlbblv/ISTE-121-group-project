import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * Server - Multi-threaded server with start/stop
 * button to control server connections
 * @author  M. Bobilev, J. Henry
 * @version 2205
 */

public class Server extends Application implements EventHandler<ActionEvent> {
   // attributes
	private Stage stage;
	private Scene scene;
	private VBox root = new VBox(8);  
   
   private Button btnChoose = new Button("Choose Folder");
   private TextField tfDirectory = new TextField();
   private Label lblStart = new Label("Start the server: ");
   private Button btnStart = new Button("Start");
   private TextArea taLog = new TextArea();
   
   // Main instantiates an instance of this GUI class
	public static void main(String[] args) {
		launch(args);
	}
   
   // constructor
	public void start(Stage _stage) throws Exception {
		stage = _stage;
		stage.setTitle("DertBloque's TFTP Server");
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent evt) {
				System.exit(0);
			}
		});
      
      // addition of GUI elements into GUI
      FlowPane fpTop = new FlowPane();
      FlowPane fpMid = new FlowPane();
      FlowPane fpMidBot = new FlowPane();
      FlowPane fpBot = new FlowPane();
      fpTop.getChildren().add(btnChoose);
      fpMid.getChildren().add(tfDirectory);
      tfDirectory.setPrefWidth(300);
      fpMidBot.getChildren().addAll(lblStart, btnStart);
      fpBot.getChildren().add(taLog);
      taLog.setPrefWidth(300);
      taLog.setPrefHeight(300);
      btnStart.setStyle("-fx-background-color: #00ff00");
      root.getChildren().addAll(fpTop, fpMid, fpMidBot, fpBot);
      
      // button behavior
      btnStart.setOnAction(this);
      
      scene = new Scene(root, 300, 400);
      stage.setScene(scene);
      stage.setX(640);
      stage.setY(100);
      stage.show();
   }
   
   // handle
	public void handle(ActionEvent evt) {
		// Get the object of the button that was clicked
		Button btn = (Button) evt.getSource();

		switch (btn.getText()) {
		case "Start":
         doStart();
			break;
      case "Stop":
         doStop();
         break;
      case "Choose Folder":
         break;
		}
	} 
   
   // method to be activated when "Start" is clicked
   public void doStart() {
      btnStart.setText("Stop");
      btnStart.setStyle("-fx-background-color: #ff0000");
      btnChoose.setDisable(true);
      tfDirectory.setDisable(true);
   } 
   
   // method to be activated when "Stop" is clicked
   public void doStop() {
      btnStart.setText("Start");  
      btnStart.setStyle("-fx-background-color: #00ff00");
      btnChoose.setDisable(false);
      tfDirectory.setDisable(false);
   }
}