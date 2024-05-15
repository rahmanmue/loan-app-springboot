package com.enigmacamp.loanapp.service;

import com.enigmacamp.loanapp.model.entity.InstalmentType;
import com.enigmacamp.loanapp.utils.constant.EInstalmentType;

import java.util.List;
import java.util.Optional;

public interface InstalmentTypeService {

    InstalmentType saveInstalmentType(InstalmentType instalmentType);
    InstalmentType updateInstalmentType(InstalmentType instalmentType);
    List<InstalmentType> getAllInstalmentTypes();
    Optional<InstalmentType> getInstalmentTypeById(String id);
    void deleteInstalmentType(String id);



}
