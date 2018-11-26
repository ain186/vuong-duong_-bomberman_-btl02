package uet.oop.bomberman.entities.character.enemy;


import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.character.enemy.ai.AIOvape;
import uet.oop.bomberman.graphics.Sprite;

public class Ovape extends Enemy {


    public Ovape(int x, int y, Board board) {
        super(x, y, board, Sprite.ovape_dead, Game.getBomberSpeed(), 400);

        _sprite = Sprite.ovape_right1;

        _ai = new AIOvape();
        _direction = _ai.calculateDirection();
    }

    /*
    |--------------------------------------------------------------------------
    | Mob Sprite
    |--------------------------------------------------------------------------
     */
    @Override
    protected void chooseSprite() {
        switch(_direction) {
            case 0:
            case 1:
                if(_moving)
                    _sprite = Sprite.movingSprite(Sprite.ovape_right1, Sprite.ovape_right2, Sprite.ovape_right3, _animate, 60);
                else
                    _sprite = Sprite.ovape_left1;
                break;
            case 2:
            case 3:
                if(_moving)
                    _sprite = Sprite.movingSprite(Sprite.ovape_left1, Sprite.ovape_left2, Sprite.ovape_left3, _animate, 60);
                else
                    _sprite = Sprite.ovape_left1;
                break;
        }
    }
}
