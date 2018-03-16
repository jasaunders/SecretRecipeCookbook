package com.joannesaunders.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
/**
 * The type Recipe.
 */
/**
 * The type Category.
 */
@Entity(name = "Recipe")
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private long id;
    private String name;

    @ManyToOne
    private long categoryId;

    private long publicInd;
    private String videoLink;
    private String servingSize;
    private long numServings;

    /**
     * Instantiates a new recipe.
     */
    public Recipe() {
    }

    public Recipe(String name, long categoryId, long publicInd, String videoLink, String servingSize, long numServings) {
        this.name = name;
        this.categoryId = categoryId;
        this.publicInd = publicInd;
        this.videoLink = videoLink;
        this.servingSize = servingSize;
        this.numServings = numServings;
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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * Gets category id.
   *
   * @return the category id
   */
  public long getCategoryId() {
    return categoryId;
  }

  /**
   * Sets category id.
   *
   * @param categoryId the category id
   */
  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  /**
   * Gets public ind.
   *
   * @return the public ind
   */
  public long getPublicInd() {
    return publicInd;
  }

  /**
   * Sets public ind.
   *
   * @param publicInd the public ind
   */
  public void setPublicInd(long publicInd) {
    this.publicInd = publicInd;
  }


  /**
   * Gets video link.
   *
   * @return the video link
   */
  public String getVideoLink() {
    return videoLink;
  }

  /**
   * Sets video link.
   *
   * @param videoLink the video link
   */
  public void setVideoLink(String videoLink) {
    this.videoLink = videoLink;
  }


  /**
   * Gets serving size.
   *
   * @return the serving size
   */
  public String getServingSize() {
    return servingSize;
  }

  /**
   * Sets serving size.
   *
   * @param servingSize the serving size
   */
  public void setServingSize(String servingSize) {
    this.servingSize = servingSize;
  }


  /**
   * Gets num servings.
   *
   * @return the num servings
   */
  public long getNumServings() {
    return numServings;
  }

  /**
   * Sets num servings.
   *
   * @param numServings the num servings
   */
  public void setNumServings(long numServings) {
    this.numServings = numServings;
  }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", publicInd=" + publicInd +
                ", videoLink='" + videoLink + '\'' +
                ", servingSize='" + servingSize + '\'' +
                ", numServings=" + numServings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id &&
                categoryId == recipe.categoryId &&
                publicInd == recipe.publicInd &&
                numServings == recipe.numServings &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(videoLink, recipe.videoLink) &&
                Objects.equals(servingSize, recipe.servingSize);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, categoryId, publicInd, videoLink, servingSize, numServings);
    }
}
