package gtrevolution.item;

import gregtech.api.items.metaitem.MetaItem;

public class MetaItems
{
    public static MetaItem<?>.MetaValueItem OIL_SCANNER;

    public static MetaTool tools = new MetaTool();

    public static void init() {
        tools.setRegistryName("gr_meta_tool");
    }
}
