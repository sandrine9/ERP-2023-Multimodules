package org.example.application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = IComputeService.class)
public class ComputeServiceTest {

    @Autowired
    ICompute computeService;

    @Test
    public void calculPrixTTC(){
        BigDecimal result = computeService.calculPrixTTC(new BigDecimal(10));
        assertEquals(new BigDecimal(10).multiply(new BigDecimal(1.2)),result);
        //assertEquals(new BigDecimal(12),result.setScale(0, RoundingMode.HALF_UP));
    }
}
