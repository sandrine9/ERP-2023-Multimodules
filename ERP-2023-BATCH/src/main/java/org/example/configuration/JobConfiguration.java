package org.example.configuration;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.domaine.Produit;
import org.example.dto.ProduitDetailsDto;
import org.example.writer.DatabaseProduitWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Configuration
@EnableBatchProcessing
public class JobConfiguration {



     @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    ItemReader<ProduitDetailsDto> itemReader;

    @Autowired
    ItemProcessor<ProduitDetailsDto, Produit> itemProcessor;

    @Autowired
    JsonFileItemWriter<Produit> jsonFileItemWriter;

    @Autowired
    ItemWriter<Produit> databaseProduitWriter;



    public Step stepCreateProduct(){
        return stepBuilderFactory
                .get("stepCreateProduct1")
                .<ProduitDetailsDto,Produit>chunk(10)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(jsonFileItemWriter)
                .writer(databaseProduitWriter)
                .build();
    }

    @Bean
    public Job createJobProduct(){
        return jobBuilderFactory
                .get("jobCreateProduct"+ LocalDateTime.now())
                .start(stepCreateProduct())
                .build();
    }
}
