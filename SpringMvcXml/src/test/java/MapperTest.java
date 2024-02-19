import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.ruu.springmvcxml.sample.mapper.TimeMapper2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class MapperTest {

    @Autowired(required = false)
    private TimeMapper2 timeMapper2;

    @Test
    void testGetTime() throws Exception {
        log.info(timeMapper2.getNow());
    }
}