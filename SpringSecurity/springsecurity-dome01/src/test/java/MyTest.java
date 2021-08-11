import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Description:
 * @Author: Yang.Guo
 * @Date: 2021/08/11/11:08
 */
public class MyTest {

    @Test
    public void testPw(){
        PasswordEncoder pw = new BCryptPasswordEncoder();
        String encode = pw.encode("123456");
        System.out.println(encode);
        boolean matches = pw.matches("123456", encode);
        System.out.println(matches);
    }
}
