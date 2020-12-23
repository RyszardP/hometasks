package collections.main_task.candy;

import collections.main_task.enums.Flavor;
import collections.main_task.enums.Producer;

public class Cheving extends Candy {
    private Flavor ChewingFlavor;

    public Cheving(String name, double sugarContent, double weight, Producer producer, Flavor chewingFlavor) {
        super(name, sugarContent, weight, producer);
        ChewingFlavor = chewingFlavor;
    }

    public Flavor getChewingFlavor() {
        return ChewingFlavor;
    }

    public void setChewingFlavor(Flavor chewingFlavor) {
        ChewingFlavor = chewingFlavor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cheving cheving = (Cheving) o;

        return ChewingFlavor == cheving.ChewingFlavor;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (ChewingFlavor != null ? ChewingFlavor.hashCode() : 0);
        return result;
    }
}
