package au.com.mineauz.BuildIt.pattern;

import org.bukkit.util.BlockVector;

import au.com.mineauz.BuildIt.types.BlockType;

public class TiledPattern implements Pattern
{
	private BlockType mA, mB;
	
	public TiledPattern(BlockType a, BlockType b)
	{
		mA = a;
		mB = b;
	}
	
	@Override
	public BlockType getBlockType( BlockVector offset )
	{
		if(offset.getBlockX() % 2 == 0)
		{
			if(offset.getBlockZ() % 2 == 0)
			{
				if(offset.getBlockY() % 2 == 0)
					return mA;
				else
					return mB;
			}
			else
			{
				if(offset.getBlockY() % 2 == 0)
					return mB;
				else
					return mA;
			}
		}
		else
		{
			if(offset.getBlockZ() % 2 == 0)
			{
				if(offset.getBlockY() % 2 == 0)
					return mB;
				else
					return mA;
			}
			else
			{
				if(offset.getBlockY() % 2 == 0)
					return mA;
				else
					return mB;
			}
		}
	}
	
	public static TiledPattern parse(String patternString) throws IllegalArgumentException
	{
		String[] blocks = patternString.split(",");
		if(blocks.length != 2)
			throw new IllegalArgumentException("Tiled pattern requires exactly 2 block types");
		
		BlockType a = BlockType.parse(blocks[0]);
		BlockType b = BlockType.parse(blocks[1]);
		
		return new TiledPattern(a, b);
	}

}
