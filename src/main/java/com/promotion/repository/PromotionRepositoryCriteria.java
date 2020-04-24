package com.promotion.repository;

import java.util.List;

import com.promotion.model.PromotionCriteria;
import com.promotion.model.PromotionModel;

@FunctionalInterface
public interface PromotionRepositoryCriteria {

	public List<PromotionModel> findByCriteria(PromotionCriteria criteria) throws Exception;
}
