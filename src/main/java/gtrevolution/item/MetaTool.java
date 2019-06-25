package gtrevolution.item;

import gregtech.api.items.metaitem.ElectricStats;
import gregtech.api.items.toolitem.ToolMetaItem;
import gtrevolution.item.tools.OilScanner;

public class MetaTool extends ToolMetaItem<ToolMetaItem<?>.MetaToolValueItem>
{
    @Override
    public void registerSubItems(){
        MetaItems.OIL_SCANNER = addItem(0,"tool.oil_scanner")
                .setToolStats(new OilScanner())
                .addStats(new OilScanner.Behaviour())
                .addStats(ElectricStats.createElectricItem(1600000L, 3L));
    }
}