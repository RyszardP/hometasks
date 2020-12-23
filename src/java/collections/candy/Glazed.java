package collections.main_task.candy;

import collections.main_task.enums.Ingredients;
import collections.main_task.enums.Producer;

import java.util.EnumSet;

public class Glazed extends Candy {
    private EnumSet<Ingredients> Filling;

    public Glazed(String name, double sugarContent, double weight, Producer producer, EnumSet<Ingredients> filling) {
        super(name, sugarContent, weight, producer);
        Filling = filling;
    }

    public EnumSet<Ingredients> getFilling() {
        return Filling;
    }

    public void setFilling(EnumSet<Ingredients> filling) {
        Filling = filling;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Glazed glazed = (Glazed) o;

        return Filling != null ? Filling.equals(glazed.Filling) : glazed.Filling == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (Filling != null ? Filling.hashCode() : 0);
        return result;
    }
}
