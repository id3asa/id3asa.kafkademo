package main.java.com.github.id3asa.kafkademo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = { "name", "dateOfLandfall", "categoryAtLandfall", "maximumSustainedWinds", "centralPressureAtLandfall", "estimatedDamage", "fatalities", "notes" })
public class Hurricane {
    String name;
    String dateOfLandfall;
    String categoryAtLandfall;
    String maximumSustainedWinds;
    String centralPressureAtLandfall;
    String estimatedDamage;
    String fatalities;
    String notes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfLandfall() {
        return dateOfLandfall;
    }

    public void setDateOfLandfall(String dateOfLandfall) {
        this.dateOfLandfall = dateOfLandfall;
    }

    public String getCategoryAtLandfall() {
        return categoryAtLandfall;
    }

    public void setCategoryAtLandfall(String categoryAtLandfall) {
        this.categoryAtLandfall = categoryAtLandfall;
    }

    public String getMaximumSustainedWinds() {
        return maximumSustainedWinds;
    }

    public void setMaximumSustainedWinds(String maximumSustainedWinds) {
        this.maximumSustainedWinds = maximumSustainedWinds;
    }

    public String getCentralPressureAtLandfall() {
        return centralPressureAtLandfall;
    }

    public void setCentralPressureAtLandfall(String centralPressureAtLandfall) {
        this.centralPressureAtLandfall = centralPressureAtLandfall;
    }

    public String getEstimatedDamage() {
        return estimatedDamage;
    }

    public void setEstimatedDamage(String estimatedDamage) {
        this.estimatedDamage = estimatedDamage;
    }

    public String getFatalities() {
        return fatalities;
    }

    public void setFatalities(String fatalities) {
        this.fatalities = fatalities;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    

}