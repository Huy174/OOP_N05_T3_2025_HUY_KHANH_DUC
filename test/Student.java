public class Student implements Comparable {
    private String name;
    private float gpa;

    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {}

    public int compareTo(Object o) {
        if (((Student) o).gpa < this.gpa)
            return 1;
        else if (((Student) o).gpa > this.gpa)
            return -1;
        else
            return 0;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Alice", 3.5f);
        Student s2 = new Student("Bob", 3.8f);

        System.out.println(s1.compareTo(s2));
        System.out.println(s2.compareTo(s1));
    }
}

