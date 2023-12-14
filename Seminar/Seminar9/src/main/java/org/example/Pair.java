package org.example;

public class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public Pair(Pair<T, U> pair) {
        this.first = pair.first;
        this.second = pair.second;
    }

    public Pair() {
        this.first = null;
        this.second = null;
    }

    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    public String toString() {
        return "First: " + first + ", Second: " + second;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair<T, U> pair = (Pair<T, U>) obj;
            return this.first.equals(pair.first) && this.second.equals(pair.second);
        }
        return false;
    }

    public int hashCode() {
        return first.hashCode() + second.hashCode();
    }
}
