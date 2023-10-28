package com.demo.contacts.Crud;

import com.demo.contacts.Handled.HandledErrorDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public abstract class ServiceBase<Entity, Dto> {
    @Autowired
    protected JpaRepository<Entity, Long> repository;

    public Dto getById(Long id) throws Exception {

        try {
            Entity entity = repository.findById(id).orElse(null);

            if (entity == null) {
                return null;
            }

            return mapToDTO(entity);
        } catch (Exception e) {
            throw new Exception(HandledErrorDataBase.GET_ERROR.getMessage(), e);
        }

    }

    public Dto create(Dto dto) throws Exception {

        try {
            Entity entity = mapToEntity(dto);
            entity = repository.save(entity);
            return mapToDTO(entity);
        } catch (Exception e) {
            throw new Exception(HandledErrorDataBase.SAVE_ERROR.getMessage(), e);
        }

    }

    public Dto update(Long id, Dto dto) throws Exception {

        try {
            Entity existingEntity = repository.findById(id).orElse(null);

            if (existingEntity == null) {
                return null;
            } else {
                existingEntity = repository.save(existingEntity);
                return mapToDTO(existingEntity);
            }

        } catch (Exception e) {
            throw new Exception(HandledErrorDataBase.UPDATE_ERROR.getMessage(), e);
        }

    }

    public void delete(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(HandledErrorDataBase.DELETE_ERROR.getMessage(), e);
        }
    }

    protected abstract Dto mapToDTO(Entity entity);

    protected abstract Entity mapToEntity(Dto dto);

}
