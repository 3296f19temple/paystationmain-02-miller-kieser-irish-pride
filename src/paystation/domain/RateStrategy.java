/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paystation.domain;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Dumpus
 */
public interface RateStrategy {
    
    public int calculateTime(int moneyInserted);
    
}

class alphaTown implements RateStrategy{
   int time;
    
    @Override
    public int calculateTime(int money){
        this.time = (money * 2) / 5;
        return time;
    }
            
}

class betaTown implements RateStrategy{
   int time;
    
    @Override
    public int calculateTime(int money){
        if(money < 150){
            this.time = (money * 2) / 5;
        }
        if(money >= 350){
            this.time = (money - 350)/5 + 120;
        }
        else{
            this.time = (money - 150)*(3/10) + 60;
        }
        return time;
    }
            
}

class gammaTown implements RateStrategy{
    int time;
    
    @Override
    public int calculateTime (int money){
        Date now = new Date();
    
        SimpleDateFormat dayAbrev = new SimpleDateFormat("E");
        
        if(dayAbrev.format(now).equals("Sat") || dayAbrev.format(now).equals("Sun") ){
            this.time = (money * 2) / 5;
        }
        else{
            if(money < 150){
                this.time = (money * 2) / 5;
            }
            if(money >= 350){
                this.time = (money - 350)/5 + 120;
            }
            else{
            this.time = (money - 150)*(3/10) + 60;
            }
        }
        return time;
    }
}
