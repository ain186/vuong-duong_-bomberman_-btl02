package uet.oop.bomberman.entities.character.enemy.ai;

public class AIMinvo extends AI{

    //  AI di chuyển sang 2 bên ngẫu nhiên
    @Override
    public int calculateDirection() {
        int d = random.nextInt(4);
        if( d == 0){
            return 1;
        }
        if( d == 2){
            return 3;
        }
        return d ;
    }
}
