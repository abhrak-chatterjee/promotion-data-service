package com.promotion.model;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@ToString
@JsonInclude(value = Include.NON_NULL)
public class PromotionCriteria implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
	private String bankName;

	@Getter
	@Setter
	private String cardType;
	
	@Getter
	@Setter
	private Double minimumAmountForPromotion;
	
	@Getter
	@Setter
	private String benefitType;
	
	@Getter
	@Setter
	private Double benefitAmount;
	
	@Getter
	@Setter
	private Integer status;

}
