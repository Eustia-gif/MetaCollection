import com.nft.constract.ContractInteraction;
import com.nft.ipfs.repo.IpfsService;
import com.nft.ipfs.service.IpfsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {IpfsServiceImpl.class,ContractInteraction.class})
public class IpfsTest {
    @Autowired
    private IpfsService ipfsService;
    @Autowired
    private ContractInteraction contractInteraction;
    // 上传
    @Test
    public void uploadIpfs() throws IOException {
        byte[] data = "hhhhhhhhh".getBytes();
        String hash = ipfsService.uploadToIpfs(data);
        // Qmf412jQZiuVUtdgnB36FXFX7xg5V6KEbSJ4dpQuhkLyfD
        System.out.println(hash);
    }

    // 下载
    @Test
    public void downloadIpfs() {
        String hash = "QmaYTffZhVvcFXvx6LdEauSskxzNDyQtTocEZc6uDdYREb";
        byte[] data = ipfsService.downFromIpfs(hash);
        System.out.println(new String(data));
    }
    @Test
    public void storage() throws Exception {
//        String s = String.valueOf(contractInteraction.storeHashAndGetId("1111234234"));
//        contractInteraction.getLatestId();
        String hash = contractInteraction.storeHash("QmRrsznmUo6Z9N2bFjDmduMimUxfBXKeiz3o8cD8mzafGZ");
        System.out.println(hash);
    }
    @Test
    public void getHash() throws Exception {
        String hash = contractInteraction.getHash("0xfd86ec4f78d7e88fd3a5bf91e68486ca182ae8cb44f850428459d1a5e81cbe48");
        System.out.println(hash);
    }
}
