package main.initialization;

import main.model.entities.Person;
import main.model.entities.Teacher;
import main.model.utils.list.IMyList;
import main.model.utils.list.MyList;
import main.model.valueObjects.PersonName;

import java.util.random.RandomGenerator;
/*
 * This class is a generic class that is used to generate a list of people.
 * It is used to generate a list of teachers and students.
 * It is a generic class because it can be used to generate any type of person.
 * It is an abstract class because it is not meant to be instantiated.
 * It is a public class because it is used in other packages.
 */
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
    /*
     * This method is used to generate a random name for a person.
     * It is a protected method because it is only used in this class and its subclasses.
     * It is a static method because it does not depend on the state of the object.
     * It is a final method because it should not be overridden.
     */
    protected static final String[] maleFirstNames = {"Олександр", "Іван", "Петро", "Михайло", "Андрій", "Сергій", "Володимир", "Василь", "Олег", "Юрій"};
    protected static final String[] maleLastNames = {"Ковальчук", "Петренко", "Шевченко", "Бондаренко", "Коваль", "Мельник", "Козак", "Мороз", "Лисенко", "Білоус"};
    protected static final String[] maleMiddleNames = {"Олександрович", "Іванович", "Петрович", "Михайлович", "Андрійович", "Сергійович", "Володимирович", "Васильович", "Олегович", "Юрійович"};

    protected static final String[] femaleFirstNames = {"Олена", "Тетяна", "Наталія", "Ірина", "Людмила", "Надія", "Марія", "Оксана", "Вікторія", "Анна"};
    protected static final String[] femaleLastNames = {"Ковальчук", "Петренко", "Шевченко", "Бондаренко", "Коваль", "Мельник", "Козак", "Мороз", "Лисенко", "Білоус"};
    protected static final String[] femaleMiddleNames = {"Олександрівна", "Іванівна", "Петрівна", "Михайлівна", "Андріївна", "Сергіївна", "Володимирівна", "Василівна", "Олегівна", "Юріївна"};
    /*
     * This method is used to generate a random name for a person.
     * It is a protected method because it is only used in this class and its subclasses.
     * It is a static method because it does not depend on the state of the object.
     * It is a final method because it should not be overridden.
     */
    protected static PersonName getRandomName(String[] arr) {
        return new PersonName(arr[rng.nextInt(0, arr.length)]);
    }

}
