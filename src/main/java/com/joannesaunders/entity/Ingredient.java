package com.joannesaunders.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Ingredient.
 */
@Entity(name="Ingredient")
@Table(name="ingredient")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String description;

    @ManyToOne
    private long recipeId;

    private String amount;

    private long unitOfMeasureId;

    /**
     * Instantiates a new Ingredient.
     */
    public Ingredient() {

    }

    /**
     * Instantiates a new Ingredient.
     *
     * @param description the description
     * @param recipeId    the recipe id
     */
    public Ingredient(String description, long recipeId) {
        this.description = description;
        this.recipeId = recipeId;
    }

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
     * Gets Ingredient description.
     *
     * @return the ingredient description
     */
    public String getDescription() {
    return description;
    }

    /**
     * Sets the ingredient description.
     *
     * @param description the ingredient description
     */
    public void setDescription(String description) {
    this.description = description;
    }


    /**
     * Gets recipe id.
     *
     * @return the recipe id
     */
    public long getRecipeId() {
    return recipeId;
    }

    /**
     * Sets recipe id.
     *
     * @param recipeId the recipe id
     */
    public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
    }


    /**
     * Gets amount.
     *
     * @return the measure amount
     */
    public String getAmount() {
    return amount;
    }

    /**
     * Sets amount.
     *
     * @param amount the measure amount
     */
    public void setAmount(String amount) {
    this.amount = amount;
    }


    /**
     * Gets unit of measure id.
     *
     * @return the unit of measure id
     */
    public long getUnitOfMeasureId() {
    return unitOfMeasureId;
    }

    /**
     * Sets unit of measure id.
     *
     * @param unitOfMeasureId the unit of measure id
     */
    public void setUnitOfMeasureId(long unitOfMeasureId) {
    this.unitOfMeasureId = unitOfMeasureId;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", recipeId=" + recipeId +
                ", amount='" + amount + '\'' +
                ", unitOfMeasureId=" + unitOfMeasureId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return id == that.id &&
                recipeId == that.recipeId &&
                unitOfMeasureId == that.unitOfMeasureId &&
                Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, recipeId, amount, unitOfMeasureId);
    }
}
