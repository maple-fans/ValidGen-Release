package gui;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ValidateDialog extends Application {
	
	public CompletableFuture<Map<String, Object>> showInputDialog(String title, Stage parentStage) {
		CompletableFuture<Map<String, Object>> userInput = new CompletableFuture<>();

        Platform.runLater(() -> {
        	Dialog<String> dialog = new Dialog<>();

            dialog.initModality(Modality.APPLICATION_MODAL);
            dialog.initOwner(parentStage);
            dialog.setTitle("Set Validate Result: " + title);
            dialog.setHeaderText("Validate " + title);

            Button okButton = new Button("Validated");
            Button cancelButton = new Button("Reject");
            
            dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            Button closeButton = (Button) dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
            closeButton.setVisible(Boolean.FALSE);
            
            okButton.setMinWidth(150);
            cancelButton.setMinWidth(150);
            
            HBox hbox = new HBox(10);
            hbox.getChildren().addAll(okButton, cancelButton);
            
            dialog.getDialogPane().setContent(new VBox(10, hbox));

            okButton.setOnAction(e -> {
                userInput.complete(Map.of("validated", Boolean.TRUE));
                dialog.close();
            });

            cancelButton.setOnAction(e -> {
            	userInput.complete(Map.of("validated", Boolean.FALSE));
                dialog.close();
            });

            dialog.showAndWait();
        });

        return userInput;
    }

	@Override
	public void start(Stage stage) throws Exception {
	}
}