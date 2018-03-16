package com.joannesaunders.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Instruction.
 */
@Entity(name = "Instruction")
@Table(name = "instruction")
public class Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;

    private String description;

    @ManyToOne
    private long recipeId;

    /**
     * Instantiates a new Instruction.
     */
    public Instruction() {

    }

    /**
     * Instantiates a new Instruction.
     *
     * @param description the description
     * @param recipeId    the recipe id
     */
    public Instruction(String description, long recipeId) {
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


    @Override
    public String toString() {
        return "Instruction{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", recipeId=" + recipeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instruction that = (Instruction) o;
        return id == that.id &&
                recipeId == that.recipeId &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, recipeId);
    }
}
