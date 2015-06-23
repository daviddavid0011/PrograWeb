/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

 
@ManagedBean
public class RingView implements Serializable {
     
    private List<Car> cars;
    private Car selectedCar;
     
    
    @PostConstruct
    public void init() {
        cars = new ArrayList<Car>();
         
        cars.add(new Car("1", "Ford", 2000, "Black"));
        cars.add(new Car("2", "Car", 2003, "Orange"));
        cars.add(new Car("4", "Tire", 2012, "Red"));
        cars.add(new Car("3", "Ford - copia", 2000, "Black"));
        cars.add(new Car("5", "Car - copia", 2003, "Orange"));
        cars.add(new Car("6", "Tire - copia", 2012, "Red"));
    }
 
    public List<Car> getCars() {
        return cars;
    }
 
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
 
    public Car getSelectedCar() {
        return selectedCar;
    }
 
    public void setSelectedCar(Car selectedCar) {
        this.selectedCar = selectedCar;
    }
}
