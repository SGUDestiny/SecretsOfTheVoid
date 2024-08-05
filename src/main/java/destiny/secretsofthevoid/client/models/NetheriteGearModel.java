package destiny.secretsofthevoid.client.models;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import destiny.secretsofthevoid.client.Layers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class NetheriteGearModel extends HumanoidModel<LivingEntity>
{
    public static NetheriteGearModel INSTANCE;

    public NetheriteGearModel(ModelPart root)
    {
        super(root);
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
        PartDefinition root = mesh.getRoot();

        PartDefinition head = root.getChild("head");
        PartDefinition body = root.getChild("body");

        //Scuba
        head.addOrReplaceChild("scuba", CubeListBuilder.create()
                .texOffs(30, 30)
                .addBox(-3.0F, -29.0F, -5.0F, 6.0F, 4.0F, 1.0F,
                        new CubeDeformation(0.0F))
                .texOffs(30, 0)
                .addBox(-3.0F, -25.0F, -6.0F, 6.0F, 3.0F, 3.0F,
                        new CubeDeformation(0.0F))
                .texOffs(30, 10)
                .addBox(-5.0F, -25.0F, -5.0F, 2.0F, 2.0F, 8.0F,
                        new CubeDeformation(0.0F))
                .texOffs(30, 20).
                addBox(3.0F, -25.0F, -5.0F, 2.0F, 2.0F, 8.0F,
                        new CubeDeformation(0.0F))
                .texOffs(30, 6)
                .mirror().addBox(-5.0F, -25.0F, 3.0F, 10.0F, 2.0F, 2.0F,
                        new CubeDeformation(0.0F))
                .mirror(false)
                .texOffs(30, 45)
                .addBox(-6.0F, -30.0F, -2.0F, 3.0F, 6.0F, 4.0F,
                        new CubeDeformation(0.0F))
                .texOffs(30, 35)
                .addBox(3.0F, -30.0F, -2.0F, 3.0F, 6.0F, 4.0F,
                        new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        //Double Backtank
        body.addOrReplaceChild("tank", CubeListBuilder.create()
                .texOffs(0, 21)
                .addBox(1.0F, -16.0F, -2.0F, 6.0F, 1.0F, 1.0F,
                        new CubeDeformation(0.0F))
                .texOffs(12, 16)
                .mirror()
                .addBox(0.0F, -15.0F, -3.0F, 3.0F, 2.0F, 3.0F,
                        new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 16)
                .mirror()
                .addBox(5.0F, -15.0F, -3.0F, 3.0F, 2.0F, 3.0F,
                        new CubeDeformation(0.0F)).mirror(false)
                .texOffs(0, 0)
                .addBox(-1.0F, -13.0F, -4.0F, 10.0F, 11.0F, 5.0F,
                        new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(0.0F, -2.0F, -4.0F, 8.0F, 3.0F, 3.0F,
                        new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-1.25F, -13.25F, -4.25F, 10.5F, 11.5F, 5.5F,
                        new CubeDeformation(0.0F))
                .texOffs(0, 0)
                .addBox(-0.25F, -12.25F, -8.25F, 8.5F, 12.5F, 4.5F,
                        new CubeDeformation(0.0F)),
                PartPose.offset(-4.0F, 12.0F, 6.0F));

        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    protected Iterable<ModelPart> bodyParts()
    {
        return ImmutableList.of();
    }

    @SubscribeEvent
    public static void bakeModelLayers(EntityRenderersEvent.AddLayers event)
    {
        EntityModelSet entityModelSet = event.getEntityModels();
        INSTANCE = new NetheriteGearModel(entityModelSet.bakeLayer(Layers.NETHERITE_GEAR));
    }
}
