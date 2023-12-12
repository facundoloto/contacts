package com.demo.contacts.Crud;

import com.demo.contacts.Handled.HandledErrorDataBase;
import com.demo.contacts.User.Domain.Dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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

    public boolean delete(Long id) throws Exception {
        try {
            // Check if the item exists before attempting to delete
            if (!repository.existsById(id)) {
                return false;
            }

            repository.deleteById(id);
            return true; // 204 No Content
        } catch (Exception e) {
            throw new Exception(HandledErrorDataBase.DELETE_ERROR.getMessage(), e);
        }
    }

    /**
     * @param id
     * @param dto
     * @return
     * @throws Exception
     * @Description I did this method abstract because each component update data of different ways
     */
    public Dto update(Long id, Dto dto) throws Exception {
        return null;
    }

    protected abstract Dto mapToDTO(Entity entity);

    protected abstract Entity mapToEntity(Dto dto);

}