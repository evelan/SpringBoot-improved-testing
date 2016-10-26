package me.jpomykala.spring.demo;

import me.jpomykala.spring.demo.service.WorldRotationService;
import me.jpomykala.spring.demo.service.WorldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by Evelan on 23/10/2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class VerifyingTest {

    @Autowired
    WorldService worldService;

    @SpyBean
    WorldRotationService worldRotationService;

    @Test
    public void whenRotatingPlanet_correct() throws Exception {
        //when
        worldService.rotatePlanet(300);
        //verify
        verify(worldRotationService, times(300)).rotatePlanetBy360degrees();
    }

}