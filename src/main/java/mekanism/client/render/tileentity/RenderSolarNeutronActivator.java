package mekanism.client.render.tileentity;

import java.io.IOException;

import mekanism.common.tile.TileEntitySolarNeutronActivator;
import mekanism.common.util.MekanismUtils;
import mekanism.common.util.MekanismUtils.ResourceType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.obj.OBJLoader;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSolarNeutronActivator extends TileEntitySpecialRenderer<TileEntitySolarNeutronActivator>
{
	private IModel model;
	
	public RenderSolarNeutronActivator()
	{
		try
		{
			model = OBJLoader.instance.loadModel(MekanismUtils.getResource(ResourceType.MODEL, "solar_tri.obj"));
		}
		catch(IOException e)
		{}
	}
	
	@Override
	public void renderTileEntityAt(TileEntitySolarNeutronActivator tileEntity, double x, double y, double z, float partialTick, int destroyStage)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x+0.5F, (float)y, (float)z+0.5F);
		GL11.glScalef(0.5F, 0.5F, 0.5F);
		bindTexture(MekanismUtils.getResource(ResourceType.RENDER, "SolarNeutronActivator.png"));
		
		switch(tileEntity.facing)
		{
			case 2: GL11.glRotatef(0, 0.0F, 1.0F, 0.0F); break;
			case 3: GL11.glRotatef(180, 0.0F, 1.0F, 0.0F); break;
			case 4: GL11.glRotatef(90, 0.0F, 1.0F, 0.0F); break;
			case 5: GL11.glRotatef(270, 0.0F, 1.0F, 0.0F); break;
		}
		
		model.renderAll();
		GL11.glPopMatrix();
	}
}
