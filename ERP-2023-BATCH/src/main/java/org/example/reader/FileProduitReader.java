package org.example.reader;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import org.example.dto.ProduitDetailsDto;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;


@Component
public class FileProduitReader implements ItemReader<ProduitDetailsDto> {



    Iterator<ProduitDetailsDto> iterator;

    public FileProduitReader(CsvToBean<ProduitDetailsDto> csvToBean){
        this.iterator=csvToBean.iterator();
    }

    @Override
    public ProduitDetailsDto read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (!iterator.hasNext()) {
            return null;
        }
        return iterator.next();
    }
}
