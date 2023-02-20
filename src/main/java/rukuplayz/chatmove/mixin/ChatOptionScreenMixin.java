package rukuplayz.chatmove.mixin;

import net.minecraft.client.gui.screen.option.ChatOptionsScreen;
import net.minecraft.client.option.SimpleOption;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import rukuplayz.chatmove.client.option.ChatMoveGameOptions;
@Mixin(ChatOptionsScreen.class)
public class ChatOptionScreenMixin {
    @ModifyArg(method = "<init>", at = @At(value = "INVOKE",
            target = "Lnet/minecraft/client/gui/screen/option/SimpleOptionsScreen;<init>(Lnet/minecraft/client/gui/screen/Screen;Lnet/minecraft/client/option/GameOptions;Lnet/minecraft/text/Text;[Lnet/minecraft/client/option/SimpleOption;)V"), index = 3)
    private static SimpleOption[] injected(SimpleOption[] x) {
            SimpleOption[] noice = new SimpleOption[x.length + 2];
            for (int i = 0; i <x.length; i++){
                noice[i] = x[i];
            }
            noice[x.length] = ChatMoveGameOptions.getChatPosX();
            noice[x.length + 1] = ChatMoveGameOptions.getChatPosY();
        return noice;
    }
}
