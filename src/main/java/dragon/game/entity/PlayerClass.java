package dragon.game.entity;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public enum PlayerClass {
    FIGHTER("fighter", "战士"),
    MAGE("mage", "法师"),
    DRAGOON("dragoon", "龙骑");
    private String code;
    private String desc;

    PlayerClass(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
