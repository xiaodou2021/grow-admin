package com.ig.game_admin.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import xyz.erupt.annotation.Erupt;
import xyz.erupt.annotation.EruptField;
import xyz.erupt.annotation.sub_erupt.Power;
import xyz.erupt.annotation.sub_field.Edit;
import xyz.erupt.annotation.sub_field.EditType;
import xyz.erupt.annotation.sub_field.View;
import xyz.erupt.annotation.sub_field.sub_edit.ChoiceType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.VL;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;



@Erupt(
        name = "关卡配置表"
)
@Table(name = "t_stage_config")   //数据库表名
@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class TStageConfigEntity extends HyperModel{

    @Column(nullable = false, unique = true)
    @EruptField(
            views = @View(
                    title = "关卡ID",
                    width = "120"
            ),
            edit = @Edit(
                    title = "关卡ID",
                    show = false,
                    search = @Search
            )
    )
    private String stageId;

    @Column(length = 100, nullable = false)
    @EruptField(
            views = @View(
                    title = "关卡名称",
                    width = "120"
            ),
            edit = @Edit(
                    title = "关卡名称",
                    notNull = true,
                    search = @Search
            )
    )
    private String stageName;

    @EruptField(
            views = @View(
                    title = "难度",
                    desc = "难度：1-5",
                    width = "120"
            ),
            edit = @Edit(
                    title = "难度",
                    desc = "难度：1-5",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "1", label = "1"),
                            @VL(value = "2", label = "2"),
                            @VL(value = "3", label = "3"),
                            @VL(value = "4", label = "4"),
                            @VL(value = "5", label = "5")
                    }),
                    search = @Search
            )
    )
    private Integer difficulty;

    @EruptField(
            views = @View(
                    title = "目标分数",
                    width = "120"
            ),
            edit = @Edit(
                    title = "目标分数",
                    search = @Search
            )
    )
    private Integer targetScore;

    @EruptField(
            views = @View(
                    title = "步数限制",
                    width = "120"
            ),
            edit = @Edit(
                    title = "步数限制"
            )
    )
    private Integer moveLimit;

    @EruptField(
            views = @View(
                    title = "奖励钻石数",
                    width = "120"
            ),
            edit = @Edit(
                    title = "奖励钻石数"
            )
    )
    private Integer rewardGems;

    @EruptField(
            views = @View(
                    title = "奖励卡牌数",
                    width = "120"
            ),
            edit = @Edit(
                    title = "奖励卡牌数"
            )
    )
    private Integer rewardCards;

    @EruptField(
            views = @View(
                    title = "需要体力值",
                    width = "120"
            ),
            edit = @Edit(
                    title = "需要体力值"
            )
    )
    private Integer consumeExp;

    @EruptField(
            views = @View(
                    title = "是否boss关卡",
                    width = "120"
            ),
            edit = @Edit(
                    title = "是否boss关卡",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "1", label = "1"),
                            @VL(value = "2", label = "2"),
                            @VL(value = "4", label = "4"),
                            @VL(value = "3", label = "3")
                    })
            )
    )
    private Integer isBossStage;

}

