package uet.oop.bomberman.entities.character.enemy.ai;

public class AIBalloon extends AI {

	@Override
	public int calculateDirection() {
		// TODO: cài đặt thuật toán tìm đường đi
		return random.nextInt(4);
	}

}
