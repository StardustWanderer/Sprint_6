import com.example.Animal;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {

    // У класса Feline пустой конструктор, поэтому Mockito инициализирует шпиона автоматически
    @Spy
    private Feline spyFeline;

    // Проверяем, что eatMeat() вызывает унаследованный метод getFood("Хищник") и возвращает полученный список
    @Test
    public void eatMeatReturnsFoodListForPredator() throws Exception {
        List<String> expected = List.of("Какой", "-то", "список");
        Mockito.doReturn(expected).when(spyFeline).getFood("Хищник");

        Assert.assertEquals(expected, spyFeline.eatMeat());
    }

    // Проверяем, что метод getFamily() возвращает дефолтное семейство "Кошачьи"
    @Test
    public void getFamilyReturnsStringFeline() {
        String expected = "Кошачьи";
        Feline feline = new Feline();

        Assert.assertEquals(expected, feline.getFamily());
    }

    // Проверяем делегирование: метод getKittens() без аргумента должен вызывать getKittens(1)
    @Test
    public void getKittensWithoutArgumentCallsGetKittensWithArgument() {
        int expected = 999;
        Mockito.doReturn(expected).when(spyFeline).getKittens(1);

        Assert.assertEquals(expected, spyFeline.getKittens());
    }

    // Проверяем прямой возврат значения: getKittens(int) должен возвращать ровно то число, которое в него передали
    @Test
    public void getKittensWithArgumentReturnsPassedValue() {
        final int expectedValue = 111;
        Feline feline = new Feline();

        Assert.assertEquals(expectedValue, feline.getKittens(expectedValue));
    }
}