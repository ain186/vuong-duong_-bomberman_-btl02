package uet.oop.bomberman.level;

import uet.oop.bomberman.Board;
import uet.oop.bomberman.Game;
import uet.oop.bomberman.entities.LayeredEntity;
import uet.oop.bomberman.entities.character.Bomber;
import uet.oop.bomberman.entities.character.enemy.*;
import uet.oop.bomberman.entities.tile.Grass;
import uet.oop.bomberman.entities.tile.Portal;
import uet.oop.bomberman.entities.tile.Wall;
import uet.oop.bomberman.entities.tile.destroyable.Brick;
import uet.oop.bomberman.entities.tile.item.BombItem;
import uet.oop.bomberman.entities.tile.item.FlameItem;
import uet.oop.bomberman.entities.tile.item.SpeedItem;
import uet.oop.bomberman.exceptions.LoadLevelException;
import uet.oop.bomberman.graphics.Screen;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class FileLevelLoader extends LevelLoader {

	/**
	 * Ma trận chứa thông tin bản đồ, mỗi phần tử lưu giá trị kí tự đọc được
	 * từ ma trận bản đồ trong tệp cấu hình
	 */
	private static char[][] _map;
    private static String[] list_level = new String[]{"levels/Level1.txt",
                    "levels/Level2.txt", "levels/Level3.txt", "levels/Levels4.txt"};



	public FileLevelLoader(Board board, int level) throws LoadLevelException {
		super(board, level);
	}
	
	@Override
	public void loadLevel(int level) {


            try{

                String path = list_level[level-1];

			URL absPath = FileLevelLoader.class.getResource("/" + path);

			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(absPath.openStream()));

			String data = bufferedReader.readLine();
			StringTokenizer tokens = new StringTokenizer(data);

			_level = Integer.parseInt(tokens.nextToken());
			_height = Integer.parseInt(tokens.nextToken());
			_width = Integer.parseInt(tokens.nextToken());

			String[] _lineTiles = new String[_height];

			for(int i = 0; i < _height; ++i) {
				_lineTiles[i] = bufferedReader.readLine().substring(0, _width);
			}

			_map = new char[_height][_width];

			for(int i = 0; i < _height; i++ ){
				for( int j = 0; j < _width; j++){
					_map[i][j] = _lineTiles[i].charAt(j);
				}
			}

			bufferedReader.close();


		} catch (Exception e) { // Lỗi e
			e.printStackTrace(); // in ra tên lỗi
		}
	}

    @Override
    public void createEntities() {
        // TODO: tạo các Entity của màn chơi
        // TODO: sau khi tạo xong, gọi _board.addEntity() để thêm Entity vào game

        // TODO: phần code mẫu ở dưới để hướng dẫn cách thêm các loại Entity vào game
        // TODO: hãy xóa nó khi hoàn thành chức năng load màn chơi từ tệp cấu hình
        for (int j = 0; j < _height; j++) {
            for (int i = 0; i < _width; i++) {
                int pos = i + j * _width;
                switch (_map[j][i]) {
                    case '#': // wall
                        _board.addEntity(pos, new Wall(i, j, Sprite.wall));
                        break;

                    case '*': // brick
                        _board.addEntity(pos,
                                new LayeredEntity(i, j,
                                        new Grass(i, j, Sprite.grass),
                                        new Brick(i, j, Sprite.brick)
                                )
                        );
                        break;

                    case 'x': // portal
                        _board.addEntity(pos,
                                new LayeredEntity(i, j,
                                        new Grass(i, j, Sprite.grass),
                                        new Portal(i, j, Sprite.portal,_board),
                                        new Brick(i, j, Sprite.brick)
                                )
                        );
                        break;

                    case 'p': // bomber
                        _board.addCharacter(new Bomber(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));

                        Screen.setOffset(0, 0);

                        _board.addEntity(pos, new Grass(i, j, Sprite.grass));
                        break;

                    case '1': // balloon
                        _board.addCharacter(new Balloon(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));
                        _board.addEntity(pos, new Grass(i, j, Sprite.grass));
                        break;

                    case '2': // oneal
                        _board.addCharacter(new Oneal(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));
                        _board.addEntity(i + j * _width, new Grass(i, j, Sprite.grass));
                        break;

                    case '3': // doll
                        _board.addCharacter(new Doll(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));
                        _board.addEntity(i + j * _width, new Grass(i, j, Sprite.grass));
                        break;

                    case '4': // minvo
                        _board.addCharacter(new Minvo(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));
                        _board.addEntity(i + j * _width, new Grass(i, j, Sprite.grass));
                        break;

                    case '5': // kondoria
                        _board.addCharacter(new Kondoria(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));
                        _board.addEntity(i + j * _width, new Grass(i, j, Sprite.grass));
                        break;

                    case '6' :
                        _board.addCharacter(new Ovape(Coordinates.tileToPixel(i), Coordinates.tileToPixel(j) + Game.TILES_SIZE, _board));
                        _board.addEntity(i + j * _width, new Grass(i, j, Sprite.grass));
                        break;

                    case 'b': // bomb item
                        _board.addEntity(pos,
                                new LayeredEntity(i, j,
                                        new Grass(i, j, Sprite.grass),
                                        new BombItem(i, j, Sprite.powerup_bombs),
                                        new Brick(i, j, Sprite.brick)
                                )
                        );
                        break;
                    case 'f': // flame item
                        _board.addEntity(pos,
                                new LayeredEntity(i, j,
                                        new Grass(i, j, Sprite.grass),
                                        new FlameItem(i, j, Sprite.powerup_flames),
                                        new Brick(i, j, Sprite.brick)
                                )
                        );
                        break;
                    case 's': // speed item
                        _board.addEntity(pos,
                                new LayeredEntity(i, j,
                                        new Grass(i, j, Sprite.grass),
                                        new SpeedItem(i, j, Sprite.powerup_speed),
                                        new Brick(i, j, Sprite.brick)
                                )
                        );
                        break;
                    default:
                        _board.addEntity(pos, new Grass(i, j, Sprite.grass));
                        break;
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return list_level.length;
    }
}
