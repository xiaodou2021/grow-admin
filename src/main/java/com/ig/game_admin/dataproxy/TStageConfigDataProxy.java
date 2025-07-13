package com.ig.game_admin.dataproxy;

import cn.hutool.core.util.IdUtil;
import com.ig.game_admin.entity.TItemConfigEntity;
import com.ig.game_admin.entity.TStageConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.erupt.annotation.fun.DataProxy;
import xyz.erupt.upms.service.EruptUserService;

import java.util.Date;
import java.util.Random;

@Component
public class TStageConfigDataProxy implements DataProxy<TStageConfigEntity> {
    @Autowired
    private EruptUserService eruptUserService;
    @Override
    public void beforeAdd(TStageConfigEntity tStageConfigEntity) {
        String stageId = IdUtil.getSnowflake(1).nextIdStr();
        tStageConfigEntity.setStageId(stageId);
        tStageConfigEntity.setCreateUser(eruptUserService.getCurrentEruptUser().getCreateUser());
        tStageConfigEntity.setUpdateUser(eruptUserService.getCurrentEruptUser().getUpdateUser());
        Date now = new Date();
        tStageConfigEntity.setCreateTime(now);
        tStageConfigEntity.setUpdateTime(now);
    }

    @Override
    public void beforeUpdate(TStageConfigEntity tStageConfigEntity) {
        Date now = new Date();
        tStageConfigEntity.setUpdateTime(now);
        tStageConfigEntity.setUpdateUser(eruptUserService.getCurrentEruptUser().getUpdateUser());
    }
}
