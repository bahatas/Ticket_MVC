package com.ticket_mvc.implementation;

import com.ticket_mvc.dto.RoleDTO;
import com.ticket_mvc.dto.UserDTO;
import com.ticket_mvc.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractMapService<RoleDTO,Long> implements RoleService {

    @Override
    public List<RoleDTO> findAll() {
        return super.findAll();
    }

    @Override
    public RoleDTO findById(Long aLong) {
        return null;
    }

    @Override
    public RoleDTO save(RoleDTO object) {
        return super.save(object.getId(),object);
    }

    @Override
    public void update(RoleDTO object) {
        super.update(object.getId(),object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(RoleDTO object) {
        super.delete(object);
    }



}
