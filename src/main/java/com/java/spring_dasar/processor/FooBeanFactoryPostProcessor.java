package com.java.spring_dasar.processor;

import com.java.spring_dasar.data.Foo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class FooBeanFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinitionRegistryPostProcessor.super.postProcessBeanFactory(beanFactory);
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {

        // membuat definisi bean secara manual di Spring,
        GenericBeanDefinition definition = new GenericBeanDefinition();
        // melakukan set beannya
        definition.setBeanClass(Foo.class);
        definition.setScope("singleton");

        // untuk mendaftarkan atau meregister beannnya
        registry.registerBeanDefinition("foo", definition);

    }
}
