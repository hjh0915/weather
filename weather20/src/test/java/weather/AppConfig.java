package weather;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

import com.jxgm.dao.*;
import com.jxgm.service.*;

@Configuration
@PropertySource("classpath:test/db.properties")
@ComponentScan(basePackages={"com.jxgm.service", "com.jxgm.dao"})
public class AppConfig {
    @Value("${db.jdbcdriver}")
    private String jdbcdriver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.passwd}")
    private String passwd;

    @Bean
    public static PropertySourcesPlaceholderConfigurer
        propertySourcesPlaceholderConfigurer() {
            return new PropertySourcesPlaceholderConfigurer();
    }

    @Lazy
    @Bean
    public DataSource dataSource() {
        try {
			SimpleDriverDataSource ds = new SimpleDriverDataSource();
			ds.setDriverClass((Class<Driver>) Class.forName(jdbcdriver));
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(passwd);

			return ds;
		} catch (ClassNotFoundException e) {
			return null;
		}
    }
}