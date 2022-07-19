package com.example.p_pt03_2072009.controller;

import com.example.p_pt03_2072009.model.Supplier;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class SupplierController {
    @FXML
    private TableView<Supplier> tabel;
    @FXML
    private TableColumn coloumn1;
    @FXML
    private TableColumn coloumn2;
    @FXML
    private TableColumn coloumn3;
    @FXML
    private TextField idsupp;
    @FXML
    private TextField namasupp;
    @FXML
    private TextField alamat;
    @FXML
    private Button savesupp;
    @FXML
    private Button resetsupp;
    @FXML
    private Button updatesupp;
    @FXML
    private Label idlabelsupp;
    public int index;

    public ObservableList<Supplier> suppList;

    public SupplierController() {
    }

    public ObservableList<Supplier> getSupplier() {
        return suppList;
    }

    public void setSupplier(ObservableList<Supplier> supplier) {
        this.suppList = supplier;
    }

    public void initialize() {
        suppList = FXCollections.observableArrayList(
                new Supplier("1111", "Juan","Jalan Mawar"),
                new Supplier("2222", "Sterling","Jalan Melati"),
                new Supplier("3333", "Martua","Jalan Suci")

        );
        tabel.setItems(suppList);
        coloumn1.setCellValueFactory(new PropertyValueFactory<>("idsupp"));
        coloumn2.setCellValueFactory(new PropertyValueFactory<>("namasupp"));
        coloumn3.setCellValueFactory(new PropertyValueFactory<>("alamat"));
    };
    @FXML
    protected void resetsupp() {
        idsupp.clear();
        namasupp.clear();
        alamat.clear();
        savesupp.setDisable(false);
        resetsupp.setDisable(false);
        updatesupp.setDisable(false);
    }
    @FXML
    protected void savesupp() {
        String id = idsupp.getText();
        String nama = namasupp.getText();
        String alamatsupp = alamat.getText();
        suppList.add(new Supplier(id,nama,alamatsupp));
        resetsupp();
    };
    @FXML
    protected void updatesupp() {
        String upId = idsupp.getText();
        String upNama = namasupp.getText();
        String upAlamat = alamat.getText();
        suppList.set(index, new Supplier(upId, upNama, upAlamat));
        resetsupp();
    }

    @FXML
    public void supplierdipilih(MouseEvent mouseEvent) {
        if (!tabel.getSelectionModel().getSelectedCells().isEmpty()) {
            savesupp.setDisable(true);
            updatesupp.setDisable(false);
            resetsupp.setDisable(false);
            index = tabel.getSelectionModel().getSelectedIndex();
        }
        idsupp.setText(tabel.getSelectionModel().getSelectedItem().getIdsupp());
        namasupp.setText(tabel.getSelectionModel().getSelectedItem().getNamasupp());
        alamat.setText(tabel.getSelectionModel().getSelectedItem().getAlamat());
    }
    public void closetab() {
        setSupplier(suppList);
        idlabelsupp.getScene().getWindow().hide();
    }
}
