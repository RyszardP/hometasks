package collections.candy;

import collections.enums.Covering;
import collections.enums.Ingredients;
import collections.enums.Producer;

import java.util.EnumSet;

/**
 * Class Glazed with parameters <b>Filling</b>
 * @author Rysard Poplavskij
 */

public class Glazed extends Candy {
    private EnumSet<Ingredients> filling;
    private Covering covering;

    public Glazed(String name, double sugarContent, double weight, Producer producer, EnumSet<Ingredients> filling,
                  Covering covering) {
        super(name, sugarContent, weight, producer);
        this.filling = filling;
        this.covering = covering;
    }

    public EnumSet<Ingredients> getFilling() {
        return filling;
    }

    public void setFilling(EnumSet<Ingredients> filling) {
        this.filling = filling;
    }

    public Covering getCovering() {
        return covering;
    }

    public void setCovering(Covering covering) {
        this.covering = covering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Glazed glazed = (Glazed) o;

        return filling != null ? filling.equals(glazed.filling) : glazed.filling == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (filling != null ? filling.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Glazed{" +
                "filling=" + filling +
                '}';
    }
}
