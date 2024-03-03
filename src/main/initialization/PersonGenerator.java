package main.initialization;

import main.model.entities.Person;
import main.model.entities.Teacher;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.valueObjects.PersonName;

import java.util.random.RandomGenerator;

public abstract class PersonGenerator<T extends Person> {
    public IMyList<T> generate(int count){
        var result = new MyList<T>(count);
        for (int i = 0; i < count; i++){
            result.add(generate());
        }
        return result;
    }

    protected abstract T generate();

    protected static final RandomGenerator rng = RandomGenerator.getDefault();

    protected static final String[] maleFirstNames = {"Олександр", "Іван", "Петро", "Михайло", "Андрій", "Сергій", "Володимир", "Василь", "Олег", "Юрій"};
    protected static final String[] maleLastNames = {"Ковальчук", "Петренко", "Шевченко", "Бондаренко", "Коваль", "Мельник", "Козак", "Мороз", "Лисенко", "Білоус"};
    protected static final String[] maleMiddleNames = {"Олександрович", "Іванович", "Петрович", "Михайлович", "Андрійович", "Сергійович", "Володимирович", "Васильович", "Олегович", "Юрійович"};

    protected static final String[] femaleFirstNames = {"Олена", "Тетяна", "Наталія", "Ірина", "Людмила", "Надія", "Марія", "Оксана", "Вікторія", "Анна"};
    protected static final String[] femaleLastNames = {"Ковальчук", "Петренко", "Шевченко", "Бондаренко", "Коваль", "Мельник", "Козак", "Мороз", "Лисенко", "Білоус"};
    protected static final String[] femaleMiddleNames = {"Олександрівна", "Іванівна", "Петрівна", "Михайлівна", "Андріївна", "Сергіївна", "Володимирівна", "Василівна", "Олегівна", "Юріївна"};

    protected static PersonName getRandomName(String[] arr) {
        return new PersonName(arr[rng.nextInt(0, arr.length)]);
    }

}
