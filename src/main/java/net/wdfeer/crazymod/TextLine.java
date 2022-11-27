package net.wdfeer.crazymod;

import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public record TextLine(String text, Formatting formatting) {
    public static void addLines(List<Text> tooltip, TextLine[] lines){
        for (TextLine l : lines) {
            addTooltipLine(tooltip, l.text(), l.formatting());
        }
    }
    public static void addTooltipLine(List<Text> tooltip, String str, Formatting formatting) {
        Text t = Text.of(str);
        t = t.getWithStyle(t.getStyle().withColor(formatting)).get(0);
        tooltip.add(t);
    }
}
