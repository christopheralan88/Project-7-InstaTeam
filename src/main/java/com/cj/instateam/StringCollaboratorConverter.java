package com.cj.instateam;

import com.cj.instateam.dao.CollaboratorDao;
import com.cj.instateam.model.Collaborator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
@Configuration
public class StringCollaboratorConverter implements Converter<String, Collaborator> {

    @Autowired
    private CollaboratorDao collaboratorDao;

    @Override
    public Collaborator convert(String source) {
        // you can change the way , add
        // exception check and etc.
        return collaboratorDao.findById(Integer.parseInt(source));
    }

    @Bean
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(new StringCollaboratorConverter());
        bean.setConverters(converters);
        return bean.getObject();
    }
}