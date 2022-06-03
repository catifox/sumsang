package xyz.catifox.sumsang;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.include.com.google.common.base.Optional;

//public class Advancement extends SimpleCriterionTrigger{

//    public static boolean grantAdvancement(PlayerEntity player, ResourceLocation id) {
//        if (player instanceof ServerPlayerEntity) {
//            return getAdvancement(player.getServer(), id)
//                    .map(advancement -> grantAdvancement((ServerPlayerEntity) player, advancement))
//                    .orElse(false);
//        }
//
//        return false;
//    }
//
//    public static boolean grantAdvancement(ServerPlayerEntity player, Advancement advancement) {
//        if (advancement.getCriteria().size() != 1 || !advancement.getCriteria().containsKey("impossible")) {
//            return false;
//        }
//
//        return player.getAdvancements().grantCriterion(advancement, "impossible");
//    }
//
//    public static Optional<Advancement> getAdvancement(MinecraftServer server, ResourceLocation id) {
//        if (server != null && id != null) {
//            return Optional.ofNullable(server.getAdvancementManager().getAdvancement(id));
//        }
//
//        return Optional.empty();
//    }
//}
