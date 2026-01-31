package TemplateMethod.wild.ducks;

/**
 * Chapter 8 "Template Methods in the Wild":
 * Arrays.sort() relies on Comparable.compareTo() to complete the algorithm.
 */
public class Duck implements Comparable<Duck> {
    private final String name;
    private final int weight;

    public Duck(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " weighs " + weight;
    }

    @Override
    public int compareTo(Duck otherDuck) {
        return Integer.compare(this.weight, otherDuck.weight);
    }
}

