import com.nft.properties.AliSmsProperties;
import com.nft.utils.SmsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AliSmsProperties.class)
public class SmsTest {
    @Test
    public void test() throws Exception {
        SmsUtil.sendSms("1234","SMS_465312790","15205857576");
    }
}