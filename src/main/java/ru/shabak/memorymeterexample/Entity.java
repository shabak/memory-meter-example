package ru.shabak.memorymeterexample;

import java.util.List;

import org.github.jamm.Unmetered;

/**
 * @author Nikolay Shabak (nikolay)
 * @since 15/08/16
 */
public class Entity {
    private Integer id;
    private String name;
    private String description;
    private List<String> strings;

    @Unmetered
    private List<RelatedEntity> relatedEntities;

    public Entity(Integer id, String name, String description, List<String> strings, List<RelatedEntity> relatedEntities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.strings = strings;
        this.relatedEntities = relatedEntities;
    }
}
