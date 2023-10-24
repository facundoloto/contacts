package com.demo.contacts.Crud;

import org.hibernate.exception.DataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import com.demo.contacts.Handled.HandledErrorDataBase;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public abstract class ServiceBase<Entity, Dto> {
    @Autowired
    protected JpaRepository<Entity, Long> repository;

    public Dto getById(Long id) {
        try {
            Entity entity = repository.findById(id).orElse(null);
            if (entity == null) {
                return null;
            }
            return mapToDTO(entity);
        } catch (Exception e) {
            throw new DataException(HandledErrorDataBase.GET_ERROR.getMessage(), (SQLException) e);
        }
    }

    public Dto create(Dto dto) {
        try {
            Entity entity = mapToEntity(dto);
            entity = repository.save(entity);
            return mapToDTO(entity);
        } catch (Exception e) {
            throw new DataException(HandledErrorDataBase.SAVE_ERROR.getMessage(), (SQLException) e);
        }
    }

    public Dto update(Long id, Dto dto) {
        try {
            Entity existingEntity = repository.findById(id).orElse(null);
            if (existingEntity == null) {
                return null;

            } else {
                existingEntity = repository.save(existingEntity);

                return mapToDTO(existingEntity);
            }
        } catch (Exception e) {
            throw new DataException(HandledErrorDataBase.UPDATE_ERROR.getMessage(), (SQLException) e);
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new DataException(HandledErrorDataBase.DELETE_ERROR.getMessage(), (SQLException) e);
        }

    }

    protected abstract Dto mapToDTO(Entity entity);

    protected abstract Entity mapToEntity(Dto dto);

}
