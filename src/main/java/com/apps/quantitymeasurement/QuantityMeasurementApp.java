/**
 * @author:LukeshGaydhane
 */

package com.apps.quantitymeasurement;

import com.apps.quantitymeasurement.controller.QuantityMeasurementController;
import com.apps.quantitymeasurement.dto.QuantityDTO;
import com.apps.quantitymeasurement.repository.IQuantityMeasurementRepository;
import com.apps.quantitymeasurement.repository.QuantityMeasurementCacheRepository;
import com.apps.quantitymeasurement.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementApp {

    private static QuantityMeasurementApp instance;

    public QuantityMeasurementController controller;

    public IQuantityMeasurementRepository repository;

    private QuantityMeasurementApp(){
        this.repository = QuantityMeasurementCacheRepository.getInstance();
        QuantityMeasurementServiceImpl service = new QuantityMeasurementServiceImpl(this.repository);
        this.controller = new QuantityMeasurementController(service);
    }

    public static QuantityMeasurementApp getInstance(){
        if(instance == null){
            instance = new QuantityMeasurementApp();
        }

        return instance;
    }

    public static void main(String[] args) {

        QuantityMeasurementApp app = QuantityMeasurementApp.getInstance();

        QuantityMeasurementController controller = app.controller;

        QuantityDTO q1 = new QuantityDTO(5, "FEET", "LENGTH");
        QuantityDTO q2 = new QuantityDTO(200, "INCHES", "LENGTH");
        QuantityDTO q3 = new QuantityDTO(2, "YARDS", "LENGTH");

        boolean compareResult = controller.performComparison(q1, q2);
        System.out.println("Compare (5 meter vs 200 cm): " + compareResult);

        QuantityDTO target = new QuantityDTO(0, "CENTIMETERS", "LENGTH");
        QuantityDTO converted = controller.performConversion(q1, target);
        System.out.println("Convert 5 meter to cm: " + converted);

        QuantityDTO addResult = controller.performAddition(q1, q2);
        System.out.println("Add (5m + 200cm): " + addResult);

        QuantityDTO addTarget = new QuantityDTO(0, "CENTIMETERS", "LENGTH");
        QuantityDTO addTargetResult = controller.performAddition(q1, q2, addTarget);
        System.out.println("Add with target (cm): " + addTargetResult);

        QuantityDTO subtractResult = controller.performSubtraction(q1, q3);
        System.out.println("Subtract (5m - 2m): " + subtractResult);

        QuantityDTO subtractTarget = new QuantityDTO(0, "CENTIMETERS", "LENGTH");
        QuantityDTO subtractTargetResult = controller.performSubtraction(q1, q3, subtractTarget);
        System.out.println("Subtract with target (cm): " + subtractTargetResult);

        double divideResult = controller.performDivision(q1, q3);
        System.out.println("Divide (5m / 2m): " + divideResult);
    }
}