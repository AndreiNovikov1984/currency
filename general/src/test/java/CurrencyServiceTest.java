import com.example.currency.CurrencyMapper;
import com.example.currency.service.CurrencyServiceImpl;
import com.example.service.DictionaryService;
import com.example.service.ReaderXML;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {
    @InjectMocks
    private CurrencyServiceImpl currencyService;
    @Spy
    private ReaderXML readerXML;
    @Spy
    private CurrencyMapper currencyMapper;
    @Mock
    private DictionaryService dictionaryService;


    @Test
    void getAllCurrencyInfoTest() {
        currencyService.getAllCurrencyInfo(null);
    }

}
