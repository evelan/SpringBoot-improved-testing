package me.jpomykala.spring.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Evelan on 23/10/2016.
 */
@Service
public class WorldServiceImpl implements WorldService {

    @Autowired
    WorldRotationService worldRotationService;

    @Override
    public String appendWorld(String data) {
        return data + "World";
    }

    @Override
    public void rotatePlanet(int howMany) {
        for (int i = 0; i < howMany; i++) {
            worldRotationService.rotatePlanetBy360degrees();
        }
    }
}
