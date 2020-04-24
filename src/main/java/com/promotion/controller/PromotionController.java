package com.promotion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.promotion.constants.Constants;
import com.promotion.dto.PromotionDTO;
import com.promotion.model.PromotionCriteria;
import com.promotion.model.PromotionModel;
import com.promotion.service.PromoionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@Api(value = "This API is created for User API Specs!")
@CrossOrigin
public class PromotionController {

	@Autowired
	private PromoionService service;

	/**
	 * This method is used for getting the Reason Codes by Criteria!
	 * 
	 * @param criteria
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "/api-service/promotion/v1/criteria", produces = "application/json")
	@ApiOperation(httpMethod = "POST", value = "This method is used for getting the Users by Specified Criteria! ", produces = "application/json", response = PromotionModel.class)
	public ResponseEntity getPromotionByCriteria(@RequestBody(required = true) PromotionCriteria criteria) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getPromotionDataByCriteria(criteria), HttpStatus.OK);

		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			response = new ResponseEntity(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response;
	}

	/**
	 * This method is used for getting the Reason Codes by Criteria!
	 * 
	 * @param criteria
	 * @return
	 * @throws Exception 
	 */
	@PostMapping(value = "/api-service/promotion/v1/save", produces = "application/json")
	@ApiOperation(httpMethod = "POST", value = "This method is used for persisting the Reason Code!.", produces = "application/json", response = PromotionModel.class)
	public ResponseEntity savePromotion(@RequestBody(required = true) PromotionDTO promotionDTO) throws Exception {
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.savePromotionData(promotionDTO), HttpStatus.OK);

		} catch (Exception e) {
			log.info(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, e.getMessage());
			response = new ResponseEntity(Constants.EXCEPTION_OCCURED_WHILE_PROCESSING, HttpStatus.BAD_REQUEST);
			throw e;
		}
		return response;
	}

}
