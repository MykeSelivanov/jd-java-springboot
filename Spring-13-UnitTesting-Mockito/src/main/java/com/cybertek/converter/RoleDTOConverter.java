package com.cybertek.converter;

import com.cybertek.dto.RoleDTO;
import com.cybertek.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class RoleDTOConverter implements Converter<String,RoleDTO> {

    RoleService roleService;

    @Autowired
    public RoleDTOConverter(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public RoleDTO convert(String source) {

        Long id = Long.parseLong(source);
        return roleService.findById(id);
    }

}
