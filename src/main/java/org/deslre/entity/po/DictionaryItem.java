package org.deslre.entity.po;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class DictionaryItem {
    
    private String id;
    private String name;
    private String description;
    private String category;
    private List<String> tags;
    private String url;
    private int length;
    private String language;
    private String languageCategory;

    // Getters and setters

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("languageCategory")
    public String getLanguageCategory() {
        return languageCategory;
    }

    public void setLanguageCategory(String languageCategory) {
        this.languageCategory = languageCategory;
    }


    @Override
    public String toString() {
        return "DictionaryItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", tags=" + tags +
                ", url='" + url + '\'' +
                ", length=" + length +
                ", language='" + language + '\'' +
                ", languageCategory='" + languageCategory + '\'' +
                '}';
    }
}
