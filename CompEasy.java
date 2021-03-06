import java.util.List;
import java.util.Random;

public class CompEasy extends Comp {

    Random random; 

    public CompEasy() {
        random = new Random();
    }

    @Override
    public <Squer> void hit(Player enemy) {

        int rand1 = random.nextInt(9);
        int rand2 = random.nextInt(9);
        
        List<Square> lines = enemy.playerBoard.getSquere().get(rand2);
        Square shot = lines.get(rand1);
        
        List<Square> linesEnemy = playerBoard.getEnemySquere().get(rand2);
        Square shotEnemy = linesEnemy.get(rand1);

        //List<List<Square>> linesEnemy = playerBoard.getEnemySquere();
        if(shotEnemy.toString().equals("X")){
            hit(enemy);
        }
        else if(shot.toString().equals("X")){
            shotEnemy.redMark();
            removeFromList(rand1, rand2, enemy);
        }else if(shot.toString().equals("O")) {
            hit(enemy);    
        }else{
            shot.empty();
            shotEnemy.empty();
        }


    }
    
}