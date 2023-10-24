package org.example.configuration;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.domaine.Produit;
import org.example.dto.ProduitDetailsDto;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Objects;

@Configuration
@Primary
public class FileConfiguration {
    @Bean
    public CsvToBean<ProduitDetailsDto> csvToBean() throws FileNotFoundException {
        return new CsvToBeanBuilder<ProduitDetailsDto>(new FileReader("produits.csv"))
                .withType(ProduitDetailsDto.class)
                .build();
    }

    @Bean
    public JsonFileItemWriter<Produit> jsonFileItemWriter() {
        FileSystemResource fileSystemResource = new FileSystemResource("produits.json");
        return  new JsonFileItemWriterBuilder<Produit>()
                .jsonObjectMarshaller(new JacksonJsonObjectMarshaller<>())
                .resource(fileSystemResource)
                .name("produitJsonFileItemWriter")
                .build();
    }

}
