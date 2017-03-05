package njzgame.interfaces;

public interface Direction {
	public static final int RIGHT = 0;
	public static final int LEFT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public void setDirection(int direction);
	public int getDirection();
}
