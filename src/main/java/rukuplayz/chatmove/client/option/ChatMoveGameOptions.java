package rukuplayz.chatmove.client.option;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.option.GameOptions;
import net.minecraft.util.math.MathHelper;

public class ChatMoveGameOptions {
    public static int getPos(double PosOption) {
        int i = 320;
        return MathHelper.floor(PosOption * 600);
    }


    private final static SimpleOption<Double> chatPosX = new SimpleOption<Double>("chatmove.options.chat.pos.x", SimpleOption.emptyTooltip(), (optionText, value) -> GameOptions.getGenericValueText(optionText, getPos(value)), SimpleOption.DoubleSliderCallbacks.INSTANCE, 0.0, value -> MinecraftClient.getInstance().inGameHud.getChatHud().reset());
    private final static SimpleOption<Double> chatPosY = new SimpleOption<Double>(".chatmove.options.chat.pos.y", SimpleOption.emptyTooltip(), (optionText, value) -> GameOptions.getGenericValueText(optionText, getPos(value)), SimpleOption.DoubleSliderCallbacks.INSTANCE, 0.0, value -> MinecraftClient.getInstance().inGameHud.getChatHud().reset());

    public static SimpleOption<Double> getChatPosX() {
        return chatPosX;
    }
    public static SimpleOption<Double> getChatPosY() {
        return chatPosY;
    }
}

//GameOptions.getPixelValueText(optionText, ChatHud.getWidth(value))