import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import javax.sql.DataSource;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruu.springmvcxml.sample.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTest {

    @Autowired
    private SampleService sampleService;

    @Autowired
    DataSource dataSource;

    @Test
    public void testService() {
        log.info(sampleService);
        assertNotNull(sampleService);
    }

      @Test
        void testConnection() throws Exception {
          Connection connection = dataSource.getConnection();
          log.info(connection);
          assertNotNull(connection);
          connection.close();
        }
}
