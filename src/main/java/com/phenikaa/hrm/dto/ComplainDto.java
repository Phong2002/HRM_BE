package com.phenikaa.hrm.dto;

import com.phenikaa.hrm.entity.Complain;
import lombok.Data;

import java.io.Serializable;

@Data
public class ComplainDto implements Serializable {
    private final String content;
    private final int userId;

    public Complain ToEntity(){
        Complain complain = new Complain();
        complain.setContent(content);
        return complain;
    }
}
