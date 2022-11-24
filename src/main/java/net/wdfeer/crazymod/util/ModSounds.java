package net.wdfeer.crazymod.util;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.wdfeer.crazymod.CrazyMod;

public class ModSounds {
    public static Identifier MAGIC_STAFF_SOUND_ID = new Identifier(CrazyMod.MOD_ID, "magic_staff_sound");
    public static SoundEvent MAGIC_STAFF_SOUND_EVENT = new SoundEvent(MAGIC_STAFF_SOUND_ID);
    public static void Initialize(){
        Registry.register(Registry.SOUND_EVENT, MAGIC_STAFF_SOUND_ID, MAGIC_STAFF_SOUND_EVENT);
    }
}
