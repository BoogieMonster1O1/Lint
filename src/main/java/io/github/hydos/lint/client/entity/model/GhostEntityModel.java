package io.github.hydos.lint.client.entity.model;

import io.github.hydos.lint.entity.aggressive.GhostEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class GhostEntityModel extends EntityModel<GhostEntity> {

	private final ModelPart ghost;
	private final ModelPart wavyBits;

	public GhostEntityModel() {
		textureWidth = 32;
		textureHeight = 32;

		ghost = new ModelPart(this);
		ghost.setPivot(7.0F, 16.0F, -8.0F);
		ghost.setTextureOffset(0, 0).addCuboid(-16.0F, -32.0F, 0.0F, 16.0F, 32.0F, 16.0F, 0.0F, false);

		wavyBits = new ModelPart(this);
		wavyBits.setPivot(0.0F, 0.0F, 0.0F);
		ghost.addChild(wavyBits);
		wavyBits.setTextureOffset(0, 0).addCuboid(-2.0F, 0.0F, 3.4F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-16.0F, 0.0F, 3.4F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-2.0F, 0.0F, 7.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-16.0F, 0.0F, 7.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-2.0F, 0.0F, 10.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-16.0F, 0.0F, 10.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-2.0F, 0.0F, 14.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits.setTextureOffset(0, 0).addCuboid(-16.0F, 0.0F, 14.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelPart wavyBits2 = new ModelPart(this);
		wavyBits2.setPivot(-8.0F, 1.0F, 1.0F);
		wavyBits.addChild(wavyBits2);
//		setRotationAngle(wavyBits2, 0.0F, -1.5708F, 0.0F);
		wavyBits2.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, 6.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits2.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, 2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits2.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits2.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -4.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits2.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -8.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);

		ModelPart wavyBits3 = new ModelPart(this);
		wavyBits3.setPivot(-8.0F, 1.0F, 15.0F);
		wavyBits.addChild(wavyBits3);
//		setRotationAngle(wavyBits3, 0.0F, -1.5708F, 0.0F);
		wavyBits3.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, 2.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits3.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		wavyBits3.setTextureOffset(0, 0).addCuboid(-1.0F, -1.0F, -4.6F, 2.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void setAngles(GhostEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
		
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
		ghost.render(matrices, vertices, light, overlay, red, green, blue, alpha);
		wavyBits.render(matrices, vertices, light, overlay, red, green, blue, alpha);
	}
}
