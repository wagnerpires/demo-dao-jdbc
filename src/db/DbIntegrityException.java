package db;

public class DbIntegrityException extends RuntimeException {

	private static final long serialVersionUID = -2480251639477580514L;
	
	public DbIntegrityException(String msg) {
		super(msg);
	}
}
