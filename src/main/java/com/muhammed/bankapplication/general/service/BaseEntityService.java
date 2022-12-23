package com.muhammed.bankapplication.general.service;

import com.muhammed.bankapplication.customer.dao.CustomerDao;
import com.muhammed.bankapplication.general.entity.BaseAdditionalFields;
import com.muhammed.bankapplication.general.entity.BaseEntity;
import com.muhammed.bankapplication.general.enums.GenericErrorMessage;
import com.muhammed.bankapplication.general.exceptions.ItemNotFoundExeption;
import com.muhammed.bankapplication.sec.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class  BaseEntityService <E extends BaseEntity,D extends JpaRepository<E,Long>>{

    private AuthenticationService authenticationService;
    private final D dao;

    protected D getDao(){
        return dao;
    }

    public Long getCurrentCustomerId(){
        return authenticationService.getCurrentCustomerId();
    }

    public List<E> findAll(){
        return dao.findAll();
    }

    public E findByIdWithControl(Long id){
         E e=dao.findById(id).orElseThrow(()->new ItemNotFoundExeption(GenericErrorMessage.ITEM_NOT_FOUND));

        return e;
    }

    public Optional<E> findById(Long id){

        return dao.findById(id);
    }

    public E save(E e){
        e=dao.save(e);

        BaseAdditionalFields baseAdditionalFields= e.getBaseAdditionalFields();
        if(baseAdditionalFields==null){
            baseAdditionalFields=new BaseAdditionalFields();
            e.setBaseAdditionalFields(baseAdditionalFields);
        }

        if(e.getId()==null){

            baseAdditionalFields.setCreatedBy(e.getId());
            baseAdditionalFields.setCreatedDate(LocalDateTime.now());
            baseAdditionalFields.setUptatedBy(e.getId());
            baseAdditionalFields.setUptatedDate(LocalDateTime.now());
        }

        return e;
    }

    public void delete(Long id){

        dao.deleteById(id);
    }






}
