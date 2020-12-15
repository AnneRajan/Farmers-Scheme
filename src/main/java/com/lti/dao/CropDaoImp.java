package com.lti.dao;

import java.util.List;

import com.lti.model.Crop;
import com.lti.model.SoldHistory;

public interface CropDaoImp {
	
	Crop placesellrequest(Crop c);
	
	List<Crop> getcrop();
	
	List<SoldHistory> gethistory();
}
