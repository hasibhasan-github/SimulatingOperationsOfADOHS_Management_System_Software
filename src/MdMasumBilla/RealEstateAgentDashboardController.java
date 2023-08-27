/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdMasumBilla;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Masum
 */
public class RealEstateAgentDashboardController implements Initializable {

    @FXML
    private ComboBox<String> TitleComboBox;
    @FXML
    private ComboBox<String> DescriptionComboBoox;
    @FXML
    private TextField PriceTextField;
    @FXML
    private ComboBox<String> LocationComboBox;
    @FXML
    private TableView<PropertyListing> tableId;
    @FXML
    private TableColumn<PropertyListing, String> PropertyTitle;
    @FXML
    private TableColumn<PropertyListing, String> PropertyDescription;
    @FXML
    private TableColumn<PropertyListing, Double> PropertyPrice;
    @FXML
    private TableColumn<PropertyListing, String> PropertyLocation;

//Construction Planning    
     @FXML
    private DatePicker ConstructionStartDate;

    @FXML
    private DatePicker ConstructionEndDate;

    @FXML
    private TextField ProjectTitleTextBox;

    @FXML
    private TextField ProjectScopeTextBox;

    @FXML
    private TextField ConstructionPlanningBudgetTextBox;
    
    @FXML
    private TableView<ConstructionPlanning> tableId2;
    
    @FXML
    private TableColumn<ConstructionPlanning, String> ProjectTitle;

    @FXML
    private TableColumn<ConstructionPlanning, String> ProjectScope;

    @FXML
    private TableColumn<ConstructionPlanning, LocalDate> ProjectStartDate;

    @FXML
    private TableColumn<ConstructionPlanning, LocalDate> ProjectEndDate;

    @FXML
    private TableColumn<ConstructionPlanning, Double> ProjectBudget;
    
//Project Management
    
    @FXML
    private ListView<String> phaseListView;

    @FXML
    private TextField projectNameTextBox;

    @FXML
    private TextField ProjectManagerTextBox;

    @FXML
    private TextField TeamSizeTextBox;

    @FXML
    private TextField ProjectPhaseTextBox;
    
//Finishing Works

    @FXML
    private TextField workTypeTextField;
    
    @FXML
    private TextField durationTextField;
    
    @FXML
    private TableView<FinishingWorks> WorkDataTableView;

    @FXML
    private TableColumn<FinishingWorks, String> WorkTypeCol;

    @FXML
    private TableColumn<FinishingWorks, Integer> DurationCol;

    @FXML
    private TableColumn<FinishingWorks, String> statusCol;

//PropertyTransaction
    
    @FXML
    private ComboBox<String> propertyTypeComboBox;

    @FXML
    private TextField titleTextField;
    
    @FXML
    private TextField priceTextField;

    @FXML
    private TextField locationTextField;

    @FXML
    private TextArea resultTextArea;
    @FXML
    private ComboBox<String> DescriptionComboBox;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//Property Listing Initialize        
        TitleComboBox.getItems().addAll( "Modern Downtown Apartment with Stunning Views",
                "Charming Family Home in Suburban Oasis",
                "Luxury Waterfront Villa with Private Dock");
        
        DescriptionComboBoox.getItems().addAll("Discover the epitome of urban living in this downtown apartment, boasting modern design and breathtaking city views",
                "A cozy family home located in a peaceful suburban neighborhood, perfect for comfortable living and creating lasting memories.",
                "An exquisite waterfront villa boasting breathtaking views, luxurious amenities, and direct access to a private dock for aquatic adventures");
        
        LocationComboBox.getItems().addAll("100/a","101/b","102/c");
        
        PropertyTitle.setCellValueFactory(new PropertyValueFactory<PropertyListing,String>("Title"));
        PropertyDescription.setCellValueFactory(new PropertyValueFactory<PropertyListing,String>("Description"));
        PropertyPrice.setCellValueFactory(new PropertyValueFactory<PropertyListing, Double>("Price"));
        PropertyLocation.setCellValueFactory(new PropertyValueFactory<PropertyListing,String>("Location"));
        
//Construction Planning Initialize        
        ProjectTitle.setCellValueFactory(new PropertyValueFactory<ConstructionPlanning,String>("projectTitle"));
        ProjectScope.setCellValueFactory(new PropertyValueFactory<ConstructionPlanning,String>("ProjectScope"));
        ProjectStartDate.setCellValueFactory(new PropertyValueFactory<ConstructionPlanning,LocalDate>("StartDate"));
        ProjectEndDate.setCellValueFactory(new PropertyValueFactory<ConstructionPlanning,LocalDate>("EndDate"));
        ProjectBudget.setCellValueFactory(new PropertyValueFactory<ConstructionPlanning, Double>("Budget"));
    
//Finishing Work Initialize
        WorkTypeCol.setCellValueFactory(new PropertyValueFactory<FinishingWorks,String>("WorkType"));
        DurationCol.setCellValueFactory(new PropertyValueFactory<FinishingWorks, Integer>("estimatedDurationInDays"));
        //statusCol.setCellValueFactory(new PropertyValueFactory<FinishingWorks,String>("Status"));
        statusCol.setCellValueFactory(cellData -> {String status = cellData.getValue().isCompleted() ? "Completed" : "Pending";
            return new SimpleStringProperty(status);
        });

//Property Transaction Initialize
        propertyTypeComboBox.getItems().addAll("Apartment","House","Land","Shop");
        
