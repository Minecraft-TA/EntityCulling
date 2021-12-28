package dev.tr7zw.entityculling;


import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

@Mod(modid = "entityculling", name = "EntityCulling", version = "@VER@")
public class EntityCullingMod extends EntityCullingModBase {

    //Forge only
    private boolean onServer = false;
    
    public EntityCullingMod() {
        try {
            Class clientClass = net.minecraft.client.Minecraft.class;
        }catch(Throwable ex) {
            System.out.println("EntityCulling Mod installed on a Server. Going to sleep.");
            onServer = true;
            return;
        }
        onInitialize();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void initModloader() {
        ClientRegistry.registerKeyBinding(keybind);
   }
    
    @SubscribeEvent
    public void doClientTick(ClientTickEvent event) {
        this.clientTick();
    }
    
    @SubscribeEvent
    public void doWorldTick(WorldTickEvent event) {
        this.worldTick();
    }
    
}
