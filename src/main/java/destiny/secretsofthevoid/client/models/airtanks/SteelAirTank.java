package destiny.secretsofthevoid.client.models.airtanks;

import com.google.common.collect.ImmutableList;
import destiny.secretsofthevoid.SecretsOfTheVoid;
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

@Mod.EventBusSubscriber(modid = SecretsOfTheVoid.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class SteelAirTank extends HumanoidModel<LivingEntity>
{
    public static SteelAirTank INSTANCE;

    public SteelAirTank(ModelPart root)
    {
        super(root);
    }

    public static LayerDefinition createBodyLayer()
    {
        MeshDefinition mesh = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0f);
        PartDefinition root = mesh.getRoot();

        PartDefinition body = root.getChild("body");

        body.addOrReplaceChild("tank", CubeListBuilder.create()
                .texOffs(15, 5)
                .addBox(5.5F, 12.0F, 10.0F, 5.0F, 11.0F, 5.0F,
                        new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("cover", CubeListBuilder.create()
                        .texOffs(15, 34)
                        .addBox(5.25F, 11.75F, 9.75F, 5.5F, 11.5F, 5.5F,
                                new CubeDeformation(1.0F)),
                PartPose.ZERO);

        body.addOrReplaceChild("tip", CubeListBuilder.create()
                        .texOffs(12, 19)
                        .addBox(6.5F, 23.0F, 11.0F, 3.0F, 2.0F, 3.0F,
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
    public void setupAnim(LivingEntity pEntity, float pLimbSwing, float pLimbSwingAmount, float pAgeInTicks, float pNetHeadYaw, float pHeadPitch)
    {

    }

    @Override
    protected Iterable<ModelPart> bodyParts()
    {
        return ImmutableList.of();
    }

    @SubscribeEvent
    public void bakeModelLayers(EntityRenderersEvent.AddLayers event)
    {
        EntityModelSet entityModelSet = event.getEntityModels();
        INSTANCE = new SteelAirTank(entityModelSet.bakeLayer(Layers.STEEL_DIVING_GEAR));
    }

}
