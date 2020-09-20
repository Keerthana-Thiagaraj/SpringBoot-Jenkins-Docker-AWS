package com.awsexample.DeployUsingJenkins;

import com.awsexample.DeployUsingJenkins.model.VegieModel;
import com.awsexample.DeployUsingJenkins.repository.VegieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DeployUsingJenkinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeployUsingJenkinsApplication.class, args);
    }

    @Bean
    public CommandLineRunner sampleData(VegieRepository vegieRepository) {
        return (args -> {
            vegieRepository.save(new VegieModel("Carrot", "Helps in improving eyesight"));
            vegieRepository.save(new VegieModel("Beetroot", "Cures skin problems"));
            vegieRepository.save(new VegieModel("cabbage", "not suitable for thyroid disease"));

        });
    }

}
