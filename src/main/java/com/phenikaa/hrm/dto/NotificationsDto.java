package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.Notifications;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class NotificationsDto implements Serializable {
    @NotNull
    private final String content;
    @NotNull
    private final String title;
    @NotNull
    private final Integer departmentId;

    public Notifications ToEntity(){
        Notifications notifications = new Notifications();
        notifications.setContent(content);
        notifications.setTitle(title);
        return notifications;
    }
}
