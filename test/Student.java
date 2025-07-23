public class Student implements Comparable<Student> {
    private String name;
    private float gpa;

    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
    }

    public Student() {}

    @Override
    public int compareTo(Student o) {
        if (o.gpa < this.gpa)
            return 1;
        else if (o.gpa > this.gpa)
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

        System.out.println(s1.compareTo(s2)); // -1 vì 3.5 < 3.8
        System.out.println(s2.compareTo(s1)); // 1 vì 3.8 > 3.5
    }
}
