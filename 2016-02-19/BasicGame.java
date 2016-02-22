
public class BasicGame {

	/*
	 * 0 - passage
	 * 1 - wall
	 */
	
	public static void main(String[] args) {
		char[][] map = {{ '1', '1', '1', '1' },
				{ '1', '0', '0', '1' },
				{ '1', '0', '0', '1' },
				{ '1', '1', '1', '1' } };
		
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map.length; y++) {
				System.out.println("Location: " + x + "," + y + " >> " + getBlock(map[x][y]));
			}
		}
	}
	
	/**
	 * Get the block name of the given stored name (used internally)
	 * Serializes an internal value to a human-readable name
	 * 
	 * @param name		Char used internally
	 * @return			Name of the block
	 */
	public static String getBlock(char name) {
		switch (name) {
		case '0':
			return "Passage";
		case '1':
			return "Wall";
		default:
			return null;
		}
	}
}
