package xyz.catifox.sumsang;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static net.minecraft.world.explosion.Explosion.DestructionType.DESTROY;

public class NalaxyGote7Item extends Item {
    public NalaxyGote7Item(Item.Settings settings) {
        super(settings);
    }

    /*右键后会发生什么？
    - 成就，这东西可以按照数据包触发器来做
    - 爆炸
    - 中毒 */

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        float explosivePower = Configuration.explosivePower; //爆炸威力
        int poisonTime = Configuration.poisonTime;//药水时间

        if (!world.isClient) {
            world.createExplosion(null, user.getX(), user.getY() - 0.5, user.getZ(), (explosivePower / 7), true, DESTROY);//右键爆炸
        }

        if (!Configuration.rightClickDetonator) {   //右键爆炸如果为 false 就 pass
            return TypedActionResult.pass(itemStack);
        }

        if (!user.getAbilities().creativeMode) {    //玩家不是创造时，右键减少1个
            itemStack.decrement(1);
        }

        if (Configuration.poisonOnDetonate && poisonTime > 0) {
            user.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 20 * poisonTime));//添加效果
        }

        if (explosivePower > 0) {
            //爆炸成就todo
            if (explosivePower > 9000) {
                //9000成就todo
            }
        }

        return TypedActionResult.success(itemStack);
    }
}
   /* @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) { //右键事件
        ItemStack itemStack = player.getHeldItem(hand);//手持物品
        if (world.isRemote || !Sumsang.getInstance().getConfiguration().getRightClickDetonator().get()) {   //如果是remote并且右键爆炸为false就pass
            return new ActionResult<>(ActionResultType.PASS, itemStack);
        }

        if (!player.isCreative()) { //玩家不是创造时，右键减少1个
            itemStack.shrink(1);
        }

        float explosivePower = Sumsang.getInstance().getConfiguration().getExplosivePower().get();
        if (explosivePower > 0) {//爆炸伤害大于0时
            Toolbox.grantAdvancement(player, DETONATE_ADVANCEMENT);//获得爆炸成就
            if (explosivePower > 9000) {//爆炸伤害大于9000时
                Toolbox.grantAdvancement(player, OVER_9000_ADVANCEMENT);//9000成就
            }

            BlockPos position = player.getPosition();//玩家位置取得
            world.createExplosion(null, position.getX(), position.getY(), position.getZ(), (explosivePower / 10), true, Explosion.Mode.DESTROY);//在玩家位置爆炸 Destroy模式
        }

        int poisonTime = Sumsang.getInstance().getConfiguration().getPoisonTime().get(); //中毒时间
        if (Sumsang.getInstance().getConfiguration().getPoisonOnDetonate().get() && poisonTime > 0) {//打开中毒且事件大于0
            player.addPotionEffect(new EffectInstance(Effects.POISON, (20 * poisonTime), 0));//中毒时间
        }

        return new ActionResult<>(ActionResultType.SUCCESS, itemStack);//action完成
*/






