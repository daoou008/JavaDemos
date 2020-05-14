package games.RedPacket;

import java.util.ArrayList;

public class Manager extends User {
    public Manager() {
    }

    public Manager(String name, int money) {
        super(name, money);
    }

    public ArrayList<Integer> send(int red, int number){
        ArrayList<Integer> result = new ArrayList<>();
        if (red > this.getMoney()) {
            System.out.println("余额不足");
        } else {
            int avg = red/number;
            int mod = red%number;
            for (int i = 0; i < number - 1; i++) {
                result.add(avg);
            }
            result.add(avg + mod);
        }
        this.setMoney(this.getMoney() - red);
        return  result;
    }
}
