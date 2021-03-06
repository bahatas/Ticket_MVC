package com.ticket_mvc.implementation;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;
import com.ticket_mvc.dto.UserDTO;
import com.ticket_mvc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO,String> implements UserService {
    @Override
    public List<UserDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {

        super.deleteById(id);
    }

    @Override
    public void delete(UserDTO userDTO) {

        super.delete(userDTO);

    }

    @Override
    public UserDTO findById(String id) {
        return super.findbyId(id);
    }

    @Override
    public UserDTO save(UserDTO object) {
        return super.save(object.getUserName(),object);
    }

    @Override
    public void update(UserDTO object) {

        super.update(object.getUserName(),object);
    }

    @Override
    public List<UserDTO> findManagers() {
        return super.findAll().stream().filter(user -> user.getRole().getId() == 2).collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findEmployees() {
        return super.findAll().stream().filter(user -> user.getRole().getId() == 3).collect(Collectors.toList());
    }


}
