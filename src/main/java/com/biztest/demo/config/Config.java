package com.biztest.demo.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;

//跨域访问 未配置
//@Configuration
@PropertySource({"classpath:application.properties"})

public class Config {

   /*@Bean
   public HibernateTemplate druid(){
        return  new HibernateTemplate();
    }*/
   /* @Bean
    public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
        return hemf.getSessionFactory();
    }*/
    @Bean(name="openSession")
    public Session openSession(){
        //StandardServiceRegistryBuilder默认从resource下加载hibernate.cfg.xml
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();

        Session openSession = sessionFactory.openSession();
        return openSession;
    }

}
