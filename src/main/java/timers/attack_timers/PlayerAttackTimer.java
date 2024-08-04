package timers.attack_timers;

import com.github.hanyaeger.api.Timer;
import entities.weapons.Weapon;
import entities.weapons.ranged.RangedWeapon;

public class PlayerAttackTimer extends Timer {
    protected Weapon weapon;
    /**
     * Create a new instance of {@link Timer} for the given interval in milliseconds.
     *
     * @param intervalInMs the interval in milliseconds
     */
    protected boolean isAttacking = false;


    public PlayerAttackTimer(long intervalInMs) {
        super(intervalInMs);
    }

    @Override
    public void onAnimationUpdate(long timestamp) {
        if (weapon != null) {
            if (isAttacking) {
                weapon.setVisible(true);
                if (weapon instanceof RangedWeapon) {
                    ((RangedWeapon) weapon).fireArrow();
                }
                isAttacking = false;
            } else {
                weapon.setVisible(false);
            }
        }
    }

    public void Attack(Weapon weapon) {
        this.weapon = weapon;
        isAttacking = true;
    }
}
