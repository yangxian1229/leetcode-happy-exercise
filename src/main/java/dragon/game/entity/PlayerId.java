package dragon.game.entity;

import lombok.Value;

/**
 * @author yangxian007
 * @date 2024/1/22
 */
@Value
public class PlayerId {
    private Long id;

    public PlayerId(Long id) {
        this.id = id;
    }
}
