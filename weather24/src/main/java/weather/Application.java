package weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

import com.jxgm.service.*;
import com.jxgm.entities.*;
import java.util.Optional;

// @SpringBootApplication相当于三个注解
// 因weather24沿袭了之前的代码结构，所以需要部分自定义配置，才能装配相关的bean
@SpringBootApplication(scanBasePackages="com.jxgm")
@EnableJpaRepositories(basePackages="com.jxgm")
@EntityScan("com.jxgm.entities")
public class Application {
    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        // 打印输出spring boot自动装配的bean
        // Arrays.stream(ctx.getBeanDefinitionNames()).forEach(logger::info);

        ProvService pservice = ctx.getBean(ProvService.class);
        Optional<Province> p = pservice.findById(new Long(16));
        if (p.isPresent()) {
            Province x = p.get();
            System.out.println("okkkkkkkkkkkkkk");
            System.out.println(x);
        }   
    }

    // 与之前的@EnableJpaRepositories, @EntityScan对应
    // 造成MyRunner需要手动装配，所以需要自定义bean
    @Bean
    public MyRunner schedulerRunner() {
        return new MyRunner();
    }
}
