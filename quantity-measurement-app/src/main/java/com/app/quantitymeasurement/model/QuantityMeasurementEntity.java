package com.app.quantitymeasurement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "quantity_measurement_entity", indexes = {
        @Index(name = "idx_operation", columnList = "operation"),
        @Index(name = "idx_measurement_type", columnList = "this_measurement_type"),
        @Index(name = "idx_created_at", columnList = "created_at")
})
public class QuantityMeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "this_value", nullable = false)
    public double thisValue;
    @Column(name = "this_Unit", nullable = false)
    public String thisUnit;
    @Column(name = "this_Measurement_Type", nullable = false)
    public String thisMeasurementType;

    @Column(name = "that_value", nullable = false)
    public double thatValue;
    @Column(name = "that_Unit", nullable = false)
    public String thatUnit;
    @Column(name = "that_Measurement_Type", nullable = false)
    public String thatMeasurementType;

    @Column(name = "operation", nullable = false)
    public String operation;

    @Column(name = "result_value")
    public double resultValue;
    @Column(name = "result_Unit")
    public String resultUnit;
    @Column(name = "result_Measurement_Type")
    public String resultMeasurementType;

    @Column(name = "result_String")
    public String resultString;

    @Column(name = "is_error")
    public boolean isError;

    @Column(name = "error_message")
    public String errorMessage;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate(){
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        updatedAt = LocalDateTime.now();
    }
}
