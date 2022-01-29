package com.bank.MCC.controller;

import com.bank.MCC.config.ResponseEnum;
import com.bank.MCC.config.ResponsePayload;
import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.services.MetaService;
import com.bank.MCC.services.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/data")
public class DataAccessController {

    @Autowired
    MetaService metaService;

    @PostMapping(value = "/create-meta",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload create(@RequestBody MetaModel metaModel) {

        try {
            MetaEntity insertedEntity = metaService.create(metaModel);
            if (insertedEntity != null) {
                return new ResponsePayload(ResponseEnum.OK, insertedEntity, "Create " +
                        insertedEntity.getNameOfApplication() + " is success");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Create is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }
}
