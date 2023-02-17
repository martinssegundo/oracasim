package br.com.tasdua.orcasim.domain.usercases.impl;

import br.com.tasdua.orcasim.domain.entities.Car;
import br.com.tasdua.orcasim.domain.entities.Driver;
import br.com.tasdua.orcasim.domain.entities.Insurance;
import br.com.tasdua.orcasim.domain.usercases.ICreateNewInsurance;

import java.time.LocalDate;
import java.util.List;

public class CreateNewInsurance implements ICreateNewInsurance {

    @Override
    public void newInsurance(Insurance insurance) {
        createNewCar(insurance.getCar());
        createNewDrivers(insurance.getCar().getDrivers());
        createNewClaimsCar(insurance.getCar());
        createNewClaimsDrivers(insurance.getCar());
    }

    private void createNewCar(Car car) {

    }

    private void createNewDrivers(List<Driver> drivers){
        //verify if exist driver
        //if existe associate to a car
        //if not existe create a new one and associate
    }

    private void createNewClaimsCar(Car car){
        car.getClaims().forEach(claimDAte ->{
            //CREATE NEW ONE
        });
    }

    private void createNewClaimsDrivers(Car car){
        car.getDrivers().forEach(driver ->{
            driver.getClaims().forEach(dateClame -> {
                //CREATE NEW ONE
            });
        });
    }

}
