package db;

public class DbException extends RuntimeException {

	private static final long serialVersionUID = -2740818330288114689L;
	
	public DbException(String msg) {
		super(msg);
	}
}
