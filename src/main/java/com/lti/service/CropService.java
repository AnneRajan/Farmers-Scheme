package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.CropDaoClass;
import com.lti.model.Crop;
import com.lti.model.FarmerRegisteration;
import com.lti.model.SoldHistory;

@Service
@Transactional
public class CropService {
	@Autowired
	CropDaoClass cropdao;
	
	public Crop placesellrequest(Crop c) {
		return cropdao.placesellrequest(c);
	}	
	
	public List<Crop> getcrop(){
		return cropdao.getcrop();
	}
	
	public List<SoldHistory> gethistory(){
		return cropdao.gethistory();
	}
}
