package com.bank.MCC.controller;

import com.bank.MCC.config.ResponseEnum;
import com.bank.MCC.config.ResponsePayload;
import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.services.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/data")
public class DataAccessController {

    @Autowired
    MetaService metaService;

    @PostMapping(value = "/meta",
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

    @GetMapping(value = "/bath-all-paging",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload listWithPaging(@RequestParam String nameOfApplication ,
                                          @RequestParam String ownerOfApplication,
                                          @RequestParam String configManagerOfApplication ,
                                          @RequestParam Pageable page) {

        try {
            Page<MetaEntity> models = metaService.pagingMetas(nameOfApplication, ownerOfApplication, configManagerOfApplication, page);
            if (models != null)
                return new ResponsePayload(ResponseEnum.OK, models, "List data is success");
            else
                return new ResponsePayload(ResponseEnum.NOTFOUND, "List is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }
}
