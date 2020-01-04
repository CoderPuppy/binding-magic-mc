package cpup.mc.bindingMagic

import cpup.mc.lib.CPupMod
import cpup.mc.lib.client.CPupGUIManager
import cpup.mc.lib.network.CPupNetwork
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.common.Mod.EventHandler
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent

@Mod(modid = Ref.modID, modLanguage = "scala", dependencies = "required-after:cpup-mc")
object BindingMagic extends CPupMod[Ref.type] {
	override def ref = Ref

	lazy val gui = new CPupGUIManager[this.type](this, List(

	))

	@EventHandler
	override def preInit(e: FMLPreInitializationEvent) {
		super.preInit(e)
		gui.register
	}

	val net = new CPupNetwork[AnyRef](ref.modID, new AnyRef, CPupNetwork.simpleNetwork[this.type](this), Set(

	))
}
