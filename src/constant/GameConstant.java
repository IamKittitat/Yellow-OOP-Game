package constant;

public class GameConstant {
	
	// PacMan Constant
	public static final String PACMAN_NAME = "PacMan";
	public static final double PACMAN_SPEED = 2;
	public static final int PACMAN_LIFE = 3;
	public static final int PACMAN_SPAWN_X = 36;
	public static final int PACMAN_SPAWN_Y = 36;
	public static final Direction FIRST_PACMAN_DIRECTION = Direction.WEST;
	public static final double PACMAN_RADIUS = 10;

	// Ghost Constant
	public static final String GHOST_NAME = "Ghost";
	public static final double GHOST_SPEED = 2;
	public static final int GHOST_SPAWN_X = 468;
	public static final int GHOST_SPAWN_Y = 156;
	public static final Direction FIRST_GHOST_DIRECTION = Direction.NORTH;
	public static final double GHOST_RADIUS = 10;
	
	// GhostBot Constant
	public static final String GHOST_BOT_NAME = "Ghost";
	public static final int GHOST_BOT_SPEED = 2;
	public static final int GHOST_BOT_SPAWN_X = 468;
	public static final int GHOST_BOT_SPAWN_Y = 204;
	public static final Direction FIRST_GHOST_BOT_DIRECTION = Direction.NORTH;
	public static final double GHOST_BOT_RADIUS = 10;

	// Pellet Constant
	public static final String PELLET_NAME = "Pellet";
	public static final double PELLET_RADIUS = 1.5;
	
	// SpecialPower Constant
	public static final String REVENGE_BUFF_NAME = "REVENGE_BUFF";
	public static final String SHIELD_BUFF_NAME = "SHIELD_BUFF";
	public static final String STARVE_BUFF_NAME = "STARVE_BUFF";
	public static final int DEBUFF_SPEED = 1;
	public static final int REVENGE_BUFF_DURATION = 8;
	public static final int SPEED_BUFF_DURATION = 3;
	public static final int SHIELD_BUFF_DURATION = 4;
	public static final int STARVE_BUFF_DURATION = 6;
	public static final double SPECIAL_POWER_RADIUS = 10;
	public static final double REVENGE_POWER_RADIUS = 3;

	// Map Constant
	public static final int WARP_POINT_1_X = 468;
	public static final int WARP_POINT_1_Y = -12;
	public static final int WARP_POINT_2_X = 468;
	public static final int WARP_POINT_2_Y = 444;
	
	// Game Constant
	public static final int BUFF_SPAWN_DURATION = 6;
	public static final int BUFF_DISSAPEAR_TIME = 5;

	
	// GUI Constant
	public static final int SCREEN_SIZE_WIDTH = 900;
	public static final int SCREEN_SIZE_HEIGHT = 500;
	public static final int SCREEN_PLAY_WIDTH = 37;
	public static final int SCREEN_PLAY_HEIGHT = 17;
	public static final int BLOCK_SIZE = 24;
}
