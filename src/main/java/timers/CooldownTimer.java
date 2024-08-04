package timers;

import com.github.hanyaeger.api.Timer;

import entities.player.Player;

public class CooldownTimer extends Timer{
    private Player player;
    private boolean cooldown = false;
    
    
    public CooldownTimer(long intervalInMs, Player player) {
        super(intervalInMs);
        this.player = player;
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
    	if(cooldown) {
    		cooldown = !cooldown;
    	} 
    }
	
    public void setCooldown(boolean cooldown) {
    	this.cooldown = cooldown;
    }
    
    public boolean getCooldown() {
    	return cooldown;
    }

}
