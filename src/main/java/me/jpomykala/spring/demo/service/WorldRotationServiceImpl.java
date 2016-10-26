package me.jpomykala.spring.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by Evelan on 24/10/2016.
 */
@Service
public class WorldRotationServiceImpl implements WorldRotationService {

    @Override
    public void rotatePlanetBy360degrees() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
