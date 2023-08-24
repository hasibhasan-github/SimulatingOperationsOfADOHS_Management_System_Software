/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */
public class loadResidentData implements Serializable {
    private String name, plotNo, gender, holdingNo;
    private int id;

    public loadResidentData(String name, String plotNo, String gender, String holdingNo, int id) {
        this.name = name;
        this.plotNo = plotNo;
        this.gender = gender;
        this.holdingNo = holdingNo;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlotNo() {
        return plotNo;
    }

    public void setPlotNo(String plotNo) {
        this.plotNo = plotNo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHoldingNo() {
        return holdingNo;
    }

    public void setHoldingNo(String holdingNo) {
        this.holdingNo = holdingNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("loadResidentData{");
        sb.append("name=").append(name);
        sb.append(", plotNo=").append(plotNo);
        sb.append(", gender=").append(gender);
        sb.append(", holdingNo=").append(holdingNo);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    
}
