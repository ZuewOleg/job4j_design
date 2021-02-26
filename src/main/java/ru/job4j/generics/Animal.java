package ru.job4j.generics;

import java.util.Objects;

public class Animal {
    private String name;
    private int limbs;
    private double weight;
    private double height;
    private String typeFood;

    public Animal(String name, int limbs, double weight, double height, String typeFood) {
        this.name = name;
        this.limbs = limbs;
        this.weight = weight;
        this.height = height;
        this.typeFood = typeFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLimbs() {
        return limbs;
    }

    public void setLimbs(int limbs) {
        this.limbs = limbs;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getTypeFood() {
        return typeFood;
    }

    public void setTypeFood(String typeFood) {
        this.typeFood = typeFood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Animal animal = (Animal) o;
        return limbs == animal.limbs && Double.compare(animal.weight, weight) == 0
                && Double.compare(animal.height, height) == 0
                && Objects.equals(name, animal.name) && Objects.equals(typeFood, animal.typeFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, limbs, weight, height, typeFood);
    }

    @Override
    public String toString() {
        return "Animal{"
                + "name='" + name + '\''
                + ", limbs=" + limbs
                + ", weight=" + weight
                + ", height=" + height
                + ", typeFood='" + typeFood + '\''
                + '}';
    }
}
