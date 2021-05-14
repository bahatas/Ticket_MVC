package com.ticket_mvc.service;


import com.ticket_mvc.dto.UserDTO;

import java.util.List;

public interface UserService extends CrudService<UserDTO,String> {

    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();
}
