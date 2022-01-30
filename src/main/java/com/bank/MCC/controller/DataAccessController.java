package com.bank.MCC.controller;

import com.bank.MCC.config.ResponseEnum;
import com.bank.MCC.config.ResponsePayload;
import com.bank.MCC.config.ValidationMessage;
import com.bank.MCC.dto.MetaModel;
import com.bank.MCC.dto.TechnicalModel;
import com.bank.MCC.entities.MetaEntity;
import com.bank.MCC.entities.MetaOldEntity;
import com.bank.MCC.entities.TechnicalEntity;
import com.bank.MCC.entities.TechnicalOldEntity;
import com.bank.MCC.services.MetaService;
import com.bank.MCC.services.TechnicalService;
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

    @Autowired
    TechnicalService technicalService;

    @PostMapping(value = "/meta",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload create(@RequestBody MetaModel metaModel) {

        try {

            ValidationMessage message = metaService.checkExist(metaModel.getNameOfApplication());
            if (!message.isValid()) {
                return new ResponsePayload(ResponseEnum.BADREQUEST, message.getMessage());
            }

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

    @PutMapping(value = "/meta",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload update(@RequestBody MetaModel metaModel) {

        try {
            MetaEntity insertedEntity = metaService.update(metaModel);
            if (insertedEntity != null) {
                return new ResponsePayload(ResponseEnum.OK, insertedEntity, "Update " +
                        insertedEntity.getNameOfApplication() + " is success");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Update is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }

    @GetMapping(value = "/bath-all-metas-paging",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload pageMetas(@RequestParam String nameOfApplication ,
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

    @GetMapping(value = "/bath-all-old-metas-paging",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload pageOldMetas(  @RequestParam Integer id,
                                          @RequestParam String nameOfApplication ,
                                          @RequestParam String ownerOfApplication,
                                          @RequestParam String configManagerOfApplication ,
                                          @RequestParam Pageable page) {

        try {
            Page<MetaOldEntity> models = metaService.pagingOldMetas(id, nameOfApplication, ownerOfApplication,
                    configManagerOfApplication, page);
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

    @PostMapping(value = "/technical",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload createTech(@RequestBody TechnicalModel technicalModel) {

        try {

            ValidationMessage message = technicalService.checkExist(technicalModel.getRoles());
            if (!message.isValid()) {
                return new ResponsePayload(ResponseEnum.BADREQUEST, message.getMessage());
            }

            TechnicalEntity insertedEntity = technicalService.create(technicalModel);
            if (insertedEntity != null) {
                return new ResponsePayload(ResponseEnum.OK, insertedEntity, "Create " +
                        insertedEntity.getRoles() + " is success");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Create is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }

    @PutMapping(value = "/technical",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload updateTech(@RequestBody TechnicalModel technicalModel) {

        try {
            TechnicalEntity insertedEntity = technicalService.update(technicalModel);
            if (insertedEntity != null) {
                return new ResponsePayload(ResponseEnum.OK, insertedEntity, "Update " +
                        insertedEntity.getRoles() + " is success");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Update is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }

    @GetMapping(value = "/bath-all-technical-paging",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload pageMetas(@RequestParam String role ,
                                     @RequestParam String permission,
                                     @RequestParam Pageable page) {

        try {
            Page<TechnicalEntity> models = technicalService.pagingMetas(role, permission, page);
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

    @GetMapping(value = "/bath-all-old-technical-paging",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload pageOldMetas(  @RequestParam Integer id,
                                          @RequestParam String role ,
                                          @RequestParam String permission,
                                          @RequestParam Pageable page) {

        try {
            Page<TechnicalOldEntity> models = technicalService.pagingOldMetas(id, role, permission, page);
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

    @PostMapping(value = "/meta-technical",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponsePayload createBothOfThem(@RequestBody MetaModel metaModel,
                                            @RequestBody TechnicalModel technicalModel) {

        try {
            MetaEntity insertedEntity = metaService.create(metaModel);
            TechnicalEntity insertedEntity2 = technicalService.update(technicalModel);
            if (insertedEntity != null && insertedEntity2 != null) {
                return new ResponsePayload(ResponseEnum.OK, insertedEntity, "Create " +
                        insertedEntity.getNameOfApplication() + " is success with Technical Data");
            }
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Create is unsuccessfully");
        } catch (DataIntegrityViolationException ex) {
            return new ResponsePayload(ResponseEnum.NOTFOUND, "Duplicate Key");
        } catch (Exception ex) {
            return new ResponsePayload(ResponseEnum.INTERNAL_ERROR);
        }
    }
}
