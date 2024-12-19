package org.deslre.entity.po;

import lombok.Data;

import java.util.List;

@Data
public class Dict {
    private String id;
    private String name;
    private String description;
    private String category;
    private List<String> tags;
    private String url;
    private int length;
    private String language;
    private String languageCategory;

    // Constructors, getters, and setters
    public Dict(String id, String name, String description, String category, List<String> tags, String url, int length, String language, String languageCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.tags = tags;
        this.url = url;
        this.length = length;
        this.language = language;
        this.languageCategory = languageCategory;
    }

}
