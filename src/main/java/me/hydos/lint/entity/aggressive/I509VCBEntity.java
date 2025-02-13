/*
 * Lint
 * Copyright (C) 2020 hYdos, Valoeghese, ramidzkh
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package me.hydos.lint.entity.aggressive;

import me.hydos.lint.bossbar.ModernBossBar;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TextColor;
import net.minecraft.world.World;

public class I509VCBEntity extends HostileEntity implements RangedAttackMob {
	public I509VCBEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
		ModernBossBar.getInstance().setTitle(getDisplayName().shallowCopy().styled(style -> style.withBold(true).withColor(TextColor.fromRgb(0xB41917))));
	}

	public static DefaultAttributeContainer.Builder createAttributes() {
		return LivingEntity.createLivingAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 125)
				.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 12)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 20);
	}

	@Override
	protected void initGoals() {
		this.goalSelector.add(1, new SwimGoal(this));
		this.targetSelector.add(1, new RevengeGoal(this));
		this.goalSelector.add(2, new ProjectileAttackGoal(this, 1.0D, 40, 40.0F));
		this.targetSelector.add(2, new FollowTargetGoal<>(this, PlayerEntity.class, false));
		this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(3, new MeleeAttackGoal(this, 1D, false));
		this.goalSelector.add(5, new WanderAroundFarGoal(this, 1.0D));
	}

	@Override
	public void onStartedTrackingBy(ServerPlayerEntity player) {
		ModernBossBar.getInstance().addPlayer(player);
	}

	@Override
	public void onStoppedTrackingBy(ServerPlayerEntity player) {
		ModernBossBar.getInstance().removePlayer(player);
	}

	@Override
	public void onDeath(DamageSource source) {
		ModernBossBar.getInstance().clear();
	}

	@Override
	public void attack(LivingEntity target, float pullProgress) {
//		target.kill(); //the power of a mod rationer
	}

	@Override
	protected void mobTick() {
		ModernBossBar.getInstance().setEndX(ModernBossBar.calculateEndX(KingTaterEntity.getScaledHealth(getHealth(), getMaxHealth())));
		if (hasStatusEffect(StatusEffects.JUMP_BOOST)) {
			addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, 4, true, true, true, null));
		}
		if (hasStatusEffect(StatusEffects.REGENERATION)) {
			addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0, true, true, true, null));
		}
	}
}
