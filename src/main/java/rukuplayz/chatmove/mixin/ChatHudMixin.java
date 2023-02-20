package rukuplayz.chatmove.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.WindowEventHandler;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.thread.ReentrantThreadExecutor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.option.GameOptions;

import static rukuplayz.chatmove.client.option.ChatMoveGameOptions.getChatPosX;
import static rukuplayz.chatmove.client.option.ChatMoveGameOptions.getChatPosY;


@Mixin(ChatHud.class)
abstract public class ChatHudMixin extends DrawableHelper implements WindowEventHandler { //extends ReentrantThreadExecutor<Runnable>

    private static double getPosD(double PosOption) {
        int i = 320;
        return (PosOption * 600);
    }
    @Inject(method="render", at=@At(value="INVOKE",
    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V", ordinal = 1))
    public void TranslateAgain(MatrixStack matrices, int currentTick, int mouseX, int mouseY, CallbackInfo ci){
        matrices.translate(getPosD(getChatPosX().getValue()), -1 * getPosD(getChatPosY().getValue()), 0.0f);
    }
    /*
    Ignore for now... :)
    @Override
    public void onResolutionChanged() {
        int i = this.window.calculateScaleFactor(this.window.getGuiScale().getValue(), this.forcesUnicodeFont());
        this.window.setScaleFactor(i);
        if (this.currentScreen != null) {
            this.currentScreen.resize(this, this.window.getScaledWidth(), this.window.getScaledHeight());
        }
        Framebuffer framebuffer = this.getFramebuffer();
        framebuffer.resize(this.window.getFramebufferWidth(), this.window.getFramebufferHeight(), IS_SYSTEM_MAC);
        this.gameRenderer.onResized(this.window.getFramebufferWidth(), this.window.getFramebufferHeight());
        this.mouse.onResolutionChanged();
    }
     */
}


//private final SimpleOption<Double> chatWidth = new SimpleOption<Double>("options.chat.width", SimpleOption.emptyTooltip(), (optionText, value) -> GameOptions.getPixelValueText(optionText, ChatHud.getWidth(value)), SimpleOption.DoubleSliderCallbacks.INSTANCE, 1.0, value -> MinecraftClient.getInstance().inGameHud.getChatHud().reset());
