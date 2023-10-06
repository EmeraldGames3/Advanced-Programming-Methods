package main;

public class GradeProcessor {

    public int[] nichtAusreichendeNoten(int[] grades) {
        int[] nichtAusreichendeNotenArray = new int[0];

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] < 0 || grades[i] > 100) {
                throw new RuntimeException("Grades should be between 0 and 100.");
            }
            if(!hasPassed(grades[i])){
                nichtAusreichendeNotenArray = addToArray(nichtAusreichendeNotenArray, grades[i]);
            }
        }

        return nichtAusreichendeNotenArray;
    }

    public int round(int grade) {
        if (grade < 38) {
            return grade;
        } else {
            if (grade % 5 > 2) {
                return grade + 5 - grade % 5;
            } else {
                return grade;
            }
        }
    }

    public boolean hasPassed(int grade) {
        return round(grade) >= 40;
    }

    public int[] addToArray(int[] original, int newElement) {
        int[] result = new int[original.length + 1];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i];
        }
        result[original.length] = newElement;
        return result;
    }

}
