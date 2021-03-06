package com.manager.CampChildreanHolydayManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.CampChildreanHolydayManager.Entites.Economiste;
import com.manager.CampChildreanHolydayManager.dao.EconomisteRepository;
@Service
@Transactional
public class EconomisteService {
    @Autowired
    private EconomisteRepository Erepo;
     
    public List<Economiste> findAll() {
        return Erepo.findAll();
    }
     
    public void save(Economiste Economiste) {
        Erepo.save(Economiste);
    }
     
    public Economiste get(long id) {
        return Erepo.findById(id).get();
    }
     
    public void deleteById(long id) {
        Erepo.deleteById(id);
    }
	
	
    public List<Economiste>search(String keyword){
    	return Erepo.search(keyword);
    }
}
