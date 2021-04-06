package collections.candy;

import collections.enums.Flavor;
import collections.enums.Producer;
import collections.enums.Shape;

/**
 * Class Chewing with parameters <b>ChewingFlavor</b>
 * @author Rysard Poplavskij
 */
public class Chewing extends Candy {
    private Flavor chewingFlavor;
    private Shape shape;

    public Chewing(String name, double sugarContent, double weight, Producer producer, Flavor chewingFlavor, Shape shape) {
        super(name, sugarContent, weight, producer);
        this.chewingFlavor = chewingFlavor;
        this.shape = shape;
    }

    public Flavor getChewingFlavor() {
        return chewingFlavor;
    }

    public void setChewingFlavor(Flavor chewingFlavor) {
        this.chewingFlavor = chewingFlavor;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Chewing chewing = (Chewing) o;

        if (chewingFlavor != chewing.chewingFlavor) return false;
        return shape == chewing.shape;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (chewingFlavor != null ? chewingFlavor.hashCode() : 0);
        result = 31 * result + (shape != null ? shape.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Chewing{" +
                "chewingFlavor=" + chewingFlavor +
                ", shape=" + shape +
                '}';
    }

    
}
