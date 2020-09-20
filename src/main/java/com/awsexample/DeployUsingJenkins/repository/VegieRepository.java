package com.awsexample.DeployUsingJenkins.repository;

import com.awsexample.DeployUsingJenkins.model.VegieModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegieRepository extends CrudRepository<VegieModel,Long> {

}
