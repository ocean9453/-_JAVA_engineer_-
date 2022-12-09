package com.cathayunitedbank.interview.coindesk;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import com.cathayunitedbank.interview.entity.CoinEntity.Bpi;
import com.cathayunitedbank.interview.repository.BaseRepo;

// @RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
// @ExtendWith(SpringExtension.class) // jUnit4
@ExtendWith(MockitoExtension.class) // jUnit5
// @SpringBootTest
@DataJpaTest
public class RepoTest {

    @Spy
    private BaseRepo<Bpi, Long> container;

    @Test
    public void savetest(){

        Bpi b1 = new Bpi();
        b1.setCode("USD");
        b1.setDescription("US Dollar");
        b1.setRate("20200.10066");
        b1.setRate_float("19283.182");
        b1.setSymbol("\\u0024");
        Bpi b2 = new Bpi();
        b2.setCode("USDT");
        b2.setDescription("USDDD");
        b2.setRate("20201.10066");
        b2.setRate_float("100083.182");
        b2.setSymbol("\\u0555");
        
        List<Bpi> list = Arrays.asList(b1,b2);
        
        when(container.saveAll(anyList())).thenReturn(list);
        // certain behavior
        // container.saveAll(list);
        // times == excute times; save one || all ( save what )
        List<Bpi> b3 = container.saveAll(list);
        assertEquals(list, b3);
        verify(container, times(1)).saveAll(anyList());
    }
    @Commit
    @Transactional
    // @SqlGroup({
    //     @Sql(scripts = "classpath:schema.sql",
    //       config = @SqlConfig(transactionMode = TransactionMode.ISOLATED)
    //     ),
    // })
    @Sql("data.sql")
    @Test
    public void jpaUnit() {
        List<Bpi> list = container.findAll();
        // must import this 
        // import static org.assertj.core.api.Assertions.assertThat
        // assertThat(list).isEmpty();
        list.forEach((e) -> System.out.println(e.toString()));

        assertEquals(3, list.size());
    }
}
