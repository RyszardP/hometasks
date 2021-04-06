package java_error_exceptions.util;

import java.util.Random;

public class RandomNames {


    public static String[] name = {"Rey", "John", "Chris", "James", "David", "Tim", "Jane", "William", "Harper",
            "Evelyn", "Jack", "Avery", "Scarlett", "Max", "Sam", "Charlie", "Ashley", "Emerson", "Donald", "Joseph",
            "Kamala", "Patrick"};
    public static String[] secondName = {"Leahy", "Harris", "Brown", "Gray", "Boxer", "Jackson", "Polk", "Pierce",
            "Buchanan", "Johnson", "Cleveland", "Wilson", "Roosevelt", "Debs", "Isakson", "Paul", "Barrasso", "Lee",
            "Grant", "Baucus", "Blunt", "Moran", "Kaine", "Vitter", "Portman", "Grassley", "Graham", "Johanns",
            "Hoeven", "Durbin", "Heller", "Cantwell", "Carper", "Flake", "Coburn", "Casey", "Landrieu", "Shelby",
            "Schumer", "Enzi", "Bergeron", "Bjork", "Blidh", "Coyle", "DeBrusk", "Kase", "Kuraly", "PAstrnak", "Ritchie",
            "Smith", "Wagner", "Carlo", "Clifton", "Lauzon", "Moore", "Rask", "Rakell", "Steel", "Janes", "Grant",
            "Miller", "Gibson", "Larsson", "Hutton"};

    public static String getRandomName(){
        return name[new Random().nextInt(name.length)];
    }

    public static String getRandomSecondName(){
        return secondName[new Random().nextInt(secondName.length)];
    }

}
