package rukuplayz.chatmove.mixin;

import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static rukuplayz.chatmove.client.option.ChatMoveGameOptions.chatPosX;
import static rukuplayz.chatmove.client.option.ChatMoveGameOptions.chatPosY;

@Mixin(GameOptions.class)
abstract public class GameOptionsMixin {

    @Inject(method = "accept", at = @At(value = "HEAD"))
    public void function(GameOptions.Visitor visitor, CallbackInfo ci)
    {
        visitor.accept("chatmove.options.chat.pos.x", chatPosX);
        visitor.accept("chatmove.options.chat.pos.y", chatPosY);
    }
}
