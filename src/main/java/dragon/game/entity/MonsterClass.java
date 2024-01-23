package dragon.game.entity;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public enum MonsterClass {
    ORC("orc", "兽人"),
    ELF("elf", "精灵"),
    DRAGON("dragon", "龙");
    private String code;
    private String desc;

    MonsterClass(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
