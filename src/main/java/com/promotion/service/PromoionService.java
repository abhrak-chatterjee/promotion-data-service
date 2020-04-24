package com.promotion.service;

import java.util.List;

import com.promotion.dto.PromotionDTO;
import com.promotion.model.PromotionCriteria;
import com.promotion.model.PromotionModel;

public interface PromoionService {

	public PromotionModel savePromotionData(PromotionDTO promotionDTO) throws Exception;
	public List<PromotionModel> getPromotionDataByCriteria(PromotionCriteria criteria) throws Exception;
}
