package JavaStandard.ch13;

public class ThreadEx9 {

    public static void main(String[] args) {

        ThreadGroup main = Thread.currentThread().getThreadGroup();
        ThreadGroup grp1 = new ThreadGroup("Group1");
        ThreadGroup grp2 = new ThreadGroup("Group2");

        //m ThreadGroup( 스레드 그룹 부모, 이름)
        ThreadGroup subGrp1 = new ThreadGroup(grp1, "subGroup1");

        grp1.setMaxPriority(3); //m 쓰레드 그룹 grp1의 최대 우선순위를 3으로 변경.

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000); // 스레드를 1초간 멈추게 한다.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // ThreadGroup( targetGroup, Runnable, name)
        new Thread(grp1, r, "th1").start();
        new Thread(subGrp1, r, "th2").start();
        new Thread(grp2, r, "th3").start();

        System.out.println(">>List of ThreadGroup : " + main.getName()
                + ", Active ThreadGroup: " + main.activeGroupCount() + " Active Thread:" + main.activeGroupCount());

        main.list(); //m 스레드 그룹에 속한 쓰레드와 하위 쓰레드 그룹에 대한 정보를 출력한다.

    }

}
