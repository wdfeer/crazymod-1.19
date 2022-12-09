package net.wdfeer.crazymod.util;

import net.minecraft.util.math.MathHelper;

import java.util.Random;

public class ExtraMath {
    public static int RandomRound(float f){
        return MathHelper.floor(f) + (new Random().nextFloat() < (f % 1) ? 1 : 0);
    }
}
