import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;


public class FelineTests {

    private final Feline spyFeline = Mockito.spy(new Feline());

    // Проверяем, что eatMeat() вызывает унаследованный метод getFood("Хищник") и возвращает полученный список
    @Test
    public void eatMeatReturnsFoodListForPredator() throws Exception {
        List<String> expected = List.of("Какой", "-то", "список");
        Mockito.doReturn(expected).when(spyFeline).getFood("Хищник");

        List<String> actual = spyFeline.eatMeat();

        Assert.assertEquals(expected, actual);
        Mockito.verify(spyFeline).getFood("Хищник");
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
        Mockito.verify(spyFeline).getKittens(1);
    }

    // Проверяем прямой возврат значения: getKittens(int) должен возвращать ровно то число, которое в него передали
    @Test
    public void getKittensWithArgumentReturnsPassedValue() {
        final int expectedValue = 111;
        Feline feline = new Feline();

        Assert.assertEquals(expectedValue, feline.getKittens(expectedValue));
    }
}