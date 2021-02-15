package JavaStandard.ch07.Interface;

public class RepairableTest {
    public static void main(String[] args) {
       Tank tank = new Tank();
       Dropship dropship = new Dropship();

       Marin marin = new Marin();
       SCV scv = new SCV();

       scv.repair(tank);
       scv.repair(marin);
       scv.repair(dropship);
    }
}

interface Repairable{}

class Unit {
    int hitPoint;
    final int MAX_HP;
    Unit(int hp) {
        MAX_HP = hp;
    }
}

class GroundUnit extends Unit{
    GroundUnit(int hp) {
        super(hp);
    }
}
class AirUnit extends Unit{
    AirUnit(int hp) {
        super(hp);
    }
}

class Tank extends GroundUnit implements Repairable{

    Tank() {
        super(150); //m Tank의 HP 는 150이다.
        hitPoint = MAX_HP;
    }

    @Override
    public String toString() {
        return "Tank";
    }
}

class Dropship extends AirUnit implements Repairable{

    public Dropship() {
        super(125);
        hitPoint = MAX_HP;
    }


    @Override
    public String toString() {
        return "Dropship";
    }
}
class Marin extends AirUnit implements Repairable{

    public Marin() {
        super(40);
        hitPoint = MAX_HP;
    }

    @Override
    public String toString() {
        return "Marin";
    }
}

class SCV extends GroundUnit implements Repairable{

    public SCV() {
        super(60);
        hitPoint = MAX_HP;
    }

    void repair(Repairable r){
        if( r instanceof  Unit){
            Unit u = (Unit)r;

            while(u.hitPoint != u.MAX_HP){
                /* Unit의 HP를 증가시킨다. */
                u.hitPoint++;
            }
            System.out.println( u.toString() + "의 수리가 끝났습니다.");
        }
    }
}