package com.promotion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.promotion.model.PromotionModel;

@Repository
public interface PromotionRepository extends MongoRepository<PromotionModel, String>,PromotionRepositoryCriteria {

}
