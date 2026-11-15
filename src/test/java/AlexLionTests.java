import com.example.AlexLion;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AlexLionTests {

    private AlexLion alex;

    @Before
    public void SetUp() throws Exception{
        alex = new AlexLion(new Feline());
    }

    //по сути тут можно не использовать мокито, feline нам нужен только для создания объекта Алекс
    @Test
    public void alexLionConstructorCreatesMaleLion() {

        //проверяем, что у Алекса есть грива, т.е. он самец
        boolean expected = true;

        Assert.assertEquals("У Алекса должна быть грива", expected, alex.doesHaveMane());
    }

    @Test
    public void getFriendsReturnsListOfFriends(){
        List<String> expected = List.of("Марти", "Глория", "Мелман");

        Assert.assertEquals("Фактический список не соответствует ожидаемому", expected, alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNewYorkZoo(){
        String expected = "Нью-Йоркский зоопарк";

        Assert.assertEquals("Фактическая строка не соответствует ожидаемой", expected, alex.getPlaceOfLiving());
    }

    @Test
    public void getKittensReturnsZeroValue() {
        int expected = 0;

        Assert.assertEquals("Фактическое число не соответствует ожидаемому", expected, alex.getKittens());
    }
}
