package dragon.game.entity;

import lombok.Value;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
@Value
public class Vector {
    public static final Vector ZERO = new Vector(0, 0);
    long x;
    long y;
}
