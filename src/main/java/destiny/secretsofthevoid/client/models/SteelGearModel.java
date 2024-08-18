package destiny.secretsofthevoid.client.models;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class SteelGearModel extends HumanoidModel<LivingEntity>
{
    public static SteelGearModel INSTANCE;

    public SteelGearModel(ModelPart root)
    {
        super(root);
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
        PartDefinition root = mesh.getRoot();

        PartDefinition head = root.getChild("head");
        PartDefinition body = root.getChild("body");

        //Rebreather
        head.addOrReplaceChild("mouth_cover", CubeListBuilder.create()
                .texOffs(22, 0)
                .addBox(5.0F, 22.0F, 2.0F, 6.0F, 3.0F, 3.0F,
                        new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("tube_right", CubeListBuilder.create()
                        .texOffs(22, 10)
                        .addBox(11.0F, 23.0F, 2.0F, 2.0F, 2.0F, 8.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("tube_left", CubeListBuilder.create()
                        .texOffs(22, 20)
                        .addBox(3.0F, 23.0F, 3.0F, 2.0F, 2.0F, 8.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        head.addOrReplaceChild("tube_back", CubeListBuilder.create()
                        .texOffs(22, 6)
                        .addBox(3.0F, 23.0F, 11.0F, 10.0F, 2.0F, 2.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        //Air tank
        body.addOrReplaceChild("valve", CubeListBuilder.create()
                        .texOffs(0, 16)
                        .addBox(6.5F, 23.0F, 11.0F, 3.0F, 2.0F, 3.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("tank", CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(5.5F, 12.0F, 10.0F, 5.0F, 11.0F, 5.0F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("strap_body", CubeListBuilder.create()
                        .texOffs(0, 40)
                        .addBox(3.75F, 11.75F, 5.75F, 8.5F, 12.5F, 4.5F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("strap_tank", CubeListBuilder.create()
                        .texOffs(0, 29)
                        .addBox(5.25F, 11.75F, 9.75F, 5.5F, 11.5F, 5.5F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        //Flippers


        return LayerDefinition.create(mesh, 64, 64);
    }

    @Override
    protected Iterable<ModelPart> bodyParts()
    {
        return ImmutableList.of();
    }
}
