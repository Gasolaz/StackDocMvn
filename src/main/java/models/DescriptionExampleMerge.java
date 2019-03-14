package models;

import java.util.List;

public class DescriptionExampleMerge {
    private Description description;
    private List<Example> exampleList;

    public DescriptionExampleMerge(Description description, List<Example> exampleList) {
        this.description = description;
        this.exampleList = exampleList;
    }
}
