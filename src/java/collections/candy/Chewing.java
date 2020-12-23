package collections.candy;

import collections.enums.Flavor;
import collections.enums.Producer;

/**
 * Class Chewing with parameters <b>ChewingFlavor</b>
 * @author Rysard Poplavskij
 */
public class Chewing extends Candy {
    private Flavor ChewingFlavor;

    public Chewing(String name, double sugarContent, double weight, Producer producer, Flavor chewingFlavor) {
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

        Chewing chewing = (Chewing) o;

        return ChewingFlavor == chewing.ChewingFlavor;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (ChewingFlavor != null ? ChewingFlavor.hashCode() : 0);
        return result;
    }
}
