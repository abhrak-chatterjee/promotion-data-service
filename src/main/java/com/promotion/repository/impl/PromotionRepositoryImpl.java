package com.promotion.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.promotion.constants.Constants;
import com.promotion.model.PromotionCriteria;
import com.promotion.model.PromotionModel;
import com.promotion.repository.PromotionRepositoryCriteria;

import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
public class PromotionRepositoryImpl implements PromotionRepositoryCriteria {

	@Autowired
	private MongoTemplate repository;

	@Override
	public List<PromotionModel> findByCriteria(PromotionCriteria criteria) throws Exception {
		List<PromotionModel> list = null;
		try {
			list = repository.find(getWhereClause(criteria), PromotionModel.class);
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * Method used for Preparing the Where Clause
	 * 
	 * @param criteria
	 * @param builder
	 * @param model
	 * @return
	 */
	private Query getWhereClause(PromotionCriteria criteria) {
		Query whereClause = new Query();
		if (!StringUtils.isEmpty(criteria.getPromotionId())) {
			whereClause.addCriteria(Criteria.where(Constants.PROMOTION_ID).is(criteria.getPromotionId()));
		}
		if (!StringUtils.isEmpty(criteria.getBankName())) {
			whereClause.addCriteria(Criteria.where(Constants.BANK_NAME).is(criteria.getBankName()));
		}
		if (!StringUtils.isEmpty(criteria.getCardType())) {
			whereClause.addCriteria(Criteria.where(Constants.CARD_TYPE).is(criteria.getCardType()));
		}
		if (!StringUtils.isEmpty(criteria.getMinimumAmountForPromotion())) {
			whereClause.addCriteria(Criteria.where(Constants.MIN_AMOUNT_FOR_PROMOTION).is(criteria.getMinimumAmountForPromotion()));
		}
		if (!StringUtils.isEmpty(criteria.getBenefitType())) {
			whereClause.addCriteria(Criteria.where(Constants.BENEFIT_TYPE).is(criteria.getBenefitType()));
		}
		if (!StringUtils.isEmpty(criteria.getBenefitAmount())) {
			whereClause.addCriteria(Criteria.where(Constants.MAX_BENEFIT_AMOUNT).is(criteria.getBenefitAmount()));
		}
		if (!StringUtils.isEmpty(criteria.getFlightId())) {
			whereClause.addCriteria(Criteria.where(Constants.FLIGHT_ID).is(criteria.getFlightId()));
		}
		if (!StringUtils.isEmpty(criteria.getFlightClass())) {
			whereClause.addCriteria(Criteria.where(Constants.FLIGHT_CLASS).is(criteria.getFlightClass()));
		}
		if (criteria.getStatus() != null && criteria.getStatus() > 0) {
			whereClause.addCriteria(Criteria.where(Constants.STATUS).is(criteria.getStatus()));
		}
		return whereClause;
	}

}
