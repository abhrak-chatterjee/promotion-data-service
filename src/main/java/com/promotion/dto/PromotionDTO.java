package com.promotion.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class PromotionDTO {

	@Getter
	@Setter
	private String promotionId;
	
	@Getter
	@Setter
	private String flightId;
	
	@Getter
	@Setter
	private String flightClass;
	
	@Getter
	@Setter
	private Double promotionAmount;
	
	@Getter
	@Setter
	private Double maximumPromotionAmount;
	
	@Getter
	@Setter
	private String bankName;

	@Getter
	@Setter
	private String cardType;
	
	@Getter
	@Setter
	private Double minimumAmountForPromotion;
	
	@Getter
	@Setter
	private List<String> benefitType;
	
	@Getter
	@Setter
	private Integer benefitAmount;

	@Getter
	@Setter
	private String createdBy;

	@Getter
	@Setter
	private String createdDate;

	@Getter
	@Setter
	private String updatedDate;

	@Getter
	@Setter
	private String updatedBy;

	@Getter
	@Setter
	private Integer status;
}
