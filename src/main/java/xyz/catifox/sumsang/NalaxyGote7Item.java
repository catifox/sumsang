package xyz.catifox.sumsang;


import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NalaxyGote7Item extends Item {
    public NalaxyGote7Item() {
        super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(16).rarity(Rarity.COMMON));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemStack = player.getItemInHand(interactionHand);
        float explosivePower = Configuration.explosivePower; //爆炸威力
        int poisonTime = Configuration.poisonTime;//药水时间
        Map<String, Object> dependencies = new HashMap<>();
        dependencies.put("entity", player);
        Entity entity = (Entity) dependencies.get("entity");

        if (!level.isClientSide) {
            Explosion.BlockInteraction blockInteraction = level.getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING) ? Explosion.BlockInteraction.DESTROY : Explosion.BlockInteraction.NONE;
            level.explode(null, player.getX(), player.getY(), player.getZ(), explosivePower / 7, true,blockInteraction);//爆炸时起火
        }

        if (!Configuration.rightClickDetonator) {   //右键爆炸如果为 false 就 pass
            return InteractionResultHolder.pass(itemStack);
        }

        if (!player.getAbilities().instabuild) {    //玩家不是创造时，右键减少1个
            itemStack.shrink(1);
        }

        if (Configuration.poisonOnDetonate && poisonTime > 0) {
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 20 * poisonTime));//添加效果
        }

        if (explosivePower > 0) {
            if (entity instanceof ServerPlayer _player) {//添加成就
                Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sumsang:detonate"));
                AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                if (!_ap.isDone()) {
                    Iterator _iterator = _ap.getRemainingCriteria().iterator();
                    while (_iterator.hasNext())
                        _player.getAdvancements().award(_adv, (String) _iterator.next());
                }
            }

            if (explosivePower > 9000) {
                if (entity instanceof ServerPlayer _player) {//添加成就
                    Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("sumsang:over_9000"));
                    AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
                    if (!_ap.isDone()) {
                        Iterator _iterator = _ap.getRemainingCriteria().iterator();
                        while (_iterator.hasNext())
                            _player.getAdvancements().award(_adv, (String) _iterator.next());
                    }
                }
            }
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide());
    }
}
