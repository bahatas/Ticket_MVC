package com.ticket_mvc.service;


import com.ticket_mvc.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService extends CrudService<UserDTO,String> {



    List<UserDTO> findManagers();
    List<UserDTO> findEmployees();

    //delete
    //create
    //save
    //finById


}
