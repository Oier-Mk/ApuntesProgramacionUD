package Logger;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggerEx {
	
	private static Logger logger;

	
	public static void main(String[] args) {
		
		logger = creacionDeLogger("src/Logger/LoggerEx.txt", Level.FINEST);
		
		logger.log( Level.SEVERE, " Error SEVERE " );
		logger.log( Level.WARNING, " Error WARNING " );
		logger.log( Level.INFO, " Error INFO " );
		logger.log( Level.CONFIG, " Error CONFIG " );
		logger.log( Level.FINE, " Error FINE " );
		logger.log( Level.FINER, " Error FINER " );
		logger.log( Level.FINEST, " Error FINEST " );

	
	}
	
	
	public static Logger creacionDeLogger(String path, Level level) {
		try {
			Handler h = new FileHandler( path, false );
			logger = Logger.getLogger( "loggerOutput" );
			logger.addHandler( h );
			logger.setLevel( level );  
			h.setLevel( level );  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return logger;		
	}	 

}