        DescriptionComboBox.getItems().addAll("This modern apartment features spacious rooms and breathtaking city views.",
                "This cozy family home is nestled in a quiet suburb, featuring a spacious backyard and a beautiful garden.",
                "A rare opportunity to own prime commercial land in the heart of the DOHS, offering endless possibilities for development.",
                "A great place to own prime commercial shop in the heart of the DOHS.");
    }     

//Property Listing Button    
    @FXML
    private void AddPropertyOnClick(ActionEvent event) {
        PropertyListing property = new PropertyListing(
                TitleComboBox.getValue(),
        DescriptionComboBoox.getValue(),
                Double.parseDouble(PriceTextField.getText()),
                LocationComboBox.getValue());
        
        ObservableList<PropertyListing>property2=tableId.getItems();
        property2.add(property);
        tableId.setItems(property2);
    }

    @FXML
    private void createBinFileOncCick(ActionEvent event) {
    }
    
    @FXML
    void RemoveSelectedIemOnClick(ActionEvent event) {
        int SelectedId = tableId.getSelectionModel().getSelectedIndex();
        tableId.getItems().remove(SelectedId);
    }
    
//Construction Planning
    @FXML
    void ConstructionPlanningAddProjectOnClick(ActionEvent event) {
        ConstructionPlanning plan = new ConstructionPlanning(
                ProjectTitleTextBox.getText(),
                ProjectScopeTextBox.getText(),
                ConstructionStartDate.getValue(),
                ConstructionEndDate.getValue(),
                Double.parseDouble(ConstructionPlanningBudgetTextBox.getText())
        );
        
        ObservableList<ConstructionPlanning>plan2=tableId2.getItems();
        plan2.add(plan);
        tableId2.setItems(plan2);
    }
    
    @FXML
    void RemoveSelectedItemOnClick2(ActionEvent event) {
        int SelectedId = tableId2.getSelectionModel().getSelectedIndex();
        tableId2.getItems().remove(SelectedId);
    }

    @FXML
    void createBinFileOncCick2(ActionEvent event) {

    }
    
//Project MAnagement
    
    @FXML
    void AddPhaseInListViewOnClick(ActionEvent event) {
        phaseListView.getItems().add(ProjectPhaseTextBox.getText());
    }

    @FXML
    void AddProjectManagementDataOnClick(ActionEvent event) {
        ObservableList<String> selectedPhases = phaseListView.getSelectionModel().getSelectedItems();
    
        ProjectManagement pm = new ProjectManagement(projectNameTextBox.getText(),
                ProjectManagerTextBox.getText(),             
                Integer.parseInt(TeamSizeTextBox.getText()),
                selectedPhases);
        DataReadWrite.writeObjectToFile("ProjectManagementData.bin",pm);
        System.out.println("Done");
    }
    
     @FXML
    void RemovePhaseFromListViewOnClick(ActionEvent event) {
        int selectedItems = phaseListView.getSelectionModel().getSelectedIndex();
        phaseListView.getItems().remove(selectedItems);
    }
    

//Finishing Works
    
    
    @FXML
    public void addFinishingWorkOnClick() {
        FinishingWorks work = new FinishingWorks(
                workTypeTextField.getText(),
                Integer.parseInt(durationTextField.getText()),
                statusCol.getText()
        );
        ObservableList<FinishingWorks>work2=WorkDataTableView.getItems();
        work2.add(work);
        WorkDataTableView.setItems(work2);
    }
    
    @FXML
    public void markWorkAsCompleted() {
        FinishingWorks selectedWork = WorkDataTableView.getSelectionModel().getSelectedItem();
    
        if (selectedWork != null) {
            selectedWork.setCompleted(true);
            WorkDataTableView.refresh(); 
        } else {
            String str = "No work selected";
            GenerateAlerts.unsuccessfulAlert(str);
        }
    }
    
    @FXML
    void WorkDataPdfOnClick(ActionEvent event) {
       ObservableList<FinishingWorks> workData = WorkDataTableView.getItems();
       
       StringBuilder pdfContent = new StringBuilder();
       pdfContent.append("Finishing Works Report:\n\n");
       
       for (FinishingWorks work : workData) {
        pdfContent.append("Work Type: ").append(work.getWorkType()).append("\n");
        pdfContent.append("Duration: ").append(work.getEstimatedDurationInDays()).append(" days\n");
        pdfContent.append("Status: ").append(work.getApplicationStatus()).append("\n");
        pdfContent.append("Completed: ").append(work.isCompleted() ? "Yes" : "No").append("\n\n");
    }

    PdfGenerator.generatePdf(pdfContent.toString());
    }
    

//PropertyTransaction
    
    @FXML
    void addTransactionOnClick(ActionEvent event) {
        PropertyTransaction transaction = new PropertyTransaction(
        propertyTypeComboBox.getValue(),
        titleTextField.getText(),
        DescriptionComboBox.getValue(),
        Double.parseDouble(priceTextField.getText()),
        locationTextField.getText());
        
        resultTextArea.appendText(transaction.toString());
        DataReadWrite.overWriteObjectToFile("addTransaction.bin", transaction);
    }
    
    @FXML
    void downloadPdfOnClick(ActionEvent event) {
        String textToConvert = resultTextArea.getText();

        if (!textToConvert.isEmpty()) {
            PdfGenerator.generatePdf(textToConvert);
        } else {
            GenerateAlerts.unsuccessfulAlert("Text area is empty. Cannot generate PDF.");
        }
    }
    
    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        // Creating new Scene and Loading the Stage
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // Generating Confirmation Alert. If confirmation is true Log out & go to dashboard. 
        if (GenerateAlerts.confirmationAlert()) newwscene.logOutSceneSwitching(stage);
        
    }
}