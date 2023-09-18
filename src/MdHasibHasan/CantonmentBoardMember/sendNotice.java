/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Hasib
 */

public class sendNotice implements Serializable {
    private String noticeName, noticeSubject, noticeForPeopleType;
    private LocalDate noticeDate;
    private ArrayList<String> noticeDescription;

    public sendNotice(String noticeName, String noticeSubject, String noticeForPeopleType, LocalDate noticeDate, ArrayList<String> noticeDescription) {
        this.noticeName = noticeName;
        this.noticeSubject = noticeSubject;
        this.noticeForPeopleType = noticeForPeopleType;
        this.noticeDate = noticeDate;
        this.noticeDescription = noticeDescription;
    }

    public String getNoticeName() {
        return noticeName;
    }

    public String getNoticeSubject() {
        return noticeSubject;
    }

    public String getNoticeForPeopleType() {
        return noticeForPeopleType;
    }

    public LocalDate getNoticeDate() {
        return noticeDate;
    }

    public ArrayList<String> getNoticeDescription() {
        return noticeDescription;
    }
    
    
}
