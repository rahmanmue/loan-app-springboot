package com.enigmacamp.loanapp.controller;

import com.enigmacamp.loanapp.model.entity.InstalmentType;
import com.enigmacamp.loanapp.model.request.InstalmentTypeRequest;
import com.enigmacamp.loanapp.model.response.CommonResponse;
import com.enigmacamp.loanapp.service.InstalmentTypeService;
import com.enigmacamp.loanapp.utils.constant.ApiPathConstant;
import com.enigmacamp.loanapp.utils.constant.EInstalmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(ApiPathConstant.API + ApiPathConstant.INSTALMENT_TYPE)
public class InstalmentTypeController {
    @Autowired
    InstalmentTypeService instalmentTypeService;
    @PostMapping
    @PreAuthorize("hasAnyRole({'ROLE_STAFF','ROLE_ADMIN'})")
    public ResponseEntity<CommonResponse> saveInstalmentType(@RequestBody InstalmentType instalmentType){
        InstalmentType instalmentType1 = instalmentTypeService.saveInstalmentType(instalmentType);
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success Insert instalment type");
        commonResponse.setData(instalmentType1);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(commonResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse<Optional<InstalmentType>>> getInstalmentTypeById(@PathVariable String id){
        Optional<InstalmentType> optionalInstalmentType = instalmentTypeService.getInstalmentTypeById(id);
        CommonResponse<Optional<InstalmentType>> commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success get instalment type by id");
        commonResponse.setData(optionalInstalmentType);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @GetMapping
    public ResponseEntity<CommonResponse<List<InstalmentType>>> getAllInstalmentTypes(){
        List<InstalmentType> instalmentTypeList = instalmentTypeService.getAllInstalmentTypes();
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success get all instalment type by");
        commonResponse.setData(instalmentTypeList);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @PutMapping
    @PreAuthorize("hasAnyRole({'ROLE_ADMIN', 'ROLE_STAFF'})")
    public  ResponseEntity<CommonResponse<InstalmentType>> updateInstalmentTypeById(@RequestBody InstalmentType instalmentType){
        InstalmentType instalmentType1 = instalmentTypeService.updateInstalmentType(instalmentType);
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setMessage("Success update instalment type by id");
        commonResponse.setData(instalmentType1);
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> deleteInstalmentType(@PathVariable String id){
        CommonResponse commonResponse = new CommonResponse<>();
        instalmentTypeService.deleteInstalmentType(id);
        commonResponse.setMessage("Data Deleted");
        return ResponseEntity.status(HttpStatus.OK)
                .body(commonResponse);

    }

}
