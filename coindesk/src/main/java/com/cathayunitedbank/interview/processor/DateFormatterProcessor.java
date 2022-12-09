package com.cathayunitedbank.interview.processor;

import static com.cathayunitedbank.interview.util.CommonUtil.getFormattedDateStr;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import com.cathayunitedbank.interview.entity.CoinEntity.UpdateTime;

@Component
public class DateFormatterProcessor implements ItemProcessor<UpdateTime, UpdateTime>{
	
    @Override
    @Nullable
    public UpdateTime process(@NonNull UpdateTime item) throws Exception {
        // item.setUpdated(getFormattedDateStr(item.getUpdated(),0));
        item.setUpdatedISO(getFormattedDateStr(item.getUpdatedISO(),1));
        // item.setUpdateduk(getFormattedDateStr(item.getUpdateduk(),2));
        return item;
    }

}
