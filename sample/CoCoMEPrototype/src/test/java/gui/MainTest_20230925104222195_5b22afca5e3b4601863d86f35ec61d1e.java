/*
openStore -> openCashDesk -> processSale -> showStockReports -> processSale -> showStockReports -> closeCashDesk -> closeStore
*/
package gui;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.assertj.core.util.Lists;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import entities.EntityManager;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import services.impl.ServiceManager;

public class MainTest_20230925104222195_5b22afca5e3b4601863d86f35ec61d1e extends ApplicationTest {
	
	private List<String> menuName;
	private List<String> className;
	private Stage stage;
	private Boolean interactive;
	private String statePath;
	private Integer start;
	private Boolean isSnapshot;
	private List<File> entityFiles;
	private List<File> serviceFiles;
	
	@Override
	@SuppressWarnings("unchecked")
	public void start(Stage stage) throws Exception {
		new Main().start(stage);
		this.stage = stage;
		Scene scene = stage.getScene();
		Accordion accordion = (Accordion) scene.lookup("#leftAccordion");
		menuName = accordion.getChildrenUnmodifiable().stream().map(TitledPane.class::cast)
						.map(TitledPane::getText).toList();
		TableView<String> pane = (TableView<String>) scene.lookup("#class_statisic");
		TableColumn<String, String> col = (TableColumn<String, String>) pane.getColumns().get(0);
		className = IntStream.range(0, Integer.MAX_VALUE).mapToObj(i -> col.getCellData(i)).takeWhile(Objects::nonNull).toList();
		this.statePath = "D:/Coding/com.rm2pt.generator.testgen.remodel/CoCoME/RequirementsModel/State/";
		this.start = 0;
		this.isSnapshot = Boolean.FALSE;
		this.entityFiles = Lists.newArrayList();
		this.serviceFiles = Lists.newArrayList();
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Choose Mode");
		alert.setHeaderText("Choose Mode");
		ButtonType buttonInteractive = new ButtonType("Interactive");
		ButtonType buttonAuto = new ButtonType("Auto", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(buttonInteractive, buttonAuto);
		Optional<ButtonType> result = alert.showAndWait();
		interactive = Objects.equals(buttonInteractive, result.get());
	
		File file = new File(statePath);
		List<String> snaps = Arrays.stream(file.list()).filter(s -> s.matches(".*snap")).toList();
		ChoiceDialog<String> dialog = new ChoiceDialog<>("snapshots", snaps);
		dialog.setTitle("Choice Snapshot");
		dialog.setHeaderText("Choice Snapshot");
		Optional<String> snapResult = dialog.showAndWait();
		snapResult.ifPresentOrElse(e -> {
			if(Objects.equals(e, "snapshots")) {
				this.start = 0;
				return;
			}
			String path = this.statePath + e;
			this.isSnapshot = Boolean.TRUE;
			try {
				String info = Files.readString(Path.of(path), StandardCharsets.UTF_8);
				String[] infos = info.split(" ");
				this.start = Integer.parseInt(infos[0]);
				File entityFile = new File(this.statePath + infos[1]);
				EntityManager.load(entityFile);
				File serviceFile = new File(this.statePath + infos[2]);
				ServiceManager.load(serviceFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}, () ->  this.start = 0 );
	}
	
	private Integer getTabCount(String name) {
		return menuName.size() - menuName.indexOf(name);
	}
	
	public void testOpenStore_0(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#storemanager").sleep(1000).doubleClickOn("openStore");
		clickOn("openStore").type(KeyCode.TAB, getTabCount("StoreManager"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 4).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("openStore", Boolean.TRUE, id);
		doubleClickOn("openStore");
	}
	
	public void testOpenCashDesk_1(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#cashier").sleep(1000).doubleClickOn("openCashDesk");
		clickOn("openCashDesk").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 4).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("openCashDesk", Boolean.TRUE, id);
		doubleClickOn("openCashDesk");
	}
	
	public void testProcessSale_2(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#cashier").sleep(1000).doubleClickOn("processSale");
		clickOn("makeNewSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeNewSale", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("10").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input2");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("2").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("endSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("endSale", Boolean.FALSE, id);
		clickOn("makeCashPayment").type(KeyCode.TAB, getTabCount("Cashier"));
		type(KeyCode.TAB);
		write("300").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeCashPayment", Boolean.FALSE, id);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("processSale", Boolean.TRUE, id);
		doubleClickOn("processSale");
	}
	
	public void testProcessSale_3(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#cashier").sleep(1000).doubleClickOn("processSale");
		clickOn("makeNewSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeNewSale", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("10").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input2");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("2").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("endSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("endSale", Boolean.FALSE, id);
		clickOn("makeCardPayment").type(KeyCode.TAB, getTabCount("Cashier"));
		type(KeyCode.TAB);
		write("1").sleep(1000);
		type(KeyCode.TAB);
		write("2024-01-02").sleep(1000);
		type(KeyCode.TAB);
		write("300").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeCardPayment", Boolean.FALSE, id);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("processSale", Boolean.TRUE, id);
		doubleClickOn("processSale");
	}
	
	public void testShowStockReports_4(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#storemanager").sleep(1000).doubleClickOn("showStockReports");
		clickOn("showStockReports").type(KeyCode.TAB, getTabCount("StoreManager"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("showStockReports", Boolean.TRUE, id);
		doubleClickOn("showStockReports");
	}
	
	public void testProcessSale_5(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#cashier").sleep(1000).doubleClickOn("processSale");
		clickOn("makeNewSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeNewSale", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("10").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input2");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("2").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("endSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("endSale", Boolean.FALSE, id);
		clickOn("makeCashPayment").type(KeyCode.TAB, getTabCount("Cashier"));
		type(KeyCode.TAB);
		write("300").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeCashPayment", Boolean.FALSE, id);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("processSale", Boolean.TRUE, id);
		doubleClickOn("processSale");
	}
	
	public void testProcessSale_6(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#cashier").sleep(1000).doubleClickOn("processSale");
		clickOn("makeNewSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeNewSale", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("10").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("enterItem").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input2");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 5).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		type(KeyCode.TAB);
		write("2").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("enterItem", Boolean.FALSE, id);
		clickOn("endSale").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("endSale", Boolean.FALSE, id);
		clickOn("makeCardPayment").type(KeyCode.TAB, getTabCount("Cashier"));
		type(KeyCode.TAB);
		write("1").sleep(1000);
		type(KeyCode.TAB);
		write("2024-01-02").sleep(1000);
		type(KeyCode.TAB);
		write("300").sleep(1000);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("makeCardPayment", Boolean.FALSE, id);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("processSale", Boolean.TRUE, id);
		doubleClickOn("processSale");
	}
	
	public void testShowStockReports_7(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#storemanager").sleep(1000).doubleClickOn("showStockReports");
		clickOn("showStockReports").type(KeyCode.TAB, getTabCount("StoreManager"));
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("showStockReports", Boolean.TRUE, id);
		doubleClickOn("showStockReports");
	}
	
	public void testCloseCashDesk_8(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#cashier").sleep(1000).doubleClickOn("closeCashDesk");
		clickOn("closeCashDesk").type(KeyCode.TAB, getTabCount("Cashier"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 4).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("closeCashDesk", Boolean.TRUE, id);
		doubleClickOn("closeCashDesk");
	}
	
	public void testCloseStore_9(Integer id) throws InterruptedException, ExecutionException, IOException {
		clickOn("#storemanager").sleep(1000).doubleClickOn("closeStore");
		clickOn("closeStore").type(KeyCode.TAB, getTabCount("StoreManager"));
		clickOn("SelectInput").doubleClickOn("input1");
		press(KeyCode.SHIFT).type(KeyCode.TAB, 4).release(KeyCode.SHIFT);
		type(KeyCode.TAB);
		clickOn("#execute").sleep(1000);
		if(Objects.equals(Boolean.TRUE, this.interactive))
			validate("closeStore", Boolean.TRUE, id);
		doubleClickOn("closeStore");
	}
	
	public void validate(String name, Boolean isUseCase, Integer id) throws InterruptedException, ExecutionException, IOException {
		ValidateDialog dialog = new ValidateDialog();
		Map<String, Object> result = dialog.showInputDialog(name, stage).get();
		Boolean validated = (Boolean) result.get("validated");
		if(Objects.equals(validated, Boolean.FALSE)) {
			String uuid = UUID.randomUUID().toString();
			File entityFile = entityFiles.get(entityFiles.size() - 1);
			File serviceFile = serviceFiles.get(serviceFiles.size() - 1);
			Files.move(Path.of(entityFile.getAbsolutePath()), Path.of(this.statePath + entityFile.getName()));
			Files.move(Path.of(serviceFile.getAbsolutePath()), Path.of(this.statePath + serviceFile.getName()));
			String snapShotInfo = List.of(id.toString(), entityFile.getName(), serviceFile.getName()).stream().collect(Collectors.joining(" "));
			Files.write(Path.of(statePath + uuid + ".snap"), snapShotInfo.getBytes(StandardCharsets.UTF_8));
		}
		String uuid = UUID.randomUUID().toString();
		File entityFile = File.createTempFile(statePath + uuid, "_entity.state");
		File serviceFile = File.createTempFile(statePath + uuid, "_service.state");
		EntityManager.save(entityFile);
		ServiceManager.save(serviceFile);
		entityFiles.add(entityFile);
		serviceFiles.add(serviceFile);
	}
	
	@Test
	public void integrationTest() throws InterruptedException, ExecutionException, IOException {
		if(Objects.equals(this.isSnapshot, Boolean.FALSE)) {
			File input = new File("D:/Coding/com.rm2pt.generator.testgen.remodel/CoCoME/RequirementsModel/InputGen/test_chat.yaml");
			try {
				EntityManager.loadFile(input);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		showSystemState();
		List<Runnable> useCases = List.of(
		() -> {
			try {
				testOpenStore_0(0);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testOpenCashDesk_1(1);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testProcessSale_2(2);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testProcessSale_3(3);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testShowStockReports_4(4);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testProcessSale_5(5);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testProcessSale_6(6);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testShowStockReports_7(7);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testCloseCashDesk_8(8);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		,
		() -> {
			try {
				testCloseStore_9(9);
			} catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			}
		}
		);
		for(Integer i = this.start; i < useCases.size(); ++i)
			useCases.get(i).run();
	}
	
	@Test
	public void showSystemState() {
		clickOn("System State").sleep(1000);
		className.forEach(e -> clickOn(e).sleep(1000));
		clickOn("System Function");
	}
	
}

