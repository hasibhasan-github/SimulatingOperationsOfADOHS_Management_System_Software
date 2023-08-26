/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbdullahAlMamun;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class VisitorPurposeCount implements Serializable{
    String pupose;
    int visitCount;

    public VisitorPurposeCount(String pupose, int visitCount) {
        this.pupose = pupose;
        this.visitCount = visitCount;
    }

    public String getPupose() {
        return pupose;
    }

    public int getVisitCount() {
        return visitCount;
    }

    public void setPupose(String pupose) {
        this.pupose = pupose;
    }

    public void setVisitCount(int visitCount) {
        this.visitCount = visitCount;
    }

    @Override
    public String toString() {
        return "VisitorPurposeCoun:" + "pupose=" + pupose + ", visitCount=" + visitCount + '\n';
    }
    
    
    
}
