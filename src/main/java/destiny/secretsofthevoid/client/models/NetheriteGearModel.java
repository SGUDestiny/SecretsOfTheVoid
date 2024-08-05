package destiny.secretsofthevoid.client.models;

import com.google.common.collect.ImmutableList;
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
        head.addOrReplaceChild("mouth_cover", CubeListBuilder.create()
                .texOffs(3, 3)
                .addBox(5.0F, 22.0F, 2.0F, 6.0F, 3.0F, 3.0F,
                        new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("line1", CubeListBuilder.create()
                        .texOffs(8, 28)
                        .addBox(3.0F, 23.0F, 3.0F, 2.0F, 2.0F, 8.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("line2", CubeListBuilder.create()
                        .texOffs(12, 8)
                        .addBox(3.0F, 23.0F, 11.0F, 10.0F, 2.0F, 2.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("line3", CubeListBuilder.create()
                        .texOffs(8, 18)
                        .addBox(11.0F, 23.0F, 3.0F, 2.0F, 8.0F, 8.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("ear_l", CubeListBuilder.create()
                        .texOffs(4, 39)
                        .addBox(2.0F, 24.0F, 6.0F, 3.0F, 6.0F, 4.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("ear_r", CubeListBuilder.create()
                        .texOffs(4, 49)
                        .addBox(11.0F, 24.0F, 6.0F, 3.0F, 6.0F, 4.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("eyes", CubeListBuilder.create()
                        .texOffs(1, 31)
                        .addBox(5.0F, 25.0F, 3.0F, 6.0F, 4.0F, 1.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        //Double Backtank
        body.addOrReplaceChild("tank", CubeListBuilder.create()
                .texOffs(20, 5)
                .addBox(3F, 14.0F, 10.0F, 10.0F, 11.0F, 5.0F,
                        new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("cover", CubeListBuilder.create()
                        .texOffs(20, 34)
                        .addBox(2.75F, 13.75F, 9.75F, 10.5F, 11.5F, 5.5F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("bottom", CubeListBuilder.create()
                        .texOffs(14, 26)
                        .addBox(4F, 11.0F, 10.0F, 8.0F, 3.0F, 3.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("tip1", CubeListBuilder.create()
                        .texOffs(24, 19)
                        .addBox(9F, 25.0F, 11.0F, 3.0F, 2.0F, 3.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("tip_connector", CubeListBuilder.create()
                        .texOffs(8, 22)
                        .addBox(5F, 27.0F, 12.0F, 6.0F, 1.0F, 1.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("tip2", CubeListBuilder.create()
                        .texOffs(12, 19)
                        .addBox(4F, 25.0F, 11.0F, 3.0F, 2.0F, 3.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("strap", CubeListBuilder.create()
                        .texOffs(16, 44)
                        .addBox(3.75F, 11.75F, 5.75F, 8.5F, 12.5F, 4.5F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

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
