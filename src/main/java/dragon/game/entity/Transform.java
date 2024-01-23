package dragon.game.entity;

import lombok.Value;

/**
 * 位置信息（二维）
 * @author yangxian007
 * @date 2024/1/22
 */
@Value
public class Transform {
    public static final Transform ORIGIN = new Transform(0, 0);
    long x;
    long y;
}
