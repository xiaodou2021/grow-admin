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
import xyz.erupt.annotation.sub_field.sub_edit.DateType;
import xyz.erupt.annotation.sub_field.sub_edit.Search;
import xyz.erupt.upms.model.base.HyperModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;



@Erupt(
        name = "用户道具表"
)
@Table(name = "t_user_items")   //数据库表名
@Entity
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
public class TUserItemsEntity extends HyperModel{

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
                    title = "道具ID",
                    width = "120"
            ),
            edit = @Edit(
                    title = "道具ID",
                    notNull = true,
                    search = @Search
            )
    )
    private Integer itemId;

    @EruptField(
            views = @View(
                    title = "数量",
                    width = "120"
            ),
            edit = @Edit(
                    title = "数量",
                    search = @Search
            )
    )
    private Integer quantity;

    @EruptField(
            views = @View(
                    title = "获取时间",
                    width = "120"
            ),
            edit = @Edit(
                    title = "获取时间",
                    type = EditType.DATE,
                    dateType = @DateType(type = DateType.Type.DATE),
                    search = @Search
            )
    )
    private Date acquireTime;

    @EruptField(
            views = @View(
                    title = "最后使用时间",
                    width = "120"
            ),
            edit = @Edit(
                    title = "最后使用时间",
                    type = EditType.DATE,
                    dateType = @DateType(type = DateType.Type.DATE)
            )
    )
    private Date lastUseTime;

}

