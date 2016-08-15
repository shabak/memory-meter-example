package ru.shabak.memorymeterexample;

import java.util.List;

/**
 * @author Nikolay Shabak (nikolay)
 * @since 15/08/16
 */
public class MyClass {
    private Integer id;
    private String name;
    private String description;
    private List<String> strings;
    private List<Linked> linkeds;

    public MyClass(Integer id, String name, String description, List<String> strings, List<Linked> linkeds) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.strings = strings;
        this.linkeds = linkeds;
    }
}
