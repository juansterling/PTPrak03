package com.example.p_pt03_2072009.controller;
import com.example.p_pt03_2072009.HelloApplication;
import com.example.p_pt03_2072009.model.Barang;
import com.example.p_pt03_2072009.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BarangController {
    @FXML
    private TableView<Barang> tabel;
    @FXML
    private TableColumn coloumn1;
    @FXML
    private TableColumn coloumn2;
    @FXML
    private TableColumn coloumn3;
    @FXML
    private TextField idbarang;
    @FXML
    private TextField namabarang;
    @FXML
    private ComboBox<String> pilsupp;
    @FXML
    private Button savebarang;
    @FXML
    private Button resetbarang;
    @FXML
    private Button updatebarang;

    public ObservableList<Barang> barangList;
    private ObservableList<Supplier> suppList;
    private ObservableList<String> namaSupp;
    @FXML
    private FXMLLoader fxmlLoader;
    @FXML
    private Stage stage;
    @FXML
    private Label idlabelbarang;
    public int index;

    public void initialize() throws IOException {
        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Supplier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage = new Stage();
        stage.setTitle("Supplier Management");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        barangList = FXCollections.observableArrayList();
        tabel.setItems(barangList);
        coloumn1.setCellValueFactory(new PropertyValueFactory<>("idbarang"));
        coloumn2.setCellValueFactory(new PropertyValueFactory<>("namabarang"));
        coloumn3.setCellValueFactory(new PropertyValueFactory<>("supplier"));
    };
    public void resetbarang() {
        idbarang.clear();
        namabarang.clear();
        pilsupp.getSelectionModel().select(0);
        savebarang.setDisable(false);
        resetbarang.setDisable(false);
        updatebarang.setDisable(false);
    }
    @FXML
    protected void savebarang() {
        barangList.add(new Barang(idbarang.getText(),namabarang.getText(),pilsupp.getValue()));
        resetbarang();
    };
    @FXML
    public void updatebarang() {
        barangList.set(index,new Barang(idbarang.getText(),namabarang.getText(),pilsupp.getValue()));
        resetbarang();
    }

    @FXML
    public void barangdipilih(MouseEvent mouseEvent) {
        if (!tabel.getSelectionModel().getSelectedCells().isEmpty()) {
            savebarang.setDisable(true);
            updatebarang.setDisable(false);
            resetbarang.setDisable(false);
            index = tabel.getSelectionModel().getSelectedIndex();
        }
        idbarang.setText(tabel.getSelectionModel().getSelectedItem().getIdbarang());
        namabarang.setText(tabel.getSelectionModel().getSelectedItem().getNamabarang());
        pilsupp.setValue(tabel.getSelectionModel().getSelectedItem().getSupplier());
    }
    public void tosupplier() {
        stage.showAndWait();
        SupplierController supplierController = fxmlLoader.getController();
        suppList = supplierController.getSupplier();
        namaSupp = FXCollections.observableArrayList();
        for(Supplier supp: suppList) {
            namaSupp.add(supp.getNamasupp());
        }
        pilsupp.setItems(namaSupp);
        pilsupp.getSelectionModel().select(0);
    }
    public void closetab() {
        idlabelbarang.getScene().getWindow().hide();
    }
}
