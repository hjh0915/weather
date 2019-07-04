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

    final static String ALL_PROVINCE_NATIVE_QUERY =
        "select id, name from province";

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

    @Override
    public Province findById(Long id) {
        TypedQuery<Province> query = em.createNamedQuery(Province.FIND_PROVINCE_BY_ID, Province.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public List<Province> findAllWithCity() {
        List<Province> provinces = em.createNamedQuery(Province.FIND_ALL_WITH_CITY, Province.class).getResultList();
        return provinces;
    }

    @Override
    public List<Province> findAll() {
        List<Province> provinces = em.createNamedQuery(Province.FIND_ALL, Province.class).getResultList();
        return provinces;
    }

    @Transactional(readOnly=true)
    @Override
    public List<Province> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_PROVINCE_NATIVE_QUERY, "provinceResult").getResultList();
    }    
}