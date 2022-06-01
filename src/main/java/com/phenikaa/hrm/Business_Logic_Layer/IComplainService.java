package com.phenikaa.hrm.Business_Logic_Layer;

import com.phenikaa.hrm.dto.ComplainDto;
import com.phenikaa.hrm.entity.Complain;

import java.util.List;

public interface IComplainService {
    List<Complain> GetAllComplain();
    void CreateComplain(ComplainDto dto);
    List<Complain> GetComplainByUserId(int id);
}
