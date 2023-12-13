package testPackage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TEstClass {
	Logger log = (Logger) LogManager.getLogger();
	@Test
	public void testt()
	{
		
		
		log.info("TEST info");
		log.warn("TEST warn");
		log.debug("TEST debug");
		log.error("TEST error");
		log.fatal("TEST fatal");
	}

}
