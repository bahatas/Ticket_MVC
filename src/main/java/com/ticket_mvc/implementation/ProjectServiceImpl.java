package com.ticket_mvc.implementation;

import com.ticket_mvc.dto.ProjectDTO;
import com.ticket_mvc.service.ProjectService;
import com.ticket_mvc.utils.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {  // project code burda uniq i=olan aslinda

        super.deleteById(projectCode);
    }

    @Override
    public void delete(ProjectDTO projectDTO) {

        super.delete(projectDTO);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findbyId(projectCode);
    }

    @Override
    public ProjectDTO save(ProjectDTO projectDTO) {
        return super.save(projectDTO.getProjectCode(),projectDTO);
    }

    @Override
    public void update(ProjectDTO projectDTO) {
        super.update(projectDTO.getProjectCode(),projectDTO);
    }


    @Override
    public void complete(ProjectDTO projectDTO) {
        super.findbyId(projectDTO.getProjectCode()).setProjectStatus(Status.COMPLETE);
        super.save(projectDTO.getProjectCode(),projectDTO);
    }
}
