package com.joannesaunders.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;


/**
 * The type of unit used in a measurement.
 */
@Entity(name="UnitOfMeasure")
@Table(name = "unitOfMeasure")
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String abbreviation;

    private String description;


    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
    return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
    this.id = id;
    }


    /**
     * Gets abbreviation.
     *
     * @return the abbreviation
     */
    public String getAbbreviation() {
    return abbreviation;
    }

    /**
     * Sets abbreviation.
     *
     * @param abbreviation the abbreviation
     */
    public void setAbbreviation(String abbreviation) {
    this.abbreviation = abbreviation;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
    return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
    this.description = description;
    }

    @Override
    public String toString() {
        return "UnitOfMeasure{" +
                "id=" + id +
                ", abbreviation='" + abbreviation + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitOfMeasure that = (UnitOfMeasure) o;
        return id == that.id &&
                Objects.equals(abbreviation, that.abbreviation) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, abbreviation, description);
    }
}
