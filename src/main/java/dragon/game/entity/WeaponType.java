package dragon.game.entity;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
public enum WeaponType {
    SWORD("sword", "剑"),
    STAFF("staff", "法杖"),
    DAGGER("dagger", "匕首");
    private String type;
    private String desc;

    WeaponType(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
