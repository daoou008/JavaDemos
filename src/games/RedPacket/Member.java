package games.RedPacket;

import java.util.ArrayList;
import java.util.Random;

public class Member extends User {
    public Member() {
    }

    public Member(String name, int money) {
        super(name, money);
    }

    public void receive(ArrayList<Integer> redList) {
        int re = 0;
        if (null != redList) {
            Random r = new Random();
            int rIndex = r.nextInt(redList.size());
            int getMoney = redList.get(rIndex);
            this.setMoney(getMoney);
            redList.remove(rIndex);
        }
    }
}
