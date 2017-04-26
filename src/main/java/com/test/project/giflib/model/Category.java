package com.test.project.giflib.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by g0ng0n
 */
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min =3, max=12)
    private String name;

    @NotNull
    @Pattern(regexp = "#[0-9a-fA-F]{6}")
    private String colorCode;



    @OneToMany(mappedBy = "category")
    private List<Gif> gifs = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public List<Gif> getGifs() {
        return gifs;
    }

    public void setGifs(List<Gif> gifs) {
        this.gifs = gifs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (colorCode != null ? !colorCode.equals(category.colorCode) : category.colorCode != null) return false;
        return gifs != null ? gifs.equals(category.gifs) : category.gifs == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (colorCode != null ? colorCode.hashCode() : 0);
        result = 31 * result + (gifs != null ? gifs.hashCode() : 0);
        return result;
    }
}
