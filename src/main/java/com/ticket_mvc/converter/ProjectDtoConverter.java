package com.ticket_mvc.converter;


import com.ticket_mvc.dto.ProjectDTO;
import com.ticket_mvc.dto.UserDTO;
import com.ticket_mvc.service.ProjectService;
import com.ticket_mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {


    @Autowired
    ProjectService projectService;

    @Override
    public ProjectDTO convert(String source) {
        return projectService.findById(source)   ;
    }


}
