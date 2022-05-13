package constant;

public class GameConstant {
	// Not final value of constant
	public static final int PACMAN_SPEED = 1;
	public static final int PACMAN_LIFE = 3;
	public static final int PACMAN_SPAWN_X = 10;
	public static final int PACMAN_SPAWN_Y = 10;
	public static final Direction FIRST_PACMAN_DIRECTION = Direction.WEST;

	public static final int GHOST_SPEED = 1;
	public static final int GHOST_SPAWN_X = 50;
	public static final int GHOST_SPAWN_Y = 50;
	public static final Direction FIRST_GHOST_DIRECTION = Direction.NORTH;
	
	public static final int BUFF_SPEED = 1;
	public static final int DEBUFF_SPEED = -1;
	public static final int BUFF_SPAWN_TIME = 5;
	public static final int REVENGE_BUFF_DURATION = 8;
	public static final int SPEED_BUFF_DURATION = 7;
	public static final int SHIELD_BUFF_DURATION = 7;
	public static final int STARVE_BUFF_DURATION = 7;

	public static final int GAME_TIMER = 600;

	public static final int SCREEN_SIZE_WIDTH = 900;
	public static final int SCREEN_SIZE_HEIGHT = 500;

}
