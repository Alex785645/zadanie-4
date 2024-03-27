
import java.util.ArrayList;
import java.util.List;

public class Student {
    public String name;
    public List<Double> grades;

    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        if (grades.size() >= 20) {
            throw new IllegalStateException("Student can have maximum 20 grades");
        }
        grades.add(grade);
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Student has no grades");
        }
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        double average = sum / grades.size();
        return roundToNearestHalf(average);
    }

    private double roundToNearestHalf(double value) {
        double[] roundedValues = {2, 2.5, 3, 3.5, 4, 4.5, 5};
        double minDiff = Double.MAX_VALUE;
        double closestValue = value;

        for (double roundedValue : roundedValues) {
            double diff = Math.abs(roundedValue - value);
            if (diff < minDiff) {
                minDiff = diff;
                closestValue = roundedValue;
            }
        }

        return closestValue;
    }
}

