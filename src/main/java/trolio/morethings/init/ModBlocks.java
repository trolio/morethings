package trolio.morethings.init;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import trolio.morethings.blocks.CopperBlock;
import trolio.morethings.blocks.WhiteGlass.WhiteGlassDoubleSlab;
import trolio.morethings.blocks.WhiteGlass.WhiteGlassHalfSlab;

public class ModBlocks 
{
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	//slabs
	public static WhiteGlassHalfSlab slabWhiteGlassHalf;
	public static WhiteGlassDoubleSlab slabWhiteGlassDouble;
	
	public static Block blockCopper;
	
	public static void init()
	{
		slabWhiteGlassHalf = new WhiteGlassHalfSlab("slab_whiteglass_half");
		slabWhiteGlassDouble = new WhiteGlassDoubleSlab("slab_whiteglass_double");
		
		blockCopper = new CopperBlock("block_copper");
	}
	
	public static void register()
	{
		registerBlock(slabWhiteGlassHalf, new ItemSlab(slabWhiteGlassHalf, slabWhiteGlassHalf, slabWhiteGlassDouble));
		
		registerBlock(blockCopper);
	}
	
	public static void registerBlock (Block block)
	{
		ForgeRegistries.BLOCKS.register(block);
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
	public static void registerBlock (Block block, ItemBlock itemblock)
	{
		ForgeRegistries.BLOCKS.register(block);
		itemblock.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(itemblock);
		
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
}
