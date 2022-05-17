package constant;

public class GameConstant {
	// Not final value of constant
	public static final String PACMAN_NAME = "PacMan";
	public static final String PACMAN_DETAIL = "The PacMan";
	public static final double PACMAN_SPEED = 2;
	public static final int PACMAN_LIFE = 3;
	public static final int PACMAN_SPAWN_X = 36;
	public static final int PACMAN_SPAWN_Y = 36;
	public static final Direction FIRST_PACMAN_DIRECTION = Direction.WEST;
	public static final double PACMAN_RADIUS = 10;

	public static final String GHOST_NAME = "Ghost";
	public static final String GHOST_DETAIL = "The BoogeyMan";
	public static final double GHOST_SPEED = 2;
//	public static final int GHOST_SPAWN_X = 468;
//	public static final int GHOST_SPAWN_Y = 156;
	public static final int GHOST_SPAWN_X = 60;
	public static final int GHOST_SPAWN_Y = 36;
	public static final Direction FIRST_GHOST_DIRECTION = Direction.NORTH;
	public static final double GHOST_RADIUS = 10;

	public static final String GHOST_BOT_NAME = "Ghost";
	public static final String GHOST_BOT_DETAIL = "The BoogeyMan";
	public static final int GHOST_BOT_SPEED = 2;
	public static final int GHOST_BOT_SPAWN_X = 60;
	public static final int GHOST_BOT_SPAWN_Y = 36;
	public static final Direction FIRST_GHOST_BOT_DIRECTION = Direction.NORTH;
	public static final double GHOST_BOT_RADIUS = 10;

	public static final String PELLET_NAME = "Pellet";
	public static final String PELLET_DETAIL = "THE Pellet";
	public static final double PELLET_RADIUS = 2.5;

	public static final int TOTAL_PELLET = 100;
	public static final String REVENGE_BUFF_NAME = "REVENGE_BUFF";
	public static final String REVENGE_BUFF_DETAIL = "THE REVENGE_BUFF";
	public static final String SPEED_BUFF_NAME = "SPEED_BUFF";
	public static final String SPEED_BUFF_DETAIL = "THE SPEED_BUFF";
	public static final String SHIELD_BUFF_NAME = "SHIELD_BUFF";
	public static final String SHIELD_BUFF_DETAIL = "THE SHIELD_BUFF";
	public static final String STARVE_BUFF_NAME = "STARVE_BUFF";
	public static final String STARVE_BUFF_DETAIL = "THE STARVE_BUFF";
	public static final int BUFF_SPEED = 3;
	public static final int DEBUFF_SPEED = 1;
	public static final int BUFF_SPAWN_TIME = 5;
	public static final int REVENGE_BUFF_DURATION = 3;
	public static final int SPEED_BUFF_DURATION = 3;
	public static final int SHIELD_BUFF_DURATION = 3;
	public static final int STARVE_BUFF_DURATION = 3;

	public static final int GAME_TIMER = 600;

	public static final int SCREEN_SIZE_WIDTH = 900;
	public static final int SCREEN_SIZE_HEIGHT = 500;
	public static final int SCREEN_PLAY_WIDTH = 37;
	public static final int SCREEN_PLAY_HEIGHT = 17;
}
