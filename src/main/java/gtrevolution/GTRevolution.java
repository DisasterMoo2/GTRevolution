package gtrevolution;

import org.apache.logging.log4j.Logger;

import gtrevolution.block.MetaBlocks;
import gtrevolution.item.MetaItems;
import gtrevolution.machines.TileEntities;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GTRevolution.MODID,
name = GTRevolution.NAME,
version = GTRevolution.VERSION,
dependencies = "required-after:gregtech")
public class GTRevolution
{
	public static final String MODID = "gtrevolution";
    public static final String NAME = "GT Revolution";
    public static final String VERSION = "@VERSION@";
    
    @SidedProxy(
            modId = MODID,
            clientSide = "gtrevolution.ClientProxy",
            serverSide = "gtrevolution.CommonProxy"
    )
    private static CommonProxy proxy;
    
    public static Logger logger;

    public GTRevolution() {
        
    }
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        MetaItems.init();
        MetaBlocks.init();
        TileEntities.init();
        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit();
    }
}
