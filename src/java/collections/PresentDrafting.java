package collections.main_task;

import collections.main_task.candy.*;
import collections.main_task.enums.Flavor;
import collections.main_task.enums.Ingredients;
import collections.main_task.enums.Producer;

import java.util.EnumSet;

public class PresentDrafting {

    public static final Present present = new Present();
    static {
        present.addCandy(new Lollipop("Москвичка", 0.2,24.3, Producer.MOSKVICHKA, Flavor.CHERRY));
        present.addCandy(new Lollipop("Yogurtini",0.4,14.5,Producer.ROSHEN,Flavor.RASPBERRY));
        present.addCandy(new Lollipop("Eucalyptus",0.7,27.3,Producer.ROSHEN,Flavor.MINT));
        present.addCandy(new Lollipop("Bim-Bom",0.8,21.4,Producer.ROSHEN,Flavor.LEMON));
        present.addCandy(new Lollipop("Bim-Bom",0.8,21.4,Producer.ROSHEN,Flavor.CHERRY));
        present.addCandy(new Lollipop("Bim-Bom",0.8,21.4,Producer.ROSHEN,Flavor.APPLE));
        present.addCandy(new Lollipop("Bim-Bom",0.8,21.4,Producer.ROSHEN,Flavor.RASPBERRY));
        present.addCandy(new Marmalade("Haribo",1.2,155,Producer.HARIBO,Flavor.APPLE));
        present.addCandy(new Cheving("Mamba",3,7,Producer.MAMBA,Flavor.CHERRY));
        present.addCandy(new Cheving("Meller",0.5,38,Producer.MELLER,Flavor.CHOCOLATE));
        present.addCandy(new Cheving("Jelli",2.7,65,Producer.ROSHEN,Flavor.LEMON));
        present.addCandy(new Cheving("Jelli",2.7,65,Producer.ROSHEN,Flavor.APPLE));
        present.addCandy(new Cheving("Jelli",2.7,65,Producer.ROSHEN,Flavor.ORANGE));
        present.addCandy(new Cheving("Jelli",2.7,65,Producer.ROSHEN,Flavor.STRAWBERRY));
        present.addCandy(new Glazed("Алёнка",1.1,20,Producer.KOMMUNARKA, EnumSet.of(Ingredients.COCOA,Ingredients.HAZELNUT)));
        present.addCandy(new Glazed("Spartak",1.2,48,Producer.SPARTAK,EnumSet.of(Ingredients.CARAMEL,Ingredients.NOUGAT,Ingredients.PEANUT)));
        present.addCandy(new Glazed("Аэрофлотские",0.4,12,Producer.SPARTAK,EnumSet.of(Ingredients.COCOA,Ingredients.NOUGAT,Ingredients.PEANUT,Ingredients.CARAMEL)));
        present.addCandy(new Glazed("Красная Шапочка",1.1,16,Producer.KOMMUNARKA,EnumSet.of(Ingredients.COCOA,Ingredients.WAFFLES,Ingredients.COCONUT)));
        present.addCandy(new Glazed("Черноморочка Топ",0.9,15,Producer.KOMMUNARKA,EnumSet.of(Ingredients.COCOA,Ingredients.COCONUT)));
    }

    public static void main(String[] args) {
        double maxAmountOfSugar = 2;
        double minAmountOfSugar = 0.5;

        System.out.println("Конфеты в подарке, соответствующую диапазону содержания сахара от "
                + minAmountOfSugar + " до " + maxAmountOfSugar);
        System.out.println(present.getCandiesWithContentOfSugarInRange(minAmountOfSugar,maxAmountOfSugar));
        present.sortCandiesByWeight();
        System.out.println(present);
    }
}