/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.CantonmentBoardMember.crucialTaskPermissionRequest;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.Employee;
import MdHasibHasan.GenerateAlerts;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

/**
 *
 * @author user
 */
public class SecurityCheif extends Employee implements Serializable{

    public SecurityCheif(LocalDate dateOoJoin, float salary, String department, String designation, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(dateOoJoin, salary, department, designation, id, name, gender, email, userType, deathOfBirth, contactNo);
    }

    @Override
    protected void applyForLeave() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    public static ObservableList<VisitorRequest> gantAccessPermission(ObservableList<VisitorRequest> visitorRequestData, VisitorRequest instance){
          for ( int i = 0; i <  visitorRequestData.size(); ++i ){
            // Updating the Application Status
            if (visitorRequestData.get(i).getPhoneNo().equals(instance.getPhoneNo())) visitorRequestData.get(i).setApplicationStatus("Approved");
            // Writing updated data on the File.
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("VisitorRequest.bin", visitorRequestData.get(i));
            else DataReadWrite.writeObjectToFile("VisitorRequest.bin", visitorRequestData.get(i));
        }
        return visitorRequestData; 
        
        
        
    }
    
    public static ObservableList<PieChart.Data> purposeOfVisitCountPiChart(){
        ObservableList<PieChart.Data> tempList = FXCollections.observableArrayList();
        ObservableList<VisitorRequest> visitReqList;
        int[] purposeCount = new int[7];
        VisitorRequest visitReq = new VisitorRequest("","","","","");
        visitReqList = (ObservableList<VisitorRequest>) DataReadWrite.readObjectToFile("VisitorRequest.bin", visitReq);
        
        for(VisitorRequest x : visitReqList){
            String purpose = x.getPurposeOfVisit();
            
            if("Guest of Resident".equals(purpose)){
                purposeCount[0]++;
            }
            else if("Delivery/Pickup".equals(purpose)){
                 purposeCount[1]++;
            }
            else if("Meeting with resident".equals(purpose)){
                 purposeCount[2]++;
            }
            else if("Official Business".equals(purpose)){
                 purposeCount[3]++;
            }
            else if("Social Gathering/Event Participation".equals(purpose)){
                 purposeCount[4]++;
            }
            else if("Contractor/Service Provider".equals(purpose)){
                 purposeCount[5]++;
            }
            else if("Vendor/Supplier".equals(purpose)){
                 purposeCount[6]++;
            }
            
            System.out.println(purposeCount);
            
            
            
        }
        String[] purposes = {"Guest of Resident","Delivery/Pickup","Meeting with resident","Official Business",
            "Social Gathering/Event Participation","Contractor/Service Provider","Vendor/Supplier"};
        
        for(int i=0; i<7; i++){
            if(purposeCount[i]!=0){
                tempList.add(new PieChart.Data(purposes[i], purposeCount[i]));
            }
        }
        
        return tempList;
        
    }
    
    
    
    public static int[] visitorsTimeSlotCountBarChart(){
        ObservableList<VisitorRequest> visitReqList;
        int[] timeSlotCount = new int[7];
        
        VisitorRequest visitReq = new VisitorRequest("","","","","");
        visitReqList = (ObservableList<VisitorRequest>) DataReadWrite.readObjectToFile("VisitorRequest.bin", visitReq);
        
         for(VisitorRequest x : visitReqList){
            String timeSlot = x.getTimeSlot();
            
            if("8.00-10.00 am".equals(timeSlot)){
                timeSlotCount[0]++;
            }
            else if("10.00-12.00 am".equals(timeSlot)){
                 timeSlotCount[1]++;
            }
            else if("12.00-2.00 pm".equals(timeSlot)){
                 timeSlotCount[2]++;
            }
            else if("2.00-4.00 pm".equals(timeSlot)){
                 timeSlotCount[3]++;
            }
            else if("4.00-6.00 pm".equals(timeSlot)){
                timeSlotCount[4]++;
            }
            else if("6.00-8.00 pm".equals(timeSlot)){
                 timeSlotCount[5]++;
            }
            else if("8.00-10.00 pm".equals(timeSlot)){
                 timeSlotCount[6]++;
            }
            
            System.out.println("Worked");
            
            
            
        }
   
         
         return timeSlotCount;
        
        
    }
    
    public static void requestPermissionForCrucialTask(crucialTaskPermissionRequest newReq){
        DataReadWrite.writeObjectToFile("CrucialTaskPermissionRequest.bin", newReq);
        GenerateAlerts.successfulAlert("Your request has been sended.\n Please Have Patience!");
    }
    
    
    public static void sentAnnouncementToResident(Announcement ann){
        DataReadWrite.writeObjectToFile("Announcements.bin", ann);
        GenerateAlerts.successfulAlert("Your Announce has been sended");
        
    }
    
    
}
