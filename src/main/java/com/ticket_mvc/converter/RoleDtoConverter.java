package com.ticket_mvc.converter;

import com.ticket_mvc.dto.RoleDTO;
import com.ticket_mvc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDtoConverter implements Converter<String,RoleDTO> {

    @Autowired
    RoleService roleService;


    @Override
    public RoleDTO convert(String source ) {

        Long id = Long.parseLong(source);

        RoleDTO roleDto = new RoleDTO();

        roleDto=roleService.findById(id);

        return roleDto;

    }
}
