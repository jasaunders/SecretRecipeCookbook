package com.joannesaunders.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity(name="Ingredient")
@Table(name="ingredient")
public class Ingredient {

  private long id;
  private String description;
  private long recipeId;
  private String amount;
  private long unitOfMeasureId;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(long recipeId) {
    this.recipeId = recipeId;
  }


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  public long getUnitOfMeasureId() {
    return unitOfMeasureId;
  }

  public void setUnitOfMeasureId(long unitOfMeasureId) {
    this.unitOfMeasureId = unitOfMeasureId;
  }

}
