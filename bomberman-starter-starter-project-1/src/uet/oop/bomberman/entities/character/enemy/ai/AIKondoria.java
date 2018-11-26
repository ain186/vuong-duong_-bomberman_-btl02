package uet.oop.bomberman.entities.character.enemy.ai;

public class AIKondoria extends AI {
    // AI di chuyển sang 2 bên
    private int a =0;
    private int d =1;
    @Override
    public int calculateDirection() {
        if( a%40 < 20) {
            d = 1;
        }
        else {
            d = 3;
        }
        a++;
        return d ;
    }
}
