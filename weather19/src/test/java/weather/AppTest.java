/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package weather;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.jxgm.entities.*;
import com.jxgm.service.*;
import com.jxgm.config.AppConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes={AppConfig.class})
@TestPropertySource("classpath:test/db.properties")
public class AppTest {
    @Autowired
    private ProvinceService pservice;

    @Test 
    public void testFindAll() {
        List<Province> p = pservice.findAll();
        assertThat(p.size(), equalTo(34));
    }

    @Test 
    public void testAll() {
        List<Province> provinces = pservice.findAll();
            
        Province x = null;
        for (Province p: provinces) {
            if (p.getId().equals("16")) {
                x = p;
                break;
            }
        }
        assertThat(x.getCities().size(), equalTo(11));
    }
}
