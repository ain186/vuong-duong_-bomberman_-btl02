package uet.oop.bomberman.entities.character.enemy.ai;

public class AIDoll extends AI{


    // AI di chuyển sang 2 bên ngẫu nhiên
//    @Override
//    public int calculateDirection() {
//        int d = random.nextInt(4);
//        if( d == 0){
//            return 1;
//        }
//        if( d == 2){
//            return 3;
//        }
//        return d ;
//    }


    // AI di chuyển sang 2 bên
//    private int a =0;
////    private int d =1;
////    @Override
////    public int calculateDirection() {
////        if( a%28 < 14) {
////            d = 1;
////        }
////        else {
////            d = 3;
////        }
////        a++;
////        return d ;
////    }

    // di chuyển vòng tròn quanh portal, vị trí khỏi tạo 0
    private int a = 0;
    private int d = 1;
    @Override
    public int calculateDirection() {
        switch (a%8){
            case 0 :
            case 1 :
                d = 1;
                break;
            case 2 :
            case 3 :
                d = 2;
                break;
            case 4 :
            case 5 :
                d = 3;
                break;
            default:
                d = 0;
                break;
        }
        a++;
        return d;
    }

}
