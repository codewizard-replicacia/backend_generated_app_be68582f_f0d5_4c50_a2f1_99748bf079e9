package com.mycompany.group234.repository;


import com.mycompany.group234.model.Settings;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.List;


@Component
public class SettingsRepository extends SimpleJpaRepository<Settings, String> {
    private final EntityManager em;
    public SettingsRepository(EntityManager em) {
        super(Settings.class, em);
        this.em = em;
    }
    @Override
    public List<Settings> findAll() {
        return em.createNativeQuery("Select * from \"generated_app\".\"Settings\"", Settings.class).getResultList();
    }
}