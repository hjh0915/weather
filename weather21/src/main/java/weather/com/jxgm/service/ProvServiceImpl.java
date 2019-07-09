package com.jxgm.service;

import com.jxgm.entities.Province;

import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

@Service("jpaProvinceService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class ProvServiceImpl implements ProvService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Province save(Province province) {
        if (province.getId() == null) {
            em.persist(province);
        } else {
            em.merge(province);
        }
        return province;
    }
}