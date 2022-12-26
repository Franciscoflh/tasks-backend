package utils;

import br.com.francisco.taskbackend.repo.TaskRepo;
import br.com.francisco.taskbackend.utils.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.time.LocalDate;


public class DateUtilsTest {

    @Test
    public void shouldReturnTrueToFutureDates(){
        LocalDate date = LocalDate.of(2030,01,01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnFalseToPastDate(){
        LocalDate date = LocalDate.of(2021, 12, 11);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(date));
    }

    @Test
    public void shouldReturnTrueToPresentDate(){
        LocalDate date = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(date));
    }
}
