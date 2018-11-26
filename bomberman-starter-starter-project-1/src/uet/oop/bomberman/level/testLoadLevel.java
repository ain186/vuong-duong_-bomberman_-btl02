package uet.oop.bomberman.level;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.StringTokenizer;

public class testLoadLevel {
    static char[][] _map;
    static int level = 1;
    static int _level;
    static int _height;
    static int _width;

    public static void main(String[] args) {

        String[] list_level = {"levels/Level1.txt",
                "levels/Level2.txt"};
        String path = list_level[level -1];
        try{
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
        for(int i=0; i<_height; i++){
            for(int j=0; j<_width; j++){
                System.out.print(_map[i][j]);
            }
            System.out.println();
        }
    }
}
