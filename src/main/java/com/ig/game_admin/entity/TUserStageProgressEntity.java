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
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.annotation.sub_field.sub_edit.VL;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;



@Erupt(
        name = "用户关卡进度表"
)
@Table(name = "t_user_stage_progress")   //数据库表名
@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class TUserStageProgressEntity extends HyperModel{

    @Column(length = 64, nullable = false)
    @EruptField(
            views = @View(
                    title = "用户编号",
                    width = "120"
            ),
            edit = @Edit(
                    title = "用户编号",
                    notNull = true,
                    search = @Search
            )
    )
    private String userNo;

    @Column(nullable = false)
    @EruptField(
            views = @View(
                    title = "关卡ID",
                    width = "120"
            ),
            edit = @Edit(
                    title = "关卡ID",
                    notNull = true,
                    search = @Search
            )
    )
    private Integer stageId;

    @EruptField(
            views = @View(
                    title = "最佳分数",
                    width = "120"
            ),
            edit = @Edit(
                    title = "最佳分数",
                    search = @Search
            )
    )
    private Integer bestScore;

    @EruptField(
            views = @View(
                    title = "游玩次数",
                    width = "120"
            ),
            edit = @Edit(
                    title = "游玩次数",
                    search = @Search
            )
    )
    private Integer playCount;

    @EruptField(
            views = @View(
                    title = "通关次数",
                    width = "120"
            ),
            edit = @Edit(
                    title = "通关次数"
            )
    )
    private Integer winCount;

    @EruptField(
            views = @View(
                    title = "是否已通过",
                    width = "120"
            ),
            edit = @Edit(
                    title = "是否已通过",
                    type = EditType.CHOICE,
                    choiceType = @ChoiceType(vl = {
                            @VL(value = "0", label = "0"),
                            @VL(value = "1", label = "1"),
                            @VL(value = "3", label = "3"),
                            @VL(value = "2", label = "2")
                    })
            )
    )
    private Integer isPassed;

    @EruptField(
            views = @View(
                    title = "最后游玩时间",
                    width = "120"
            ),
            edit = @Edit(
                    title = "最后游玩时间",
                    type = EditType.DATE,
                    dateType = @DateType(type = DateType.Type.DATE)
            )
    )
    private Date lastPlayTime;
}

