package rukuplayz.chatmove.mixin;

import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.ChatHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static rukuplayz.chatmove.client.option.ChatMoveGameOptions.getChatPosX;
import static rukuplayz.chatmove.client.option.ChatMoveGameOptions.getChatPosY;


@Mixin(ChatHud.class)
abstract public class ChatHudMixin implements WindowEventHandler {

    private static double getPosD(double PosOption) {
        int i = 320;
        return (PosOption * 600);
    }
    @Inject(method="render", at=@At(value="INVOKE",
    target = "Lnet/minecraft/client/gui/DrawContext;getMatrices()Lnet/minecraft/client/util/math/MatrixStack;", ordinal = 2))
    public void TranslateAgain(DrawContext context, int currentTick, int mouseX, int mouseY, CallbackInfo ci){
        context.getMatrices().translate(getPosD(getChatPosX().getValue()), -1 * getPosD(getChatPosY().getValue()), 0.0f);
    }

}

