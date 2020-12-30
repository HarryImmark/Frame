package service;

import model.Promocode;
import model.User;

public class PromocodeCreator
{
    public static final String TESTDATA_PROMOCODE = "testdata.promocode";

    public static Promocode withCredentialsCode()
    {
        return new Promocode(TestDataReader.getTestData(TESTDATA_PROMOCODE));
    }
}
