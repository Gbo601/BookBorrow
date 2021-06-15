package com.Gbo601.GUI.Controller;

import com.Gbo601.Model.Announcement;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * @author Gbo601
 * @create 2021-05-22 18:45
 */
public class AnnouncementController {

    @FXML
    private Label lblAnnouncementTime;

    @FXML
    private TextFlow lblAnnouncementText;
    private Announcement announcement;

    void setData(Announcement announcement){
        this.announcement=announcement;
        lblAnnouncementTime.setText(announcement.getDate().toString());
        Text text=new Text(announcement.getAnnouncement());
        lblAnnouncementText.getChildren().addAll(text);
    }
}
