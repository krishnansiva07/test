package log;

import org.apache.log4j.Logger;

public class Log {
	
	// Initialize Log4j instance
		private static Logger Log = Logger.getLogger(Log.class.getName());
		static Logger log = Logger.getLogger("devpinoyLogger");
		
		// We can use it when starting tests
		public static void startLog(String testClassName) {
			log.info("Test is Starting...");
		}

		// We can use it when ending tests
		public static void endLog(String testClassName) {
			log.info("Test is Ending...");
		}

		// Info Level Logs
		public static void info(String message) {
			log.info(message);
		}

		// Warn Level Logs
		public static void warn(String message) {
			log.warn(message);
		}

		// Error Level Logs
		public static void error(String message) {
			log.error(message);
		}

		// Fatal Level Logs
		public static void fatal(String message) {
			log.fatal(message);
		}

		// Debug Level Logs
		public static void debug(String message) {
			log.debug(message);
		}
	
	
	
}
