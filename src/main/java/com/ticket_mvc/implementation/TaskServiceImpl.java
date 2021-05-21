package com.ticket_mvc.implementation;

import com.ticket_mvc.dto.TaskDTO;
import com.ticket_mvc.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO,Long> implements TaskService {


    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findbyId(id);
    }

    @Override
    public void delete(TaskDTO taskDTO) {

        super.delete(taskDTO);
    }

    @Override
    public void deleteById(Long id) {

        super.deleteById(id);
    }

    @Override
    public TaskDTO save(TaskDTO taskDTO) {
       return super.save(taskDTO.getId(),taskDTO);
    }

    @Override
    public void update(TaskDTO taskDTO) {

        super.update(taskDTO.getId(),taskDTO);
    }
}
