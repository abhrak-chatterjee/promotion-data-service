package com.promotion.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.promotion.constants.Constants;
import com.promotion.dto.PromotionDTO;
import com.promotion.model.PromotionCriteria;
import com.promotion.model.PromotionModel;
import com.promotion.repository.PromotionRepository;
import com.promotion.service.PromoionService;
import com.promotion.util.CommonUtil;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class PromotionServiceImpl implements PromoionService {

	@Autowired
	private PromotionRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;

	/**
	 * Method used for Saving the Service Configuration Document!.
	 */
	@Override
	public PromotionModel savePromotionData(PromotionDTO promotionDTO) throws Exception {
		PromotionModel model = null;
		try {
			model = repository.save(prepareObject(promotionDTO));
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return model;
	}

	/**
	 * Method used for searching the profile by criteria!.
	 */
	@Override
	public List<PromotionModel> getPromotionDataByCriteria(PromotionCriteria criteria) throws Exception {
		List<PromotionModel> list = null;
		try {
			list = repository.findByCriteria(criteria);
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return list;
	}

	/**
	 * Method used for preparing the Object!.
	 * 
	 * @param model
	 * @return
	 */
	private PromotionModel prepareObject(PromotionDTO promotionDTO) {
		PromotionModel model = new PromotionModel();
		try {
			model = modelMapper.map(promotionDTO, PromotionModel.class);
			if (!StringUtils.isEmpty(model.getPromotionId())) {
				model.setUpdatedDate(CommonUtil.getCurrentDateInString());
				model.setUpdatedBy(Constants.PROMOTION_DATA_SERVICE);
			} else {
				model.setCreatedDate(CommonUtil.getCurrentDateInString());
				model.setCreatedBy(Constants.PROMOTION_DATA_SERVICE);
			}
			model.setExistingUserPromotionAmount(Constants.EXISTING_USER_DISCOUNT);
		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			throw e;
		}
		return model;
	}

}
