package com.ticket_mvc.service;


import com.ticket_mvc.dto.RoleDTO;
import com.ticket_mvc.dto.UserDTO;

import java.util.List;

public interface RoleService extends CrudService<RoleDTO,Long> {


    List<UserDTO> findManagers();
    List<UserDTO> findEmployers();
    //RoleDTO
    //Role save
    //Role find
    //Role findById
    //Find All roles
    //Delete roles
    //Roles delete by ID



}
