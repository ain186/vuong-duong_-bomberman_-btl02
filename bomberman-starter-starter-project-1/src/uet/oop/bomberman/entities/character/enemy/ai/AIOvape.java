package uet.oop.bomberman.entities.character.enemy.ai;

public class AIOvape extends AI {
    // AI di chuyển trên dưới
    private int a =0;
    private int d =1;
    @Override
    public int calculateDirection() {
        if( a%40 < 20) {
            d = 0;
        }
        else {
            d = 2;
        }
        a++;
        return d ;
    }
}
