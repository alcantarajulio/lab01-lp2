package DogHostTests;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

import src.Dog;
import src.DogHost;

public class DogHostTest {
    @Test
    public void TestaAdicionaCachorro(){
        DogHost dh1 = new DogHost("dh1", 500, 3);
            dh1.adicionaDog("Julie", "André", 100);
            dh1.adicionaDog("Toto", "Maty", 100);
    }
}