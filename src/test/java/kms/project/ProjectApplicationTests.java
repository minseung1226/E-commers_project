package kms.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class ProjectApplicationTests {

	@Test
	void contextLoads() {

		String a = "010-5564-5417";
		log.info("a.replace={}",a.replace("-",""));
		log.info("a={}" , a);
	}

}
