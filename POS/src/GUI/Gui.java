package GUI;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application implements EventHandler<ActionEvent> {
	
	private Stage stage;
	private Scene scene1;
	private Scene scene2;
	private Scene scene3;
	private Button videre;
	private Button bekræft;

	
	
	@Override
	public void start(Stage stage) throws Exception {
				
		this.stage = stage;
		
		TextField id = new TextField();
		Label idPrompt = new Label("Indtast medarbejderens id her");
		ComboBox<Rolle> rolle = new ComboBox<Rolle>();
		Label rollePrompt = new Label("Vælg medarbejderens rolle her");
		ComboBox<OrgEnhed> enhed = new ComboBox<OrgEnhed>();
		Label enhedPrompt = new Label("Vælg medarbejderens organisatoriske enhed her");
		videre = new Button("Videre");
		videre.setOnAction(this);
		
		GridPane grid1 = new GridPane();
		grid1.add(idPrompt, 0, 0);
		grid1.add(id, 1, 0);
		grid1.add(rollePrompt, 0, 1);
		grid1.add(rolle, 1, 1);
		grid1.add(enhedPrompt, 0, 2);
		grid1.add(enhed, 1, 2);
		grid1.add(videre, 0, 3);
		setPaddingAndGaps(grid1);
		
		scene1 = new Scene(grid1);
		
		
		
		Label bekræftId = new Label("*brugers id*");
		Label bekræftRolle = new Label("*valgt rolle*");
		Label bekræftEnhed = new Label("*valgt enhed*");
		bekræft = new Button("Bekræft");
		bekræft.setOnAction(this);
		
		
		GridPane grid2 = new GridPane();
		grid2.add(bekræftId, 0, 0);
		grid2.add(bekræftRolle, 0, 1);
		grid2.add(bekræftEnhed, 0, 2);
		grid2.add(bekræft, 0, 3);
		setPaddingAndGaps(grid2);
		
		scene2 = new Scene(grid2);
		
		
		Label done = new Label("Medarbejderen er oprettet");
		GridPane grid3 = new GridPane();
		grid3.add(done, 0, 0);
		setPaddingAndGaps(grid3);
		
		scene3 = new Scene(grid3);
		
		stage.setScene(scene1);
		stage.show();
		
		
		
	}
	
	private void setPaddingAndGaps(GridPane grid) {
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
	}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void handle(ActionEvent e) {
		Button btn = (Button) e.getSource();
		
		if (btn.equals(videre))
			stage.setScene(scene2);
		
		else if(btn.equals(bekræft))
			stage.setScene(scene3);
		
		
	}

}
