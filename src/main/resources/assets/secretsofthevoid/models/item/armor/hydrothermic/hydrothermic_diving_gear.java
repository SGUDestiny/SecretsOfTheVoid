// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class hydrothermic_gear<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "hydrothermic_gear"), "main");
	private final ModelPart flippers;
	private final ModelPart flipper_right;
	private final ModelPart flipper_left;
	private final ModelPart leggings;
	private final ModelPart legging_right;
	private final ModelPart legging_left;
	private final ModelPart rebreather;
	private final ModelPart gloves;
	private final ModelPart glove_right;
	private final ModelPart glove_left;
	private final ModelPart backtank;

	public hydrothermic_gear(ModelPart root) {
		this.flippers = root.getChild("flippers");
		this.flipper_right = root.getChild("flipper_right");
		this.flipper_left = root.getChild("flipper_left");
		this.leggings = root.getChild("leggings");
		this.legging_right = root.getChild("legging_right");
		this.legging_left = root.getChild("legging_left");
		this.rebreather = root.getChild("rebreather");
		this.gloves = root.getChild("gloves");
		this.glove_right = root.getChild("glove_right");
		this.glove_left = root.getChild("glove_left");
		this.backtank = root.getChild("backtank");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition flippers = partdefinition.addOrReplaceChild("flippers", CubeListBuilder.create(), PartPose.offset(1.0F, 24.0F, 3.0F));

		PartDefinition flipper_right = flippers.addOrReplaceChild("flipper_right", CubeListBuilder.create().texOffs(56, 0).mirror().addBox(-5.0F, 0.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 18).mirror().addBox(-3.0F, -6.0F, -3.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 8).mirror().addBox(-3.0F, -6.0F, -3.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 28).addBox(-2.0F, -10.0F, 1.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(70, 26).mirror().addBox(-1.0F, -5.0F, 2.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-1.9F, 0.0F, -2.0F));

		PartDefinition flipper_left = flippers.addOrReplaceChild("flipper_left", CubeListBuilder.create().texOffs(56, 0).addBox(-3.0F, 0.0F, -11.0F, 8.0F, 0.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(64, 18).addBox(-1.0F, -6.0F, -3.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 8).addBox(-1.0F, -6.0F, -3.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(64, 28).mirror().addBox(0.0F, -10.0F, 1.0F, 2.0F, 10.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(70, 26).addBox(1.0F, -5.0F, 2.0F, 0.0F, 5.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.1F, 0.0F, -2.0F));

		PartDefinition leggings = partdefinition.addOrReplaceChild("leggings", CubeListBuilder.create().texOffs(64, 49).addBox(-1.0F, -2.0F, -1.0F, 8.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(-3.0F, 13.0F, -1.0F));

		PartDefinition legging_right = leggings.addOrReplaceChild("legging_right", CubeListBuilder.create().texOffs(64, 39).mirror().addBox(-3.0F, -2.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(2.1F, 1.0F, 0.0F));

		PartDefinition legging_left = leggings.addOrReplaceChild("legging_left", CubeListBuilder.create().texOffs(64, 39).addBox(-1.0F, -2.0F, -1.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(3.9F, 1.0F, 0.0F));

		PartDefinition rebreather = partdefinition.addOrReplaceChild("rebreather", CubeListBuilder.create().texOffs(24, 107).addBox(-3.0F, -8.2563F, 4.2438F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 100).addBox(-3.0F, -9.2563F, 2.2438F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 87).addBox(-4.0F, -10.2563F, -4.7562F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(24, 73).addBox(-5.0F, -9.2563F, -0.7562F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 104).addBox(1.0F, -8.2563F, 4.2438F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(24, 96).addBox(1.0F, -9.2563F, 2.2438F, 2.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
		.texOffs(24, 78).addBox(1.0F, -10.2563F, -4.7562F, 3.0F, 2.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(24, 110).addBox(-3.0F, -6.2563F, 4.2438F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 64).addBox(-3.0F, -9.2563F, -0.7562F, 6.0F, 2.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(24, 68).addBox(3.0F, -9.2563F, -0.7562F, 2.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 94).addBox(-4.0F, -6.2563F, -4.7562F, 8.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(0, 110).addBox(-6.0F, -6.2563F, -1.7562F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 100).addBox(3.0F, -6.2563F, -1.7562F, 3.0F, 6.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 74).addBox(-5.0F, -1.2563F, -4.7562F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 70).mirror().addBox(-5.0F, -1.2563F, 3.2438F, 10.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 84).addBox(3.0F, -1.2563F, -4.7562F, 2.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 64).addBox(-3.0F, -1.2563F, -5.7562F, 6.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.2563F, -0.2438F));

		PartDefinition gloves = partdefinition.addOrReplaceChild("gloves", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition glove_right = gloves.addOrReplaceChild("glove_right", CubeListBuilder.create().texOffs(36, 33).mirror().addBox(-3.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(48, 48).mirror().addBox(-3.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-5.0F, -12.0F, 1.0F));

		PartDefinition pad_r1 = glove_right.addOrReplaceChild("pad_r1", CubeListBuilder.create().texOffs(22, 52).mirror().addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-1.5F, -12.0F, -1.0F, 0.0F, 0.0F, -0.3927F));

		PartDefinition glove_left = gloves.addOrReplaceChild("glove_left", CubeListBuilder.create().texOffs(36, 33).addBox(-1.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(48, 48).addBox(-1.0F, -12.0F, -3.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(5.0F, -12.0F, 1.0F));

		PartDefinition pad_r2 = glove_left.addOrReplaceChild("pad_r2", CubeListBuilder.create().texOffs(22, 52).addBox(-2.5F, -1.0F, -2.0F, 5.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -12.0F, -1.0F, 0.0F, 0.0F, 0.3927F));

		PartDefinition backtank = partdefinition.addOrReplaceChild("backtank", CubeListBuilder.create().texOffs(0, 28).addBox(-6.0F, -18.0F, -3.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(12, 23).mirror().addBox(-7.0F, -17.0F, -4.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 23).mirror().addBox(-2.0F, -17.0F, -4.0F, 3.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(-8.0F, -15.0F, -5.0F, 10.0F, 18.0F, 5.0F, new CubeDeformation(0.0F))
		.texOffs(28, 17).addBox(-9.0F, -11.0F, -5.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(30, 0).addBox(-6.0F, -12.0F, 0.0F, 6.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(0, 45).addBox(-7.0F, -12.0F, -9.0F, 8.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
		.texOffs(0, 33).addBox(-9.0F, -11.0F, -5.0F, 12.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 12.0F, 7.0F));

		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		flippers.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		leggings.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rebreather.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		gloves.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		backtank.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}