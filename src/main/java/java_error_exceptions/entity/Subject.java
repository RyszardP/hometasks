package java_error_exceptions.entity;

public enum Subject {
    MATHEMATICS("Mathematics"),
    PHYSICS("Physics"),
    CHEMISTRY("Chemistry"),
    THEORY_OF_MECHANICS("Theory of mechanics"),
    STRUCTURAL_MECHANICS("Structural mechanics"),
    HYDRODYNAMICS("Hydrodynamics"),
    ELECTRICAL_ENGINEERING("Electrical engineering"),
    DRAWING("Drawing"),
    DESIGN_BASICS("Design basics");

    private final String name;

    public String getName() {
        return name;
    }

    Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                '}';
    }

    public static Subject getRandomSubject(){
        return values()[(int) (Math.random() * values().length)];
    }

}
