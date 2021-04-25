package community.happenuponjava.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig
{
    /**
     * The property from application properties. Defaults to H2
     */
    @Value("H2")
    private String dbValue;

    /**
     * A config var from Heroku giving the url for access to POSTGRESQL. Default to empty string
     */
    @Value("${spring.datasource.url:}")
    private String dbUrl;

    /**
     * The actual datasource configuration
     *
     * @return the datasource to use
     */
    @Bean
    public DataSource dataSource()
    {
        if (dbValue.equalsIgnoreCase("POSTGRESQL"))
        {
            // Assume Heroku
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("org.postgresql.Driver");
            config.setJdbcUrl(dbUrl);
            return new HikariDataSource(config);
        } else
        {
            //Assume H2
            String myUrlString = "jdbc:h2:mem:testdb";
            String myDriverClass = "org.h2.Driver";
            String myDBUser = "lou";
            String myDBPassword = "hu";

            return DataSourceBuilder.create()
                    .username(myDBUser)
                    .password(myDBPassword)
                    .url(myUrlString)
                    .driverClassName(myDriverClass)
                    .build();

        }
    }
}
